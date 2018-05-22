package pl.forum.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.forum.dto.UserDto;
import pl.forum.entity.User;
import pl.forum.mapper.UserMapper;
import pl.forum.repository.UserRepository;
import pl.forum.type.RoleType;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    public void createUser(UserDto userDto){
        userDto.setRole(RoleType.USER);
        User user = userMapper.mapUserDtoToUser(userDto);
        userRepository.save(user);
    }

    public String loginUser(UserDto userDto) {
        String hash = encoder.encode(userDto.getPassword());
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            return "There are not user with this e-mail in database.";
        }
        if (!hash.equals(user.getPassword())){
            return "Wrong password.";
        }
        return "Login was successful";
    }
}
