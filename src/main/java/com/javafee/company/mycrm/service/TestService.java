package com.javafee.company.mycrm.service;

import com.javafee.company.mycrm.repository.domain.Test;
import com.javafee.company.mycrm.repository.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public List<Test> filter(String title, String description) {
        return testRepository.findAllByTitleContainingAndDescriptionContaining(title, description);
    }

    public void save(Test test) {
        testRepository.save(test);
    }
}
