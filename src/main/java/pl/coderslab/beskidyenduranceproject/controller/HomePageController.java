package pl.coderslab.beskidyenduranceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/logged")
@SessionAttributes("loggedUser")
public class HomePageController {


    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;

    @Autowired
    UserService userService;


    @Autowired
    public HomePageController(MountainRepository mountainRepository,
                              TrailRepository trailRepository, TownRepository townRepository) {

        this.mountainRepository = mountainRepository;
        this.townRepository = townRepository;
        this.trailRepository = trailRepository;

    }


    @RequestMapping(path = "/mainPage", method = RequestMethod.GET)
    public String mainPage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("user", user);
        model.addAttribute("loggedUser", user);

        return "/main";
    }

}
