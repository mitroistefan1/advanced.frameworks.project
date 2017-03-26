package pca.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pca.auth.exception.AuthException;
import pca.service.data.UserData;
import pca.auth.authentication.AuthenticationService;

import javax.servlet.http.HttpServletRequest;

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

  @RequestMapping(value = "signup/validation/please-verify", method = RequestMethod.GET)
  public String pleaseVerify() {
    return "signup_validation";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String save(@ModelAttribute("user") UserData user) throws AuthException {

    authenticationService.createUser(user);
    return "redirect:/signup/validation/please-verify";
  }

  @ExceptionHandler(AuthException.class)

  public ModelAndView handleAuthException(HttpServletRequest request, Exception ex) {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", ex.getMessage());
    modelAndView.setViewName("error");

    return modelAndView;
  }
}