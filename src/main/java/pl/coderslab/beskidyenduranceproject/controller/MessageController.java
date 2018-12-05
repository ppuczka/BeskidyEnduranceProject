package pl.coderslab.beskidyenduranceproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.beskidyenduranceproject.entity.Message;
import pl.coderslab.beskidyenduranceproject.entity.User;
import pl.coderslab.beskidyenduranceproject.repository.MessageRepository;
import pl.coderslab.beskidyenduranceproject.repository.UserRepository;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@SessionAttributes("loggedUser")
@RequestMapping("/logged/message")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createMessage(Model model) {
        Message message = new Message();
        model.addAttribute("message", message);
        return "/messages/newMessage";

    }

    @RequestMapping(value ="/create", method = RequestMethod.POST)
    public String sendMessage(@Valid Message message, BindingResult result, Model model, HttpSession session) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        if (result.hasErrors()) {
            return "/messages/newMessage";
        }else {
            message.setStatus(true);
            message.setSender(loggedUser);
            messageRepository.save(message);
            model.addAttribute("confirm", "Wiadomość pomyślnie wyslana");
            return "redirect:/messages/received";
       }

    }

    @RequestMapping(value ="/received", method = RequestMethod.GET)
    @Transactional
    public String received(Model model, HttpSession session)  {
        User sessionUser = (User) session.getAttribute("loggedUser");
        User receiver = userRepository.getOne(sessionUser.getUserId());
        model.addAttribute("received", receiver.getReceived());

        return "/messages/received";

    }

    @RequestMapping(value="/respond/{id}", method = RequestMethod.GET)
    public String respond(Model model, @PathVariable Long id) {
        Message message = messageRepository.getOne(id);
        model.addAttribute("message", message);
        return "/messages/respond";
    }

    @RequestMapping(value = "respond/**", method = RequestMethod.POST)
    public String sendResponse(@RequestParam String title, @RequestParam String text, @RequestParam String email, HttpSession session) {

        Message message = new Message();
        User loggedUser = (User) session.getAttribute("loggedUser");
        User userReceiver = userRepository.findByEmail(email);

        message.setSender(loggedUser);
        message.setReceiver(userReceiver);
        message.setText(text);
        message.setTitle(title);
        messageRepository.save(message);
        return "redirect:/messages/received";


    }


    @ModelAttribute("users")
    public Collection<User> populatedUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }


}
