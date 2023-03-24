package com.example.vehicleRenting.services;

import com.example.vehicleRenting.mappers.ProfesionMapper;
import com.example.vehicleRenting.mappers.RentaMapper;
import com.example.vehicleRenting.models.Profesion;
import com.example.vehicleRenting.models.Renta;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentaServiceImpl implements RentaService{
    private RentaMapper rentaMapper;
    private ProfesionMapper profesionMapper;

    public RentaServiceImpl(RentaMapper rentaMapper, ProfesionMapper profesionMapper) {
        this.rentaMapper = rentaMapper;
        this.profesionMapper = profesionMapper;
    }

    @Override
    @Transactional
    public Renta addRenta(Renta renta) {
        renta = this.addRentaProfesion(renta);
        this.rentaMapper.insertRenta(renta);
        return renta;
    }

    public Renta addRentaProfesion(Renta renta){
        this.profesionMapper.insertProfesion(renta.getProfesion());
        return renta;
    }
}
