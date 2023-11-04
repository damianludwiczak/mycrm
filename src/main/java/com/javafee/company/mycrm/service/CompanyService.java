package com.javafee.company.mycrm.service;


import com.javafee.company.mycrm.controller.dto.CompanyDto;
import com.javafee.company.mycrm.repository.domain.Company;
import com.javafee.company.mycrm.repository.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void save(CompanyDto companyDto) {
        companyRepository.save(fromCompanyDtoToCompany(companyDto));
    }
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    public List<CompanyDto> filter(String name, Double yearlyIncomesFrom, Double yearlyIncomesTo) {
        List<Company> companyList = companyRepository.findByCriteria(name, yearlyIncomesFrom, yearlyIncomesTo);
        List<CompanyDto> companyDtoList = new ArrayList<>();
        for (Company company : companyList)
            companyDtoList.add(fromCompanyToCompanyDto(company));
        return companyDtoList;
    }

    public List<CompanyDto> findAll() {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        List<Company> companyList = companyRepository.findAll();
        for (Company company : companyList)
            companyDtoList.add(fromCompanyToCompanyDto(company));
        return companyDtoList;
    }
    private Company fromCompanyDtoToCompany (CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setYearlyIncomes(companyDto.getYearlyIncomes());
        return company;
    }

    private CompanyDto fromCompanyToCompanyDto (Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setYearlyIncomes(company.getYearlyIncomes());
        return companyDto;
    }
}
