package com.javafee.company.mycrm.repository.repository;

import com.javafee.company.mycrm.repository.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("from Company c where ((:name is null) or (c.name like :name)) " +
                "and ((c.yearlyIncomes between :yearlyIncomesFrom and :yearlyIncomesTo) " +
            "or (:yearlyIncomesFrom is null and :yearlyIncomesTo is null)" +
            "or ((:yearlyIncomesTo is null) and (c.yearlyIncomes >= :yearlyIncomesFrom)) " +
            "or (:yearlyIncomesFrom is null) and (c.yearlyIncomes <= :yearlyIncomesTo))")
    List<Company> findByCriteria(@Param("name") String name, @Param("yearlyIncomesFrom") Double yearlyIncomesFrom,
                                                              @Param("yearlyIncomesTo") Double yearlyIncomesTo);
}
