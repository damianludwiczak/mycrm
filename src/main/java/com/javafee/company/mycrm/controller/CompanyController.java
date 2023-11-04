package com.javafee.company.mycrm.controller;

import com.javafee.company.mycrm.controller.dto.CompanyDto;
import com.javafee.company.mycrm.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class CompanyController implements CompanyApi {
    private final CompanyService companyService;
    @Override
    public ResponseEntity<CompanyDto> createCompany(CompanyDto companyDto) {
        companyService.save(companyDto);
        return ResponseEntity.ok().build();
    }
    @Override
    public ResponseEntity<Void> deleteCompany(Long id) {
        companyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<CompanyDto>> filterCompany(String name, Double yearlyIncomesFrom, Double yearlyIncomesTo) {
        return ResponseEntity.ok(companyService.filter(name, yearlyIncomesFrom, yearlyIncomesTo));
    }

    @Override
    public ResponseEntity<CompanyDto> updateCompany(Long id, CompanyDto companyDto) {
        companyService.save(companyDto);
        return ResponseEntity.ok(companyDto);
    }

    @Override
    public ResponseEntity<List<CompanyDto>> findAllCompanies() {
        return ResponseEntity.ok(companyService.findAll());
    }
}
