package com.spring.app.spring5webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Wither;

import javax.persistence.*;

@Data
@Wither
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"employer"})
@ToString(exclude = {"employer"})
@Entity
@Table(name = "TicketApi")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "Employer_Ticket",
            joinColumns = @JoinColumn(name = "Ticket_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employer_id"))
//    @JoinColumn(name ="FK_MainMenuId")
//    https://stackoverflow.com/a/30292348/8956678
    private Employer employer;
}
