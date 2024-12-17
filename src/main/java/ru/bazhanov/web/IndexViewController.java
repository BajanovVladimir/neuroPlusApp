package ru.bazhanov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexViewController {
    @GetMapping("/")
    public ModelAndView indexGet(){
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }
}
