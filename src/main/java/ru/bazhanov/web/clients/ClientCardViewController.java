package ru.bazhanov.web.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;
import ru.bazhanov.project.clients.service.ClientsService;
import ru.bazhanov.project.model.Client;
import ru.bazhanov.project.model.Contact;

@Controller
public class ClientCardViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientsService clientsService;

    @GetMapping("/clientCard")
    public ModelAndView showClientCard(@RequestParam(value = "clientId") int clientId) {
        Person personUser = userService.getPersonOfCurrentUser();
        Client client = clientsService.getById(clientId);
        ModelAndView mv = new ModelAndView("/clients/clientCardView");
        mv.addObject("client", client);
        return mv;
    }

    @PostMapping("/clientCard/addContact")
    public ModelAndView addContact(@RequestParam(value = "clientId") int clientId,
                                   @RequestParam(value = "contactName") String contactName,
                                   @RequestParam(value = "phone") String phone){
        Client client = clientsService.getById(clientId);
        Contact newContact = new Contact(contactName, phone, client);
        clientsService.clientAddContact(client, newContact);

        ModelAndView mv = new ModelAndView("redirect:/clientCard");
        mv.addObject("clientId",clientId);
        return mv;
    }
}