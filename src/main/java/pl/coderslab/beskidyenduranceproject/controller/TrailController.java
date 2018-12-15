package pl.coderslab.beskidyenduranceproject.controller;


import javastrava.model.StravaActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beskidyenduranceproject.entity.Mountain;
import pl.coderslab.beskidyenduranceproject.entity.Town;
import pl.coderslab.beskidyenduranceproject.entity.Trail;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;
import pl.coderslab.beskidyenduranceproject.service.StravaApiService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@SessionAttributes({"loggedUser", "trail"})
@RequestMapping("/logged/trails")
public class TrailController {

    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;
    UserRepository userRepository;

    @Autowired
    StravaApiService stravaApiService;

    @Autowired
    public TrailController(MountainRepository mountainRepository, UserRepository userRepository,
                            TrailRepository trailRepository, TownRepository townRepository) {

        this.mountainRepository = mountainRepository;
        this.townRepository = townRepository;
        this.trailRepository = trailRepository;
        this.userRepository = userRepository;

    }

    @RequestMapping(value = "/addTrail", method = RequestMethod.GET)
    public String addTrailFrom(Model model) {
        Trail trail = new Trail();
        model.addAttribute("trail", trail);

        return "forms/addTrail";
    }

    @RequestMapping(value = "/addTrail", method = RequestMethod.POST)
    public String addTrail(@Valid Trail trail, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "forms/addTrail";

        } else {
            trailRepository.save(trail);
            model.addAttribute("successMsg", "Trasa została zapisana");
            return "trails";
        }
    }

    @RequestMapping(value ="/addStravaTrail", method = RequestMethod.GET)
    public String addStravaTrail(Model model, HttpSession session) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser.isStrava() == false) {
            model.addAttribute("successMsg", "Najpierw połącz z kontem Strava");
            return "/main";
        } else {
            return "forms/addStravaTrail";

        }
    }

    @RequestMapping(value ="/getActivityId", method = RequestMethod.GET)
    public String getStravaActivityId(Model model, HttpSession session, @RequestParam Long activityId) {

        User loggedUser = (User) session.getAttribute("loggedUser");
        StravaActivity activity = stravaApiService.getActivity(loggedUser, activityId);
        Trail trailFromStravaActivity = new Trail();
        trailFromStravaActivity.setName(loggedUser.getFirstName() + " " + activity.getName() + " z dnia " + activity.getStartDateLocal());
        trailFromStravaActivity.setLength(activity.getDistance()/1000);
        trailFromStravaActivity.setUphill(activity.getTotalElevationGain());
        trailFromStravaActivity.setDescription(activity.getDescription());
        model.addAttribute("trail", trailFromStravaActivity);
        model.addAttribute("activityId", activityId);

        return "redirect:addTrailFromStrava";
    }


    @RequestMapping(value ="/addTrailFromStrava", method = RequestMethod.GET)
    public String getStravaActivity(Model model, HttpSession session) {
        model.addAttribute("trail", session.getAttribute("trail"));
        return "/forms/addTrail";

    }

    @RequestMapping(value = "/addTrailFromStrava", method = RequestMethod.POST)
    public String addTrailFromStrava(@Valid Trail trail, BindingResult result, Model model) {

        if(result.hasErrors()) {
            return "forms/addTrail";

        } else {
            trailRepository.save(trail);
            model.addAttribute("successMsg", "Trasa została zapisana");
            return "trails";
        }
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String trailsPage(Model model) {

        List<Trail> trails = trailRepository.findAll();
        model.addAttribute("trails", trails);

        return "trails";
    }

    @RequestMapping(value = "/favTrails", method = RequestMethod.GET)
    public String trailsPage(Model model, HttpSession session) {

        User loggedUser = (User) session.getAttribute("loggedUser");
        model.addAttribute("favTrails", loggedUser.getTrails());

        return "favTrails";
    }


    @RequestMapping(value = "/deleteTrail/{id}", method = RequestMethod.GET)
    public String deleteTrail(Model model, @PathVariable Long id) {
        trailRepository.deleteById(id);
        model.addAttribute("successMsg", "Trasa została usunięta");
        return "trails";
    }

    @RequestMapping(value = "/likeTrail/{id}", method = RequestMethod.GET)
    public String likeTrail(@PathVariable Long id, HttpSession session, Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");
        Trail likedTrail = trailRepository.getOne(id);
        List<Trail> userLikedTrails = loggedUser.getTrails();
        for (Trail t : userLikedTrails) {
            if (t.getTrailId() == likedTrail.getTrailId()) {
                model.addAttribute("successMsg", "Już polubiłeś tą trasę");
                return "trails";
            }
        }
                Integer currentRating = likedTrail.getRating();
                if (currentRating == null) {
                    currentRating = 0;
                }
                likedTrail.setRating(currentRating + 50);
                userLikedTrails.add(likedTrail);
                trailRepository.save(likedTrail);
                userRepository.save(loggedUser);
                model.addAttribute("successMsg", "Pomyślnie dodano do ulubionych tras");
                return "trails";
            }


    @RequestMapping(value = "/disLikeTrail/{id}", method = RequestMethod.GET)
    public String disLikeTrail(@PathVariable Long id, HttpSession session, Model model) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        Trail unlikedTrail = trailRepository.getOne(id);
        List<Trail> userLikedTrails = loggedUser.getTrails();
        for (Trail t : userLikedTrails) {
            if (t.getTrailId() == unlikedTrail.getTrailId()) {
                System.out.println(t.getTrailId());
                userLikedTrails.remove(t);
                loggedUser.setTrails(userLikedTrails);
                userRepository.save(loggedUser);
                model.addAttribute("successMsg", "Pomyślnie usunięto z ulubionych tras");
                model.addAttribute("favTrails", userLikedTrails);
                return "favTrails";
            }


        }
        return "favTrails";
    }


    @RequestMapping(value ="/trailDetails/{id}", method = RequestMethod.GET)
    public String trailDetails(@PathVariable Long id, Model model) {
        Trail trail = trailRepository.getOne(id);
        model.addAttribute("trail", trail);
        return "trailDetails";
    }

    @RequestMapping(value = "/searchTrails", method = RequestMethod.POST)
    public String searchTrail(@RequestParam String search, Model model) {
        List<Trail> foundTownTrails = trailRepository.getAllByTownsNameContainingIgnoreCase(search);
        List<Trail> foundMountainTrails = trailRepository.getAllByMountainsNameContainingIgnoreCase(search);
        List<Trail> allFoundTrails = new ArrayList<>();
        System.out.println(foundTownTrails.size() + foundMountainTrails.size());

        if (foundMountainTrails.size() == 0) {
            allFoundTrails.addAll(foundTownTrails);
            model.addAttribute("trails", allFoundTrails);
            return "search";

        }else if(foundMountainTrails.size() != 0)  {
            allFoundTrails.addAll(foundMountainTrails);
            model.addAttribute("trails", allFoundTrails);
            return "search";

        } else {
            allFoundTrails.addAll(foundTownTrails);
            allFoundTrails.addAll(foundMountainTrails);
            model.addAttribute("trails", allFoundTrails);
            return "search";
        }


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


    @SuppressWarnings("Duplicates")
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

    @SuppressWarnings("Duplicates")
    @ModelAttribute("trailTypes")
    public Collection<String> trailTypes() {

        List<String> trailTypes = new ArrayList<>();
        trailTypes.add("Biegowa/Rowerowa");
        trailTypes.add("Tylko biegowa");
        trailTypes.add("Tylko rowerowa");

        return trailTypes;
    }



}
