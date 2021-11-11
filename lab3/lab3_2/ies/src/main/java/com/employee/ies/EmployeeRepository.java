package com.employee.ies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.employee.ies.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    List<Employee> findByEmailId(String email);
}
