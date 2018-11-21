package pl.coderslab.beskidyenduranceproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.entity.Trail;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;
    UserRepository userRepository;


    @Autowired
    public AdminController(MountainRepository mountainRepository, UserRepository userRepository,
                              TrailRepository trailRepository, TownRepository townRepository) {

        this.mountainRepository = mountainRepository;
        this.townRepository = townRepository;
        this.trailRepository = trailRepository;
        this.userRepository = userRepository;

    }
//NEXT STEP - podzielić na 4 grupy dodac buttony do panelu administracyjnego, dodac funkcje dodania trasy gory i miasta

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePage(Model model) {

        List<Mountain> mountains = mountainRepository.findAll();
        List<Town> towns = townRepository.findAll();
        List<User> users = userRepository.findAll();
        List<Trail> trails = trailRepository.findAll();

            model.addAttribute("mountains", mountains);
            model.addAttribute("towns", towns);
            model.addAttribute("users", users);
            model.addAttribute("trails", trails);

            return "/admin/home";

    }

}
