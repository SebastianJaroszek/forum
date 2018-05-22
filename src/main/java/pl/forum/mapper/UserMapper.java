package pl.forum.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.forum.dto.MyUserPrincipalDto;
import pl.forum.dto.UserDto;
import pl.forum.entity.User;
import pl.forum.type.RoleType;

import java.util.ArrayList;
import java.util.List;

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
                .role(userDto.getRole())
                .build();
    }

    public MyUserPrincipalDto mapUserToMyUserPrincipalDto(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return MyUserPrincipalDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }

}
