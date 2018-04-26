package pl.forum.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.forum.dto.UserDto;
import pl.forum.entity.User;

@Component
public class UserMapper {

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserMapper(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public User mapUserDtoToUser(UserDto userDto){
        return User.builder()
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .build();
    }

}
