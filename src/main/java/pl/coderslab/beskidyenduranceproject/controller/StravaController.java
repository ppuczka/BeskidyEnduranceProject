package pl.coderslab.beskidyenduranceproject.controller;

import javastrava.model.StravaAthlete;
import javastrava.model.StravaStatistics;
import javastrava.model.StravaStatisticsEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;
import pl.coderslab.beskidyenduranceproject.service.StravaApiService;
import pl.coderslab.beskidyenduranceproject.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
        User user = new User();
        model.addAttribute("user", user);
        return "/forms/authorizeStrava";
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
    public String getAuthorizationData(@RequestParam String code, HttpSession session, Model model) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        loggedUser.setStravaCode(code);
        StravaAthlete athlete = stravaApiService.getStravaAthlete(loggedUser);

        StravaStatistics stravaStatistics = stravaApiService.getAthleteStatistic(loggedUser);
        StravaStatisticsEntry stats = stravaStatistics.getAllRunTotals();
        Float runDist = stats.getDistance();
        Float runUphill = stats.getElevationGain();

        StravaStatisticsEntry stats2 = stravaStatistics.getAllRideTotals();
        Float rideDist = stats2.getDistance();
        Float rideUphill = stats2.getElevationGain();

        Float points = ((runDist + (runUphill*2)) + (rideDist + (rideUphill*2)))/1000;
        loggedUser.setPoints(loggedUser.getPoints()+points);
        userRepository.save(loggedUser);
        model.addAttribute("stravaPoints", points);
        model.addAttribute("stravaConnectMsg", "Pomyślnie połączono z Strava. Nazwa użytkownika: " + athlete.getUsername() +"." +
                " Przyznano " + points + " punktów.");


        return "/main";
    }

}
