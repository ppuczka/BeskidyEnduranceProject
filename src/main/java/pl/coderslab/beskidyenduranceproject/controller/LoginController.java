package pl.coderslab.beskidyenduranceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.service.EmailSerivice;
import pl.coderslab.beskidyenduranceproject.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailSerivice emailSerivice;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";

    }

    @RequestMapping(value = {"/login/error"}, method = RequestMethod.GET)
    public String loginError(Model model) {
        String error = "Nieprawidłowa nazwa użytkownika lub hasło";
        model.addAttribute("error", error);
        return "/loginError";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/forms/register";

    }

    // error do widoku

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createNewUser(@Valid User user, BindingResult result, Model model) throws Exception {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            result.rejectValue("email", "error.user",
                    "Użytkownik o podanym adresie istnieje");
        }
        if(result.hasErrors()) {
            return "forms/register";
        } else {
            userService.saveUser(user);
            emailSerivice.sendEmail(user);
            model.addAttribute("successMessage", "Użytkownik został zarejetrowany, otrzymasz email z potwierdzeniem");
            //czy dodawać obiekt do modelu i wracać go do widoku
            return "/forms/register";
        }

    }

//    @RequestMapping(value= "/admin/home", method = RequestMethod.GET)
//    public String adminHome(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        model.addAttribute("user", user);
//        return "/admin/home";
//
//    }

    @RequestMapping(value= {"/",  "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("user", user);
        return "/homePage";

    }



}
