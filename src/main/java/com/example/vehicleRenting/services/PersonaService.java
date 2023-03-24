package com.example.vehicleRenting.services;

import com.example.vehicleRenting.exceptions.RequiredApiValidationException;
import com.example.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.example.vehicleRenting.models.Persona;

public interface PersonaService {
    Persona addPersona(Persona persona) throws Exception;

    Persona getPerson(int idPersona) throws Exception;
}
