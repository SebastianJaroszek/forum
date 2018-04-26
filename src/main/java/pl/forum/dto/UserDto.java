package pl.forum.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String nickname;
    private String password;
    private String confirmPassword;
    private String email;

}
