package com.javafee.company.mycrm.repository.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
    private String surname;
    private String nationality;
    private Double wage;
    private Integer age;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "clientList")
    @JsonIgnore
    @Builder.Default
    private List<Company> companyList = new ArrayList<>();

    private String ageFrom;
    private String ageTo;
    private String wageFrom;
    private String  wageTo;
}
