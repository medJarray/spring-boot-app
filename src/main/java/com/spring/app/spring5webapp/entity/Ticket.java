package com.spring.app.spring5webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
