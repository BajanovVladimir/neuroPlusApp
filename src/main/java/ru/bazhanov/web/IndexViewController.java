package ru.bazhanov.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;

@Controller
public class IndexViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView indexGet(){
        Person personUser = userService.getPersonOfCurrentUser() ;
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("personName", personUser.getName());
        return mv;
    }

    @PostMapping("/")
    public ModelAndView  indexPost() {
        Person personUser = userService.getPersonOfCurrentUser();
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("personName", personUser.getName());
        return mv;
    }

    @RequestMapping({"/login"})
    public String login() {
        return "login";
    }
}
