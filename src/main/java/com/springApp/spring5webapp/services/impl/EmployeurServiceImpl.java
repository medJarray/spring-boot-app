package com.springApp.spring5webapp.services.impl;

import com.springApp.spring5webapp.model.Employeur;
import com.springApp.spring5webapp.repositories.EmployeurRepository;
import com.springApp.spring5webapp.services.EmployeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeurServiceImpl implements EmployeurService {

    @Autowired
    private EmployeurRepository employeurRepository;


    @Override
    public List<Employeur> getAllEmployeur(){
        List<Employeur> employeurList = employeurRepository.findAll();
        return  employeurList;
    }

    @Override
    public Employeur getEmployeurByName(String name) {
        Employeur empl = employeurRepository.findEmployeursByName(name);
        return empl;
    }
}
