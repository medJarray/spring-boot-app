package com.springApp.spring5webapp.controllers;

import com.springApp.spring5webapp.model.Employeur;
import com.springApp.spring5webapp.services.EmployeurService;
import com.springApp.spring5webapp.services.impl.EmployeurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/Employeur")
public class EmployeurController {

    @Autowired
    private EmployeurService employeurService;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Employeur> getAllEmployeurs(){
        List<Employeur> employeurList = employeurService.getAllEmployeur();
        return  employeurList;
    }

    @RequestMapping(value = "/byName", produces = "application/json")
    public Employeur getEmployeurByName(@RequestParam ("name") String name){
        Employeur empl = employeurService.getEmployeurByName(name);
        return empl;
    }
}
