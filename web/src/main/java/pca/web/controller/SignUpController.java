package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pca.service.data.UserData;
import pca.auth.authentication.AuthenticationService;

@Controller
public class SignUpController {

  @Autowired
  private AuthenticationService authenticationService;

  @RequestMapping("/signup")
  public ModelAndView showSignUpForm() {

    return new ModelAndView("signup", "command", new UserData());
  }


  @RequestMapping(value = "signup/validation/{userToken}", method = RequestMethod.GET)
  public String validate(@PathVariable String userToken) {

    UserData user = authenticationService.getUserByToken(userToken);
    user.setValid(true);
    authenticationService.updateUser(user);
    return "redirect:/";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String save(@ModelAttribute("user") UserData user) {

    authenticationService.createUser(user);
    return "redirect:/";
  }

}