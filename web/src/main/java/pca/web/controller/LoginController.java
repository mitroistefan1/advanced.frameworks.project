package pca.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    /**
     * Handles and retrieves the login JSP page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value="error", required=false) boolean error,
                               ModelMap model) {



        if (error == true) {
            // Assign an error message
            model.put("error", "You have entered an invalid username or password!");
        } else {
            model.put("error", "");
        }

        // This will resolve to /WEB-INF/jsp/loginpage.jsp
        return "login";
    }


    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String getDeniedPage() {

        // This will resolve to /WEB-INF/jsp/deniedpage.jsp
        return "error";
    }

    /*@Autowired
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
*/
}
