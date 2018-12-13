package pl.coderslab.beskidyenduranceproject.controller;


import javastrava.api.API;
import javastrava.api.AuthorisationAPI;
import javastrava.auth.model.Token;
import javastrava.auth.model.TokenResponse;
import javastrava.model.StravaAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beskidyenduranceproject.entity.Trail;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;
import pl.coderslab.beskidyenduranceproject.service.StravaApiService;
import pl.coderslab.beskidyenduranceproject.service.UserService;
import java.util.List;

@Controller
@RequestMapping("/logged")
@SessionAttributes("loggedUser")
public class HomePageController {

    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;
    UserRepository userRepository;

    @Autowired
    StravaApiService stravaApiService;

    @Autowired
    UserService userService;

    @Autowired
    public HomePageController(MountainRepository mountainRepository, UserRepository userRepository,
                              TrailRepository trailRepository, TownRepository townRepository) {

        this.mountainRepository = mountainRepository;
        this.townRepository = townRepository;
        this.trailRepository = trailRepository;
        this.userRepository = userRepository;

    }


    @RequestMapping(path = "/mainPage", method = RequestMethod.GET)
    public String mainPage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        List<Trail> trails = trailRepository.findFirst5ByOrderByRatingDesc();
        List<User> users = userRepository.findFirst5ByOrderByPointsDesc();

        model.addAttribute("users", users);
        model.addAttribute("trails", trails);
        model.addAttribute("user", user);
        model.addAttribute("loggedUser", user);


        return "/main";
    }


}
