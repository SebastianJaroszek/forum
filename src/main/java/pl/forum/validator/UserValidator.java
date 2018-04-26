package pl.forum.validator;

import org.springframework.stereotype.Component;
import pl.forum.dto.UserDto;

import java.io.UnsupportedEncodingException;

@Component
public class UserValidator {

    //TODO refactoring tutaj: wywalic komunikaty, zostawic sam boolean prawidlowo/nieprawidlowo; komunikaty w javascript clientside

    private static final String USABLE_CHARACTERS = "qwertyuiopasdfghjklzxcvbnm1234567890-_@#$^*+=|][/?.,><";

    public String validateUser(UserDto userDto) {
        String validResult;
        validResult = validString(userDto.getNickname());
        if (validResult == null) {
            validResult = validString(userDto.getEmail());
        }
        if (validResult == null) {
            validResult = validString(userDto.getPassword());
        }
        if (validResult == null) {
            validResult = validPasswords(userDto.getPassword(), userDto.getConfirmPassword());
        }
        if (validResult == null){
            validResult = validEmail(userDto.getEmail());
        }
        return validResult;
    }

    private String validEmail(String email) {
        if (!email.contains("@")) {
            return "Wrong e-mail address.";
        }
        return null;
    }

    private String validPasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return "Passwords are different.";
        }
        return null;
    }

    private String validString(String field) {
        if (field == null || field.length() < 1) {
            return "Field can't be empty.";
        } else if (field.length() > 60) {
            return "Field value is too long. Max is 60 characters.";
        }
        return validCharacters(field);
    }

    private String validCharacters(String field) {
        for (int i = 0; i < field.length(); i++) {
            if (!USABLE_CHARACTERS.contains(field.subSequence(i, i + 1))
                    && !USABLE_CHARACTERS.toUpperCase().contains(field.subSequence(i, i + 1))) {
                return "Field contains unusable character(s). Characters what you can use: " + USABLE_CHARACTERS + ".";
            }
        }
        return null;
    }

}
