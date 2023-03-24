package com.example.vehicleRenting.services;

import com.example.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.example.vehicleRenting.models.Persona;
import com.example.vehicleRenting.models.Renta;

public interface RentaService {
    Renta addRenta(Renta renta);

}
