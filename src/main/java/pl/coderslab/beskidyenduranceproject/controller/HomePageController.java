package pl.coderslab.beskidyenduranceproject.controller;

import javastrava.api.API;
import javastrava.api.AuthorisationAPI;
import javastrava.auth.model.Token;
import javastrava.auth.model.TokenResponse;
import javastrava.model.StravaActivity;
import javastrava.model.StravaAthlete;
import javastrava.model.StravaStatistics;
import javastrava.service.Strava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.entity.Trail;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;
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

    AuthorisationAPI auth = API.authorisationInstance();

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

    @RequestMapping(path = "/strava", method = RequestMethod.GET)
    @ResponseBody
    public String stravaAthlete() {

        Integer clientId = 30700;
        String clientSecret = "4bee4c0459bfc71d5f38d2d77dec6a408a057822";
        String code = "ad840906be1986f8a7fd576f4a157c4252aacbf0";

        TokenResponse resposne = auth.tokenExchange(clientId, clientSecret, code);
        Token token  = new Token(resposne);
        API api = new API(token);
        StravaAthlete athlete = api.getAthlete(15429063);
        StravaStatistics statistics = api.statistics(15429063);

        return athlete.getUsername() + statistics.getAllRunTotals().getDistance();
    }

}
