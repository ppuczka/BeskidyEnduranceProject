package pl.coderslab.beskidyenduranceproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes("loggedUserName")
public class AdminController {


    @Autowired
    ConversionService conversionService;


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
    public String addTownFrom(Model model) {
        Town town = new Town();
        model.addAttribute("town", town);

        return "admin/forms/addTown";
    } 

    @RequestMapping(value = "/addTown", method = RequestMethod.POST)
    public String addTown(@Valid Town town, BindingResult result, Model model) {
        
        if(result.hasErrors()) {
            return "/admin/forms/addTown";

        } else {
            model.addAttribute("succesMessage", "Zapis udany");
            townRepository.save(town);
            return "redirect:/admin/towns";

        }

    }

    @RequestMapping(value = "/mountains", method = RequestMethod.GET)
    public String mountainsPage(Model model) {

        List<Mountain> mountains = mountainRepository.findAll();
        model.addAttribute("mountains", mountains);

        return "/admin/mountains";
    }


    @RequestMapping(value = "/addMountain", method = RequestMethod.GET)
    public String addMountainFrom(Model model) {
        Mountain mountain = new Mountain();
        model.addAttribute("mountain", mountain);

        return "admin/forms/addMountain";
    }

    @RequestMapping(value = "/addMountain", method = RequestMethod.POST)
    public String addMountain(@Valid Mountain mountain, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "/admin/forms/addMountain";

        } else {
            model.addAttribute("succesMessage", "Zapis udany");
            mountainRepository.save(mountain);
            return "redirect:/admin/mountains";

        }
    }

    @RequestMapping(value = "/addTrail", method = RequestMethod.GET)
    public String addTrailFrom(Model model) {
        Trail trail = new Trail();
        model.addAttribute("trail", trail);

        return "admin/forms/addTrail";
    }

    @RequestMapping(value = "/addTrail", method = RequestMethod.POST)
    public String addTrail(@Valid Trail trail, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "/admin/forms/addTrail";

        } else {
            trailRepository.save(trail);
            return "redirect:/admin/trails";
        }
    }

    @RequestMapping(value = "/trails", method = RequestMethod.GET)
    public String trailsPage(Model model) {

        List<Trail> trails = trailRepository.findAll();
        model.addAttribute("trails", trails);

        return "/admin/trails";
    }

    @ModelAttribute("towns")
    public Collection<Town> populatedTowns() {
        return this.townRepository.findAll();
    }

    @ModelAttribute("mountains")
    public Collection<Mountain> populatedMountains() {
        return this.mountainRepository.findAll();
    }

    @ModelAttribute("trails")
    public Collection<Trail> populatedTrails() {
        return this.trailRepository.findAll();
    }


    @ModelAttribute("difficulty")
    private Collection<String> difficulty() {

        List<String> difficulty = new ArrayList<>();
        difficulty.add("Początkujący");
        difficulty.add("Zaawansowany");
        difficulty.add("Wymiatacz");
        difficulty.add("Elite");
        difficulty.add("Cyborg");

        return difficulty;
    }

    @ModelAttribute("trailTypes")
    public Collection<String> trailTypes() {

        List<String> trailTypes = new ArrayList<>();
        trailTypes.add("Biegowa/Rowerowa");
        trailTypes.add("Tylko biegowa");
        trailTypes.add("Tylko rowerowa");

        return trailTypes;
    }


}
