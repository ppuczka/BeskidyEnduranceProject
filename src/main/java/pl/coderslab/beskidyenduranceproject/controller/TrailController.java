package pl.coderslab.beskidyenduranceproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.beskidyenduranceproject.repository.MountainRepository;
import pl.coderslab.beskidyenduranceproject.repository.TownRepository;
import pl.coderslab.beskidyenduranceproject.repository.TrailRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;


@SessionAttributes("loggedUser")
@Controller
public class TrailController {

    TrailRepository trailRepository;
    MountainRepository mountainRepository;
    TownRepository townRepository;
    UserRepository userRepository;

    @Autowired
    public TrailController(MountainRepository mountainRepository, UserRepository userRepository,
                            TrailRepository trailRepository, TownRepository townRepository) {

        this.mountainRepository = mountainRepository;
        this.townRepository = townRepository;
        this.trailRepository = trailRepository;
        this.userRepository = userRepository;

    }


}
