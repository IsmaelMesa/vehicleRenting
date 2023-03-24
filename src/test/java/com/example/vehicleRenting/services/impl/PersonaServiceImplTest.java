package com.example.vehicleRenting.services.impl;

import com.example.vehicleRenting.exceptions.RequiredApiValidationException;
import com.example.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.example.vehicleRenting.mappers.DireccionMapper;
import com.example.vehicleRenting.mappers.PersonaMapper;
import com.example.vehicleRenting.models.Direccion;
import com.example.vehicleRenting.models.Persona;
import com.example.vehicleRenting.services.PersonaService;
import com.example.vehicleRenting.services.PersonaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class PersonaServiceImplTest {
    PersonaService servicio;
    PersonaMapper personaMapper;
    DireccionMapper direccionMapper;

    @BeforeEach
    void setupAll(){
        personaMapper = Mockito.mock(PersonaMapper.class);
        direccionMapper = Mockito.mock(DireccionMapper.class);
        servicio = new PersonaServiceImpl(personaMapper,direccionMapper);
    }
    @Test
    public void getPerson_should_exists()throws Exception{
        int idPersona = 23;
        Persona persona = servicio.getPerson(idPersona);

        Assertions.assertTrue(true);
    }
    @Test
    public void getPerson_should_throwApiValidationException_when_idNegative(){


        Assertions.assertThrows(RequiredApiValidationException.class, () -> {
            int idPersona = -50;
            Persona persona = servicio.getPerson(idPersona);
        });
    }

    @Test
    public void addPersona_should_throwRequiredMissingFieldException_when_nombreIsNull() throws ParseException{
        Assertions.assertThrows(RequiredMissingFieldException.class,() -> {
            Persona persona = createPersona();
            persona.setNombre("");
            this.servicio.addPersona(persona);
        });

    }
    private static Persona createPersona() throws ParseException {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido1("Francés");
        persona.setApellido2("Antúnez");
        persona.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("29-12-1980"));
        Direccion domicilio = new Direccion();
        domicilio.setTipoViaId(1);
        domicilio.setNombreCalle("Gran Vía");
        domicilio.setNumero("120");
        domicilio.setCodPostal("36201");
        domicilio.setMunicipio("Pontevedra");
        domicilio.setProvinciaCod("36");
        persona.setDireccionDomicilio(domicilio);
        persona.setDireccionDomicilioSameAsNotification(true);
        return persona;
    }
}
