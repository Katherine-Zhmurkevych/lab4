package edu.labs.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.labs.dto.EmployeeDTO;
import edu.labs.exceptions.BaseException;
import edu.labs.services.EmployeeService;

@RestController
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Long> saveEmployee(@Validated @RequestBody final EmployeeDTO dto) {
        return ResponseEntity.ok().body(employeeService.createEmployee(dto));
    }

    @PutMapping("/employee")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Validated @RequestBody final EmployeeDTO dto) throws BaseException {
        return ResponseEntity.ok().body(employeeService.updateEmployee(dto));
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable final Long id) throws BaseException {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable final Long id) throws BaseException {
        employeeService.removeEmployeeById(id);
        return ResponseEntity.ok().build();
    }
}
