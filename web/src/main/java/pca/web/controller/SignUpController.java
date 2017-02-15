package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pca.service.data.UserData;
import pca.service.authentication.AuthenticationService;

@Controller
public class SignUpController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/signup")
    public ModelAndView showSignUpForm() {

        return new ModelAndView("signup", "command", new UserData());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") UserData user) {
        authenticationService.creatUser(user);
        return "redirect:/";

    }

}