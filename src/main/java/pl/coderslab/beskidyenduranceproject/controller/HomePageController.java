package pl.coderslab.beskidyenduranceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;

@Controller
@RequestMapping("/")
public class HomePageController {


    UserRepository userRepository;
    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;


    @Autowired
    public HomePageController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @RequestMapping(path = "/addTrail", method = RequestMethod.GET)
    public String mainPage(Model model) {
//        List<Mountain> mountains = mountainRepository.findAll();
//        List<Town> towns = townRepository.findAll();

        User user = new User();
        user.setFirstName("user");
        model.addAttribute("user", user);
//        model.addAttribute("towns", towns);
//        model.addAttribute("mountains", mountains);

        return "/forms/addTrail";
    }

}
