package pl.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.forum.bo.UserService;
import pl.forum.dto.UserDto;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/registration")
    public ModelAndView showRegistrationPage(){
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("newUser", new UserDto());
        userService.createUser();
        return mav;
    }

}
