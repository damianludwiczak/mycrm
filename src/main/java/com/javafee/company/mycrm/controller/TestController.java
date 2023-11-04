package com.javafee.company.mycrm.controller;

import com.javafee.company.mycrm.repository.domain.Test;
import com.javafee.company.mycrm.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Test>> findAll() {
        return ResponseEntity.ok(testService.findAll());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Test>> filter(@RequestParam String title, @RequestParam String description) {
        return ResponseEntity.ok(testService.filter(title, description));
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Test test) {
        testService.save(test);
        return ResponseEntity.ok().build();
    }
}
