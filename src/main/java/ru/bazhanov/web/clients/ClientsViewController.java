package ru.bazhanov.web.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;
import ru.bazhanov.project.clients.dto.ClientDTO;
import ru.bazhanov.project.clients.service.ClientsService;
import ru.bazhanov.project.model.Client;

@Controller
public class ClientsViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientsService clientsService;

    @ModelAttribute("clientAddForm")
    private ClientDTO clientAddDTO(){return new ClientDTO();}
    @GetMapping("/clients")
    public ModelAndView showClientsView(){
        Person personUser = userService.getPersonOfCurrentUser();
        ModelAndView mv = new ModelAndView("/clients/clientsView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("clientList", clientsService.getAllClients());
        return mv;
    }

    @RequestMapping("/clients/add")
    public ModelAndView addClient(@ModelAttribute("clientAddForm") ClientDTO clientDTO){
        Client saveClient = clientsService.save(clientDTO);
        return new ModelAndView("redirect:/clients");
    }
}
