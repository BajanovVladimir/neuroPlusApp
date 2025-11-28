package ru.bazhanov.web.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.identification.model.Person;
import ru.bazhanov.identification.service.user.UserService;
import ru.bazhanov.project.employees.service.EmployeesServiceImpl;
import ru.bazhanov.project.model.Employee;
import ru.bazhanov.project.services.service.ServicesOurService;

@Controller
public class EmployeeCardViewController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeesServiceImpl employeesService;

    @Autowired
    private ServicesOurService servicesOurService;


    @GetMapping("/employeeCard")
    public ModelAndView showEmployeeCard(@RequestParam(value = "employeeId") int employeeId){
        Employee employee = employeesService.getById(employeeId);
        Person personUser = userService.getPersonOfCurrentUser();
        ModelAndView mv = new ModelAndView("/employees/employeeCardView");
        mv.addObject("personName", personUser.getName());
        mv.addObject("employee", employee);
        mv.addObject("serviceList", servicesOurService.getCurrentServices());
        return mv;
    }

    @RequestMapping("/employeeCard/serviceAdd")
    public ModelAndView addServiceToEmployee(@RequestParam(value = "employeeId") int employeeId,
                                             @RequestParam(value = "serviceId" ) int serviceId){
        employeesService.serviceAddById(employeeId, serviceId);
        Employee employee = employeesService.getById(employeeId);
        ModelAndView mv = new ModelAndView("redirect:/employeeCard");
        mv.addObject("employeeId", employeeId);
        return  mv;
    }

    @RequestMapping("/employeeCard/serviceRemove")
    public ModelAndView removeServiceToEmployee(@RequestParam(value = "employeeId") int employeeId,
                                                @RequestParam(value = "serviceRemoveId" ) int serviceId){
        employeesService.serviceRemoveById(employeeId, serviceId);
        ModelAndView mv = new ModelAndView("redirect:/employeeCard");
        mv.addObject("employeeId", employeeId);
        return mv;
    }
}
