package com.example.companyemployeespring.contraller;

import com.example.companyemployeespring.entity.Company;
import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployerController {
    @Autowired
    private EmployeeRepository employeeRepository;

  @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/employee")
    public String employeePage(ModelMap map) {
        Iterable<Employee> employee = employeeRepository.findAll();
        map.addAttribute("employee", employee);
        return "employee";
    }

   @GetMapping("/employee/add")
    public String addEmployeePage(ModelMap modelMap) {
        modelMap.addAttribute("companies",companyRepository.findAll());
        modelMap.addAttribute("employer",employeeRepository.findAll());
        return "addEmployee";
    }

    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeRepository.deleteById(id);
        return "redirect:/employee";


    }
}
