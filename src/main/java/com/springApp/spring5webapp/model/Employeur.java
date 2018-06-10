package com.springApp.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Employeur")
public class Employeur {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "nbrTichet")
    private int nbrTicketEnCharge;

    @JsonIgnore
    @OneToMany(mappedBy = "employeur")
    private List<Ticket> listeTicket = new ArrayList<>();

    public Employeur() {
    }

    public Employeur(String firstName, String lastName, String matricule, int nbrTicketEnCharge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;
        this.nbrTicketEnCharge = nbrTicketEnCharge;
    }

    public Employeur(String firstName, String lastName, String matricule, int nbrTicketEnCharge, List<Ticket> listeTicket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matricule = matricule;
        this.nbrTicketEnCharge = nbrTicketEnCharge;
        this.listeTicket = listeTicket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getNbrTicketEnCharge() {
        return nbrTicketEnCharge;
    }

    public void setNbrTicketEnCharge(int nbrTicketEnCharge) {
        this.nbrTicketEnCharge = nbrTicketEnCharge;
    }

    public List<Ticket> getListeTicket() {
        return listeTicket;
    }

    public void setListeTicket(List<Ticket> listeTicket) {
        this.listeTicket = listeTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employeur employeur = (Employeur) o;
        return Objects.equals(id, employeur.id);
    }

    @Override
    public int hashCode() {

        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employeur{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", matricule='" + matricule + '\'' +
                ", nbrTicketEnCharge=" + nbrTicketEnCharge +
                ", listeTicket=" + listeTicket +
                '}';
    }
}
