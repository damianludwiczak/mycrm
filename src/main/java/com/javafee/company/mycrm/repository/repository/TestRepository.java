package com.javafee.company.mycrm.repository.repository;

import com.javafee.company.mycrm.repository.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findAllByTitleContainingAndDescriptionContaining(String title, String description);
}
