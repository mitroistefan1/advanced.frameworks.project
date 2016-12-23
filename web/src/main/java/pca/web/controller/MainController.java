package pca.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {

        return "home";

    }

    @RequestMapping(value = "/loguser", method = RequestMethod.GET)
    public String logUser() {

        return "loguser";

    }

    @RequestMapping(value = "/publichome", method = RequestMethod.GET)
    public String publicHome() {

        return "publichome";

    }
}
