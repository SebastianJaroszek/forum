package pl.forum.entity;

import lombok.*;
import pl.forum.type.RoleType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private RoleType role;

}
