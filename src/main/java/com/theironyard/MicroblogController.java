package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by michaeldelli-gatti on 6/20/16.
 */
@Controller
public class MicroblogController {

    @Autowired
    MessageRepository messages;


    @RequestMapping(path = "/", method = RequestMethod.GET)
        public String home(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        User user = null;
        if (username != null){
            user = new User(username);
        }
        model.addAttribute("user", user);
        Iterable<Message> msgs = messages.findAll();
        model.addAttribute("messages", msgs);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, HttpSession session) {
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String text){
        Message m = new Message(text);
        messages.save(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(Integer id){
        messages.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String edit(Integer id, String text){
        Message m = messages.findOne(id);
        m.setText(text);
        messages.save(m);
        return "redirect:/";
    }
}
