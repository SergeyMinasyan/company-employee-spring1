package com.example.companyemployeespring.contraller;

import com.example.companyemployeespring.entity.Company;
import com.example.companyemployeespring.entity.Employee;
import com.example.companyemployeespring.repository.CompanyRepository;
import com.example.companyemployeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String main(ModelMap modelMap) {
        Iterable<Company> companies = companyRepository.findAll();
        modelMap.addAttribute("companies", companies);
        return "main";
    }

//    @GetMapping("/")
//    public String main1(ModelMap map) {
//        Iterable<Employee> employer = employeeRepository.findAll();
//        map.addAttribute("employer", employer);
//        return "main";
//    }
}
