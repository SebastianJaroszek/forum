package pl.forum.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.forum.dto.UserDto;

@Controller
public class RegistrationController {

    @GetMapping(value = "/registration")
    public ModelAndView showRegistrationPage(){
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("newUser", new UserDto());
        return mav;
    }

}