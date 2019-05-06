package com.spring.app.spring5webapp.service;

import com.spring.app.spring5webapp.entity.Employer;
import com.spring.app.spring5webapp.entity.Ticket;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;

import java.util.Arrays;
import java.util.List;

public class DataProvider {
    public static Employer getEmployer() {
        return new Employer().withFirstName("Mohamed")
                             .withLastName("Jarray")
                             .withMatricule("MJA14588");
    }

    public static List<Employer> getEmployerList() {
        Employer employer1 = getEmployer();
        Employer employer2 = new Employer().withFirstName("Mohamed-I")
                                           .withLastName("Jarray")
                                           .withMatricule("MJA14588");
        return Arrays.asList(employer1, employer2);
    }

    public static CreateEmployer getCreateEmployer() {
        return new CreateEmployer().withFirstName("toti")
                                   .withLastName("tata")
                                   .withMatricule("mat1245");
    }

    public static EmployerElement getEmployerElement() {
        return new EmployerElement().withFirstName("toti")
                                    .withLastName("tata")
                                    .withMatricule("mat1245");
    }

    public static List<EmployerElement> getEmployerElementList() {
        EmployerElement employer1 = getEmployerElement();
        EmployerElement employer2 = new EmployerElement().withFirstName("Mohamed-I")
                                                         .withLastName("Jarray")
                                                         .withMatricule("MJA14588");
        return Arrays.asList(employer1, employer2);
    }

    public static Ticket getTicket() {
        return new Ticket().withId(15L)
                           .withDescriptif("Probleme lors de la recuperation des PP")
                           .withPerimetre("ERP")
                           .withTempsTraitement(0.25f)
                           .withClos(true);
    }
}
