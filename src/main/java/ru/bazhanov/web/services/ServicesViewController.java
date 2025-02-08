package ru.bazhanov.web.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/services")
public class ServicesViewController {

    @GetMapping
    public ModelAndView showServicesView(){
        ModelAndView mv = new ModelAndView("/services/servicesView");
        return mv;
    }
}
