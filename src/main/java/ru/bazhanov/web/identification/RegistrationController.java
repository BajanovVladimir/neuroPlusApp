package ru.bazhanov.web.identification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Role;
import ru.bazhanov.identification.repository.RoleRepository;
import ru.bazhanov.identification.service.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @ModelAttribute("userForm")
    public UserDTO userRegistrationDto() {
        return new UserDTO();
    }

    @GetMapping
    public ModelAndView showRegistrationForm() {
        List<Role> roleList = roleRepository.findAll();
        ModelAndView mv = new ModelAndView("/registration");
        mv.addObject("roleList", roleList);
        return mv;
    }

    @PostMapping
    public ModelAndView registerUserAccount(@ModelAttribute("userForm") UserDTO registrationDto) {
        ModelAndView mv;
        if(!userService.save(registrationDto)){
            mv = new ModelAndView("/registration");
            mv.addObject("error", "Пользователь с таким именем уже существует");
            return mv;
        }
        mv = new ModelAndView("redirect:/users");
        return mv;
    }
}
