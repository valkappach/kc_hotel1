package com.kchotel.dao;

import com.kchotel.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /* la fonction est utiliser dans employeeService */
    void deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);
}
