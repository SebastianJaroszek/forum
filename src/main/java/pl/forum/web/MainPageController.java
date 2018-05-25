package pl.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.forum.bo.ThreadFinder;

@Controller
public class MainPageController {

    private ThreadFinder threadFinder;

    @Autowired
    public MainPageController(ThreadFinder threadFinder) {
        this.threadFinder = threadFinder;
    }

    @GetMapping(value = "/main")
    public ModelAndView showMainPage() {
        ModelAndView mav = new ModelAndView("main");

        mav.addObject("threads", threadFinder.findAllThreads());

        return mav;
    }

}
