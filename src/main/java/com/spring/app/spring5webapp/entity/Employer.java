package com.spring.app.spring5webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "nbrTicket")
    private int nbrTicketEnCharge;

    @OneToMany(mappedBy = "employer")
    private List<Ticket> listeTicket = new ArrayList<>();

}
