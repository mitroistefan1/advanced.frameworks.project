package pca.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pca.web.bean.User;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(ModelMap models) {
        models.put("error", " ");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(ModelMap models, @ModelAttribute("User") User user) {
        System.out.println(user.getUserName()+" "+user.getPassword());
        if ("stefan.mitroi".equals(user.getUserName()) && "password".equals(user.getPassword())) {

            System.out.println("acici");
            return "home";
        } else {
            models.put("error", " Invalid Details");
            return "login";
        }
    }

}
