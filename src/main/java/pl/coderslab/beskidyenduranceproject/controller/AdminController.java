package pl.coderslab.beskidyenduranceproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.entity.Trail;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes("loggedUserName")
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

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(Model model, HttpServletRequest request) {

        List<Mountain> mountains = mountainRepository.findAll();
        List<Town> towns = townRepository.findAll();
        List<User> users = userRepository.findAll();
        List<Trail> trails = trailRepository.findAll();

        Principal principal = request.getUserPrincipal();

            model.addAttribute("loggedUserName", principal.getName());
            model.addAttribute("mountains", mountains);
            model.addAttribute("towns", towns);
            model.addAttribute("users", users);
            model.addAttribute("trails", trails);

            return "/admin/home";

    }


    @RequestMapping(value = "/towns", method = RequestMethod.GET)
    public String townsPage(Model model) {

        List<Town> towns = townRepository.findAll();
        model.addAttribute("towns", towns);

        return "/admin/towns";
    }

    @RequestMapping(value = "/addTown", method = RequestMethod.GET)
    public String addTown(Model model) {
        Town town = new Town();
        model.addAttribute("town", town);

        return "admin/forms/addTown";
    }

}
