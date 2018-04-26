package pl.forum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import pl.forum.dto.UserDto;
import pl.forum.validator.UserValidator;

public class UserValidatorTest {

    @InjectMocks
    private UserValidator userValidator;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateUserShouldReturnNullWhenThereAreNotAnyError(){
        //given
        //when
        //then
        UserDto user = UserDto.builder()
                .nickname("asfdqwr")
                .email("fasd@casd.pl")
                .password("sfafsadfsa")
                .confirmPassword("sfafsadfsa")
                .build();
        String validateResult = userValidator.validateUser(user);

        Assert.assertNull(validateResult);

    }

    @Test
    public void validateUserShouldReturnMessageWhenThereAreNotFilledField(){
        UserDto user = UserDto.builder()
                .nickname("asfdqwr")
                .email("")
                .password("")
                .confirmPassword("sfafsadfsa")
                .build();
        String validateResult = userValidator.validateUser(user);

        Assert.assertEquals("Field can't be empty.", validateResult);
    }

    @Test
    public void validateUserShouldReturnMessageWhenThereAreTooLongValueInField(){
        UserDto user = UserDto.builder()
                .nickname("asfdqwrasdasfdqwrasdasfdqwrasdasfdqwrasdasfdqwrasdasfdqwrasdasfdqwrasd")
                .build();
        String validateResult = userValidator.validateUser(user);

        Assert.assertEquals("Field value is too long. Max is 60 characters.", validateResult);
    }

    @Test
    public void validateUserShouldReturnMessageAboutUnacceptableCharacters(){
        UserDto user = UserDto.builder()
                .nickname("ąśćłó~")
                .build();
        String validateResult = userValidator.validateUser(user);

        Assert.assertEquals(
                "Field contains unusable character(s). Characters what you can use: " +
                        "qwertyuiopasdfghjklzxcvbnm1234567890-_@#$^*+=|][/?.,><.", validateResult);
    }

    @Test
    public void validateUserShouldReturnMessageAboutDifferentPasswords(){
        UserDto user = UserDto.builder()
                .nickname("nickname")
                .email("email@email.pl")
                .password("asdfa")
                .confirmPassword("1234f")
                .build();
        String validateResult = userValidator.validateUser(user);

        Assert.assertEquals("Passwords are different.", validateResult);
    }

    @Test
    public void validateUserShouldReturnMessageAboutWrongEmailAddress(){
        UserDto user = UserDto.builder()
                .nickname("nickname")
                .email("email")
                .password("asdfa")
                .confirmPassword("asdfa")
                .build();
        String validateResult = userValidator.validateUser(user);

        Assert.assertEquals("Wrong e-mail address.", validateResult);
    }
}
