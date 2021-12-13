package edu.labs.controllers;

import edu.labs.dto.CompanyDTO;
import edu.labs.exceptions.BaseException;
import edu.labs.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<Long> saveCompany(@Validated @RequestBody final CompanyDTO dto) {
        return ResponseEntity.ok().body(companyService.createCompany(dto));
    }

    @PutMapping("/company")
    public ResponseEntity<CompanyDTO> updateCompany(@Validated @RequestBody final CompanyDTO dto) throws BaseException {
        return ResponseEntity.ok().body(companyService.updateCompany(dto));
    }

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        return ResponseEntity.ok().body(companyService.getAllCompanies());
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable final Long id) throws BaseException {
        return ResponseEntity.ok().body(companyService.getCompanyById(id));
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity deleteTaskById(@PathVariable final Long id) throws BaseException {
        companyService.removeCompanyById(id);
        return ResponseEntity.ok().build();
    }
}
