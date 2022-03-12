package com.example.companyemployeespring.repository;

import com.example.companyemployeespring.entity.Company;
import com.example.companyemployeespring.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company,Integer> {
    List<Company> findAllByName(String name);

}
