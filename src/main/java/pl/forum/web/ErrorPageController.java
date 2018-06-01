package pl.forum.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorPageController {

    @GetMapping(value = "/error")
    public String showErrorPage() {
        return "error";
    }

    @GetMapping(value = "/error/auth")
    public ModelAndView authenticationError(){
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", "You filled fields with wrong value(s).");
        return mav;
    }

    @PostMapping(value = "/error")
    public String showPostErrorPage() {
        return "error";
    }

}
