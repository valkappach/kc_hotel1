package com.kchotel.service;

import com.kchotel.dao.EmployeeRepository;
import com.kchotel.entities.Employee;
import com.kchotel.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    /** This methode find All Employees*/
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }


    /** This methode find  Employee By id*/

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + "was not found"));
    }

    /** This methode update Employee*/
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
   /*
    public Employee patchEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
*/
    /** This methode delete Employee By id*/

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);

    }


}
