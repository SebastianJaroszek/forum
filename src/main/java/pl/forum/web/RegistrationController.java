package pl.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.forum.bo.UserService;
import pl.forum.dto.UserDto;
import pl.forum.validator.UserValidator;

@Controller
public class RegistrationController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public RegistrationController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }


    @GetMapping(value = "/registration")
    public ModelAndView showRegistrationPage(){
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("newUser", new UserDto());
        return mav;
    }

    @PostMapping(value = "/registration")
    public ModelAndView registerNewUser(@ModelAttribute("newUser") UserDto newUser){
        ModelAndView mav = new ModelAndView("registrationResult");
        String message = userValidator.validateUser(newUser);
        if (message == null){
            try {
                userService.createUser(newUser);
            } catch (DataIntegrityViolationException e) {
                message = "This e-mail is already in use.";
            }
        }
        mav.addObject("message", message == null ? "Registration was successful." : message);
        return mav;
    }

}
