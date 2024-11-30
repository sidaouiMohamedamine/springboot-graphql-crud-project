package com.sid.springboot_graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeResolver {
    @Autowired

    private  EmployeeService employeeService;


    @QueryMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @QueryMapping
    public Optional<Employee> getEmployee(@Argument Long id) {
        return employeeService.getEmployeeById(id);
    }

    @MutationMapping
    public Employee createEmployee(@Argument Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Long id, @Argument Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @MutationMapping
    public boolean deleteEmployee(@Argument Long id) {
        return employeeService.deleteEmployee(id);
    }
}
