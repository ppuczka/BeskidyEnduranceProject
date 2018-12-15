package pl.coderslab.beskidyenduranceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.beskidyenduranceproject.entity.Rank;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.RankRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("loggedUser")
@RequestMapping("/logged")
public class RankController {

    RankRepository rankRepository;
    UserRepository userRepository;

    @Autowired
    public RankController(RankRepository rankRepository, UserRepository userRepository) {
        this.rankRepository = rankRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/ranks", method = RequestMethod.GET)
    public String viewMyRank(HttpSession session, Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");
        Float usrPoints = loggedUser.getPoints();

        List<Rank> ranks = rankRepository.findAll();

            for(int i = 0; i<=ranks.size(); i++) {
                if((usrPoints >= ranks.get(i).getMinReqPoints()) && (usrPoints <= ranks.get(i).getMaxReqPoints())) {
                    loggedUser.setRank(ranks.get(i));
                    userRepository.save(loggedUser);
                    model.addAttribute("loggedUser", loggedUser);
                    model.addAttribute("nextRank", ranks.get(i+1));
                    model.addAttribute("reqPoints", ranks.get(i+1).getMinReqPoints()-usrPoints);
                    return "myRanks";
                }
            }

            return "myRanks";

    }

}
