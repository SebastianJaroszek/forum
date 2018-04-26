package pl.forum.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.forum.entity.User;
import pl.forum.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired


    public void createUser(){
        User user = User.builder()
                .login("Mateusz")
                .password("mati123")
                .email("mpindral@o2.pl")
                .build();
        userRepository.save(user);
    }

}
