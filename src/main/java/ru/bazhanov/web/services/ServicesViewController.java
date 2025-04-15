package ru.bazhanov.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;
import ru.bazhanov.project.services.dto.ServiceDTO;
import ru.bazhanov.project.model.OurService;
import ru.bazhanov.project.services.service.ServicesOurService;

import java.util.List;

@Controller
public class ServicesViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private ServicesOurService servicesOurService;

    @ModelAttribute("serviceAddForm")
    public ServiceDTO serviceAddDto() {
        return new ServiceDTO();
    }

    @GetMapping("/services")
    public ModelAndView showServicesView(){
        Person personUser = userService.getPersonOfCurrentUser() ;
        List<OurService> serviceList = servicesOurService.getCurrentServices();
        ModelAndView mv = new ModelAndView("/services/servicesView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("serviceList", serviceList);
        return mv;
    }
    @RequestMapping("/services/add")
    public ModelAndView addService(@ModelAttribute("serviceAddForm") ServiceDTO serviceDTO){
        servicesOurService.save(serviceDTO);
        return new ModelAndView("redirect:/services");
    }

    @RequestMapping("/services/delete")
    public ModelAndView deleteService(@RequestParam(value = "serviceId") int serviceId){
        servicesOurService.deleteById(serviceId);
        return  new ModelAndView("redirect:/services");
    }
}
