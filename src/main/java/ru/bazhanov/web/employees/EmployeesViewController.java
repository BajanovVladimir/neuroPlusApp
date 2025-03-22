package ru.bazhanov.web.employees;

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
import ru.bazhanov.project.employees.dto.EmployeeDTO;
import ru.bazhanov.project.employees.service.EmployeesServiceImpl;
import ru.bazhanov.project.services.dto.ServiceDTO;

@Controller
public class EmployeesViewController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EmployeesServiceImpl employeesService;

    @ModelAttribute("employeeAddForm")
    public EmployeeDTO serviceAddDto() {
        return new EmployeeDTO();
    }

    @GetMapping("/employees")
    public ModelAndView showEmployeesView(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ( principal instanceof User)? ((User) principal):new User();
        Person personUser = personRepository.findByUser(user);
        ModelAndView mv = new ModelAndView("/employees/employeesView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("employeeList", employeesService.getCurrentEmployees());
        return mv;
    }

    @RequestMapping("/employees/add")
    public ModelAndView addEmployee(@ModelAttribute("employeeAddForm") EmployeeDTO employeeDTO){
        employeesService.save(employeeDTO);
        ModelAndView mv = new ModelAndView("redirect:/employees");
        return mv;
    }

    @RequestMapping("/employees/delete")
    public ModelAndView deleteEmployee(@RequestParam(value = "employeeId") int employeeId){
        employeesService.deleteById(employeeId);
        ModelAndView mv = new ModelAndView("redirect:/employees");
        return mv;
    }
}
