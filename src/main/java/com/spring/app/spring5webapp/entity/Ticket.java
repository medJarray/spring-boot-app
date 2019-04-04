package com.spring.app.spring5webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {

        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TicketApi{" +
                "id=" + id +
                ", descriptif='" + descriptif + '\'' +
                ", perimetre=" + perimetre +
                ", tempsTraitement=" + tempsTraitement +
                ", isClos=" + isClos +
                ", typeIntervention='" + typeIntervention + '\'' +
                ", employer=" + employer +
                '}';
    }
}
