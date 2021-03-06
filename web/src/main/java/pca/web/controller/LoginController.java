package pca.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,
                             ModelMap model) {

    System.out.println("log in");
    if (error) {
      model.put("error", "You have entered an invalid username or password!");
    } else {
      model.put("error", "");
    }
    return "login";
  }

}
