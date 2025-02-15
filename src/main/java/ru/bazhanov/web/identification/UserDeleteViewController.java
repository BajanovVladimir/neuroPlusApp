package ru.bazhanov.web.identification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.dao.UserDAO;
import ru.bazhanov.identification.dao.UserDAOImpl;
import ru.bazhanov.identification.dto.UserDTO;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.repository.PersonRepository;
import ru.bazhanov.identification.service.user.UserService;

@Controller
@RequestMapping("/userDelete")
public class UserDeleteViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private PersonRepository personRepository;
    private final UserDAO userDao = new UserDAOImpl();

    @GetMapping
    public ModelAndView showUserDeleteView(@RequestParam(value = "userId") int userId){
        Person person = personRepository.findByUser(userService.findUserById(userId));
        UserDTO userDTO = new UserDAOImpl().getUserDTO(person);
        ModelAndView mv = new ModelAndView("/users/userDeleteView");
        mv.addObject("userDTO", userDTO);
        return mv;
    }

    @PostMapping
    public ModelAndView deleteUser(@RequestParam(value = "userId") int userId){
        userService.deleteUser(userId);
        ModelAndView mv = new ModelAndView("redirect:/users");
        return mv;
    }
}
