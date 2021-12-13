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

import edu.labs.dto.CustomerDTO;
import edu.labs.exceptions.BaseException;
import edu.labs.services.CustomerService;

@RestController
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Long> saveCustomer(@Validated @RequestBody final CustomerDTO dto) {
        return ResponseEntity.ok().body(customerService.createCustomer(dto));
    }

    @PutMapping("/customer")
    public ResponseEntity<CustomerDTO> updateCustomer(@Validated @RequestBody final CustomerDTO dto)
            throws BaseException {
        return ResponseEntity.ok().body(customerService.updateCustomer(dto));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable final Long id) throws BaseException {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable final Long id) throws BaseException {
        customerService.removeCustomerById(id);
        return ResponseEntity.ok().build();
    }
}
