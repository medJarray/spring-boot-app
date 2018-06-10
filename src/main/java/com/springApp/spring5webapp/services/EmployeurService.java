package com.springApp.spring5webapp.services;

import com.springApp.spring5webapp.model.Employeur;

import java.util.List;

public interface EmployeurService {
    public List<Employeur> getAllEmployeur();
    public Employeur getEmployeurByName(String name);
}
