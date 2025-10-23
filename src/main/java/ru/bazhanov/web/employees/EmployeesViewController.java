package ru.bazhanov.web.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;
import ru.bazhanov.project.employees.dto.EmployeeDTO;
import ru.bazhanov.project.employees.service.EmployeesServiceImpl;

@Controller
public class EmployeesViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeesServiceImpl employeesService;

    @ModelAttribute("employeeAddForm")
    public EmployeeDTO employeeAddDto() {
        return new EmployeeDTO();
    }

    @GetMapping("/employees")
    public ModelAndView showEmployeesView(){
        Person personUser = userService.getPersonOfCurrentUser();
        ModelAndView mv = new ModelAndView("/employees/employeesView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("employeeList", employeesService.getCurrentEmployees());
        return mv;
    }

    @RequestMapping("/employees/add")
    public ModelAndView addEmployee(@ModelAttribute("employeeAddForm") EmployeeDTO employeeDTO){
        employeesService.save(employeeDTO);
        return new ModelAndView("redirect:/employees");
    }

    @RequestMapping("/employees/delete")
    public ModelAndView deleteEmployee(@RequestParam(value = "employeeId") int employeeId){
        employeesService.deleteById(employeeId);
        return new ModelAndView("redirect:/employees");
    }
}
