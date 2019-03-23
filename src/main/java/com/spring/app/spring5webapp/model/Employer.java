package com.spring.app.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @JsonIgnore
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

    public Employer(String firstName, String lastName, String matricule, int nbrTicketEnCharge, List<Ticket> listeTicket) {
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
        Employer employer = (Employer) o;
        return Objects.equals(id, employer.id);
    }

    @Override
    public int hashCode() {

        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", matricule='" + matricule + '\'' +
                ", nbrTicketEnCharge=" + nbrTicketEnCharge +
                ", listeTicket=" + listeTicket +
                '}';
    }
}
