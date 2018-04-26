package pl.forum.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.forum.dto.UserDto;
import pl.forum.entity.User;
import pl.forum.mapper.UserMapper;
import pl.forum.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void createUser(UserDto userDto){
        User user = userMapper.mapUserDtoToUser(userDto);
        userRepository.save(user);
    }

}
