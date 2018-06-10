package com.springApp.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Ticket {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descriptif;
    private String perimetre;
    private float tempsTraitement;
    private boolean isClos;
    private String typeIntervention;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "Employeur_Ticket", joinColumns = @JoinColumn(name = "employeur_matricule"),
    inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private Employeur employeur;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getPerimetre() {
        return perimetre;
    }

    public void setPerimetre(String perimetre) {
        this.perimetre = perimetre;
    }

    public float getTempsTraitement() {
        return tempsTraitement;
    }

    public void setTempsTraitement(float tempsTraitement) {
        this.tempsTraitement = tempsTraitement;
    }

    public boolean isClos() {
        return isClos;
    }

    public void setClos(boolean clos) {
        isClos = clos;
    }

    public String getTypeIntervention() {
        return typeIntervention;
    }

    public void setTypeIntervention(String typeIntervention) {
        this.typeIntervention = typeIntervention;
    }

    public Employeur getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Employeur employeur) {
        this.employeur = employeur;
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
        return "Ticket{" +
                "id=" + id +
                ", descriptif='" + descriptif + '\'' +
                ", perimetre=" + perimetre +
                ", tempsTraitement=" + tempsTraitement +
                ", isClos=" + isClos +
                ", typeIntervention='" + typeIntervention + '\'' +
                ", employeur=" + employeur +
                '}';
    }
}
