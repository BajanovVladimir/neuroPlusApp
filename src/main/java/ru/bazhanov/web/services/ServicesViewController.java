package ru.bazhanov.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.model.User;
import ru.bazhanov.identification.repository.PersonRepository;
import ru.bazhanov.project.services.dto.ServiceDTO;
import ru.bazhanov.project.model.OurService;
import ru.bazhanov.project.services.service.ServicesOurService;

import java.util.List;

@Controller
public class ServicesViewController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ServicesOurService servicesOurService;

    @ModelAttribute("serviceAddForm")
    public ServiceDTO serviceAddDto() {
        return new ServiceDTO();
    }

    @GetMapping("/services")
    public ModelAndView showServicesView(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ( principal instanceof User)? ((User) principal):new User();
        Person personUser = personRepository.findByUser(user);
        List<OurService> serviceList = servicesOurService.getCurrentServices();
        ModelAndView mv = new ModelAndView("/services/servicesView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("serviceList", serviceList);
        return mv;
    }
    @RequestMapping("/services/add")
    public ModelAndView addService(@ModelAttribute("serviceAddForm") ServiceDTO serviceDTO){
        servicesOurService.save(serviceDTO);
        ModelAndView mv = new ModelAndView("redirect:/services");
        return mv;
    }

    @RequestMapping("/services/delete")
    public ModelAndView deleteService(@RequestParam(value = "serviceId") int serviceId){
        servicesOurService.deleteById(serviceId);
        ModelAndView mv = new ModelAndView("redirect:/services");
        return mv;
    }

}
