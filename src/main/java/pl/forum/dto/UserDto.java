package pl.forum.dto;

import lombok.*;
import pl.forum.type.RoleType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String nickname;
    private String password;
    private String confirmPassword;
    private RoleType role;
    private String email;

}
