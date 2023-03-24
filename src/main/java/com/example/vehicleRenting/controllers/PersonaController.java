package com.example.vehicleRenting.controllers;

import com.example.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.example.vehicleRenting.models.Persona;
import com.example.vehicleRenting.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    PersonaService personaService;

    PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }
    @PostMapping("/persona")
    ResponseEntity addPersona(@RequestBody Persona persona) throws Exception{

        try {
            this.personaService.addPersona(persona);

        }catch (RequiredMissingFieldException e) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comprueba los datos de entrada");
        }
        return ResponseEntity.ok(persona);
    }
}
