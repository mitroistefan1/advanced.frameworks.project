package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pca.persistence.dao.UserDao;
import pca.persistence.dto.UserDto;
import pca.persistence.model.User;
import pca.service.authentication.AuthenticationService;
import pca.service.authentication.Converter;

@Controller
public class SignUpController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/signup")
    public ModelAndView showform() {

        return new ModelAndView("signup", "command", new UserDto());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") UserDto user) {
        authenticationService.creatUser(user);
        return "publichome";

    }

}