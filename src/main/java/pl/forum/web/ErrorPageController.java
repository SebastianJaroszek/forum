package pl.forum.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorPageController {

    @GetMapping(value = "/error")
    public String showErrorPage() {
        return "error";
    }

    @PostMapping(value = "/error")
    public String showPostErrorPage() {
        return "error";
    }

}
