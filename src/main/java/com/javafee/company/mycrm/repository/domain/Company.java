package com.javafee.company.mycrm.repository.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private Double yearlyIncomes;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "company_client", joinColumns = @JoinColumn(name = "id_company"),
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    @Builder.Default
    private List<Client> clientList = new ArrayList<>();

    private String yearlyIncomesFrom;
    private String yearlyIncomesTo;
}
