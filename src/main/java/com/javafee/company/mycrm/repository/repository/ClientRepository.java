package com.javafee.company.mycrm.repository.repository;

import com.javafee.company.mycrm.repository.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("from Client c where ((c.name like :name) or (:name is null)) and " +
            "((c.surname like :surname) or (:surname is null)) and " +
            "((c.nationality like :nationality) or (:nationality is null)) and " +
            "((c.wage between :wageFrom and :wageTo) " +
            "or (:wageFrom is null and :wageTo is null)" +
            "or ((:wageTo is null) and (c.wage >= :wageFrom)) " +
            "or (:wageFrom is null) and (c.wage <= :wageTo)) and " +
            "((c.age between :ageFrom and :ageTo) " +
            "or (:ageFrom is null and :ageTo is null)" +
            "or ((:ageTo is null) and (c.age >= :ageFrom)) " +
            "or (:ageFrom is null) and (c.age <= :ageTo))")
    List<Client> findByCriteria(@Param("name") String name, @Param("surname") String surname,
                                @Param("nationality") String nationality, @Param("wageFrom") Double wageFrom,
                                @Param("wageTo") Double wageTo, @Param("ageFrom") Integer ageFrom,
                                @Param("ageTo") Integer ageTo);
}
