package com.spring.app.spring5webapp.entity;

import lombok.*;
import lombok.experimental.Wither;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Wither
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "matricule")
    private String matricule;

    @OneToMany(mappedBy = "employer", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();

    public Ticket addTicket(Ticket ticket) {
        if (getTickets() == null) {
            tickets = new HashSet<>();
        }
        getTickets().add(ticket);
        ticket.setEmployer(this);
        return ticket;
    }

    public Ticket removeTicket(Ticket ticket) {
        getTickets().remove(ticket);
        ticket.setEmployer(null);
        return ticket;
    }


}
