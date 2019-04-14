package com.spring.app.spring5webapp.service;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.entity.Ticket;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;

import java.util.Arrays;
import java.util.List;

public class DataProvider {
    public static Employer getEmployer() {
        return new Employer().builder()
                             .firstName("Mohamed")
                             .lastName("Jarray")
                             .matricule("MJA14588")
                             .build();
    }

    public static List<Employer> getEmployerList() {
        Employer employer1 = getEmployer();
        Employer employer2 = new Employer().builder()
                                           .firstName("Mohamed-I")
                                           .lastName("Jarray")
                                           .matricule("MJA14588")
                                           .build();
        return Arrays.asList(employer1, employer2);
    }

    public static CreateEmployer getCreateEmployer() {
        return new CreateEmployer().builder()
                                   .firstName("toti")
                                   .lastName("tata")
                                   .matricule("mat1245")
                                   .build();
    }

    public static EmployerElement getEmployerElement() {
        return new EmployerElement().builder()
                                    .firstName("toti")
                                    .lastName("tata")
                                    .matricule("mat1245")
                                    .build();
    }

    public static List<EmployerElement> getEmployerElementList() {
        EmployerElement employer1 = getEmployerElement();
        EmployerElement employer2 = new EmployerElement().builder()
                                                         .firstName("Mohamed-I")
                                                         .lastName("Jarray")
                                                         .matricule("MJA14588")
                                                         .build();
        return Arrays.asList(employer1, employer2);
    }

    public static Ticket getTicket() {
        return new Ticket().builder()
                           .id(15L)
                           .descriptif("Probleme lors de la recuperation des PP")
                           .perimetre("ERP")
                           .tempsTraitement(0.25f)
                           .isClos(true)
                           .build();
    }
}
