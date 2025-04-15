package ru.bazhanov.web.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;

@Controller
public class ClientsViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/clients")
    public ModelAndView showClientsView(){
        Person personUser = userService.getPersonOfCurrentUser();
        ModelAndView mv = new ModelAndView("/clients/clientsView");
        mv.addObject("personName", personUser.getName());
        return mv;
    }
}
