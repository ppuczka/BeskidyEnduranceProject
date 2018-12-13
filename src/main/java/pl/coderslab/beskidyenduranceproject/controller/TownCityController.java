package pl.coderslab.beskidyenduranceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.entity.Trail;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;
import pl.coderslab.beskidyenduranceproject.service.UserService;

import java.util.List;

@Controller
@SessionAttributes("loggedUser")
@RequestMapping("/logged/townsCities")
public class TownCityController {

    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    public TownCityController(MountainRepository mountainRepository, UserRepository userRepository,
                            TrailRepository trailRepository, TownRepository townRepository) {

        this.mountainRepository = mountainRepository;
        this.townRepository = townRepository;
        this.trailRepository = trailRepository;
        this.userRepository = userRepository;

    }

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public String townsPage(Model model) {

        List<Town> towns = townRepository.findAll();
        model.addAttribute("towns", towns);
        List<Mountain> mountains = mountainRepository.findAll();
        model.addAttribute("mountains", mountains);

        return "/townsCities";
    }
    
    @RequestMapping(value = "/town/viewTrails/{id}", method = RequestMethod.GET)
    public String viewTownTrails(Model model, @PathVariable Long id) {
        
        Town town = townRepository.getOne(id);
        List<Trail> townTrails = town.getTrailList();
        model.addAttribute("townTrails", townTrails);
        return "townTrails";    
    }

    @RequestMapping(value = "/mountain/viewTrails/{id}", method = RequestMethod.GET)
    public String viewMountainTrails(Model model, @PathVariable Long id) {

        Mountain mountain = mountainRepository.getOne(id);
        List<Trail> mountainTrails = mountain.getTrailList();
        model.addAttribute("mountainTrails", mountainTrails);
        return "mountainTrails";
    }

}
