package ru.bazhanov.web.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.model.User;
import ru.bazhanov.identification.repository.PersonRepository;
import ru.bazhanov.project.employees.service.EmployeesServiceImpl;
import ru.bazhanov.project.model.Employee;
import ru.bazhanov.project.model.OurService;
import ru.bazhanov.project.services.service.ServicesOurService;

import java.util.Set;

@Controller
public class EmployeeCardViewController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EmployeesServiceImpl employeesService;

    @Autowired
    private ServicesOurService servicesOurService;


    @GetMapping("/employeeCard")
    public ModelAndView showEmployeeCard(@RequestParam(value = "employeeId") int employeeId){
        Employee employee = employeesService.getById(employeeId);
        Set<OurService> serviceSet = employee.getServiceSet();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = ( principal instanceof User)? ((User) principal):new User();
        Person personUser = personRepository.findByUser(user);
        ModelAndView mv = new ModelAndView("/employees/employeeCardView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("employee", employee);
        mv.addObject("employeeId", employeeId);
        mv.addObject("serviceList", servicesOurService.getCurrentServices());
        return mv;
    }
}
