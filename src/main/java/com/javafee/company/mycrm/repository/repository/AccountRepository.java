package com.javafee.company.mycrm.repository.repository;

import com.javafee.company.mycrm.repository.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
