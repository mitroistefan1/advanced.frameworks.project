package pca.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pca.persistence.dto.UserDto;
import pca.service.authentication.AuthenticationService;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/login")
    public ModelAndView showform() {

        return new ModelAndView("login", "command", new UserDto());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") UserDto user) {

        if (authenticationService.isUserValid(user)) {
            return new ModelAndView("home");
        } else {
            return new ModelAndView("error");
        }

    }

}
