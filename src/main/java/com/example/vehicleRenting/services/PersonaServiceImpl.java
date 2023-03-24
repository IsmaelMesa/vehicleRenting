package com.example.vehicleRenting.services;

import com.example.vehicleRenting.exceptions.RequiredApiValidationException;
import com.example.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.example.vehicleRenting.mappers.DireccionMapper;
import com.example.vehicleRenting.mappers.PersonaMapper;
import com.example.vehicleRenting.models.Persona;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService{

    private DireccionMapper direccionMapper;
    private PersonaMapper personaMapper;

    public PersonaServiceImpl(PersonaMapper personaMapper,DireccionMapper direccionMapper) {
        this.personaMapper = personaMapper;
        this.direccionMapper = direccionMapper;
    }

    @Override
    @Transactional
    public Persona addPersona(Persona persona) throws RequiredMissingFieldException {
        this.validatePersonaData(persona);
        persona = this.addPersonaDireccion(persona);
        this.personaMapper.insertPersona(persona);
        return persona;
    }
    private Persona addPersonaDireccion(Persona persona){
        this.direccionMapper.insertDireccion(persona.getDireccionDomicilio());
        if(persona.isDireccionDomicilioSameAsNotification()) {
            persona.setDireccionNotificacion(persona.getDireccionDomicilio());
        }else {
            this.direccionMapper.insertDireccion(persona.getDireccionNotificacion());
        }
        return persona;
    }

    private void validatePersonaData(Persona persona) throws RequiredMissingFieldException {
        this.validateNombre(persona);

    }

    private void validateNombre(Persona persona) throws RequiredMissingFieldException {
        if(persona.getNombre() == null || persona.getNombre().isEmpty()) {
            throw new RequiredMissingFieldException();
        }
    }

    @Override
    public Persona getPerson(int idPersona) throws Exception {
        if(idPersona < 0) {
            throw new RequiredApiValidationException();
        }

        return null;
    }
}
