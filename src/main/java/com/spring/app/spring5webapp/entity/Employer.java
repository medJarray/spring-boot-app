package com.spring.app.spring5webapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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

    public Employer() {
    }

    public Employer(String firstName, String lastName, String matricule, int nbrTicketEnCharge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;
        this.nbrTicketEnCharge = nbrTicketEnCharge;
    }
}
