package com.example.vehicleRenting.controllers;

import com.example.vehicleRenting.models.Renta;
import com.example.vehicleRenting.services.RentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentaController {

    RentaService rentaService;

    public RentaController(RentaService rentaService) {
        this.rentaService = rentaService;
    }

    @PostMapping("/renta")
    ResponseEntity addRenta(@RequestBody Renta renta){
        rentaService.addRenta(renta);
        return ResponseEntity.ok(renta);
    }
}
