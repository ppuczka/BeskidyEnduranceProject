package pl.coderslab.beskidyenduranceproject.controller;

import javastrava.model.StravaAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;
import pl.coderslab.beskidyenduranceproject.service.StravaApiService;
import pl.coderslab.beskidyenduranceproject.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logged")
@SessionAttributes("loggedUser")
public class StravaController {

    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;
    UserRepository userRepository;

    @Autowired
    StravaApiService stravaApiService;

    @Autowired
    UserService userService;

    @Autowired
    public StravaController(MountainRepository mountainRepository, UserRepository userRepository,
                              TrailRepository trailRepository, TownRepository townRepository) {

        this.mountainRepository = mountainRepository;
        this.townRepository = townRepository;
        this.trailRepository = trailRepository;
        this.userRepository = userRepository;

    }

    @RequestMapping(path = "/authorizeStrava", method = RequestMethod.GET)
    public String authorizeStrava(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("logggedUser");
        if (loggedUser.getStravaClientId().equals(null) || loggedUser.getStravaClientSecret().equals(null)) {
            User user = new User();
            model.addAttribute("user", user);
            return "/forms/authorizeStrava";
        }
        else return  "redirect:/authorizeStrava";
    }


    @RequestMapping(path = "/authorizeStrava", method = RequestMethod.POST)
    public String getAuthorizationCode(User user, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        loggedUser.setStravaClientId(user.getStravaClientId());
        loggedUser.setStravaClientSecret(user.getStravaClientSecret());
        userRepository.save(loggedUser);

        return "redirect:https://www.strava.com/oauth/authorize?client_id=" + loggedUser.getStravaClientId() +
                "&redirect_uri=http://localhost:8080/logged/getAuthData/&response_type=code";
    }

    @RequestMapping(path = "/getAuthData", method = RequestMethod.GET)
    @ResponseBody
    public String getAuthorizationData(@RequestParam String code, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        loggedUser.setStravaCode(code);
        userRepository.save(loggedUser);

        StravaAthlete athlete = stravaApiService.getStravaAthlete(loggedUser);

        return code + athlete.getUsername();
    }

}
