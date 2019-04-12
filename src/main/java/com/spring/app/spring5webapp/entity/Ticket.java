package com.spring.app.spring5webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TicketApi")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "descriptif")
    private String descriptif;
    @Column(name = "perimetre")
    private String perimetre;
    @Column(name = "tempsTraitement")
    private float tempsTraitement;
    @Column(name = "isClos")
    private boolean isClos;
    @Column(name = "typeIntervention")
    private String typeIntervention;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "Employeur_Ticket", joinColumns = @JoinColumn(name = "employeur_matricule"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private Employer employer;

    public Ticket() {
    }

    public Ticket(String descriptif, String perimetre, float tempsTraitement, boolean isClos) {
        this.descriptif = descriptif;
        this.perimetre = perimetre;
        this.tempsTraitement = tempsTraitement;
        this.isClos = isClos;
    }


    public Ticket(String descriptif, String perimetre, float tempsTraitement, boolean isClos, String typeIntervention) {
        this.descriptif = descriptif;
        this.perimetre = perimetre;
        this.tempsTraitement = tempsTraitement;
        this.isClos = isClos;
        this.typeIntervention = typeIntervention;
    }

}
