package com.example.vehicleRenting.models;

import java.util.Date;

public class Renta {
    private int rentaId;
    private Persona persona;
    private Profesion profesion;
    private int anyo;
    private int importe;
    private boolean isCuentaPropia;
    private String iae;
    private String cifEmpleador;
    private Date fechaInicioEmpleo;

    public int getRentaId() {
        return rentaId;
    }

    public void setRentaId(int rentaId) {
        this.rentaId = rentaId;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public int getAnio() {
        return anyo;
    }

    public void setAnio(int anio) {
        this.anyo = anio;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public boolean isCuentaPropia() {
        return isCuentaPropia;
    }

    public void setCuentaPropia(boolean cuentaPropia) {
        isCuentaPropia = cuentaPropia;
    }

    public String getIae() {
        return iae;
    }

    public void setIae(String iae) {
        this.iae = iae;
    }

    public String getCifEmpleador() {
        return cifEmpleador;
    }

    public void setCifEmpleador(String cifEmpleador) {
        this.cifEmpleador = cifEmpleador;
    }

    public Date getFechaInicioEmpleo() {
        return fechaInicioEmpleo;
    }

    public void setFechaInicioEmpleo(Date fechaInicioEmpleo) {
        this.fechaInicioEmpleo = fechaInicioEmpleo;
    }
}
