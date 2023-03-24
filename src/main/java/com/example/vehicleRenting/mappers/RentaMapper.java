package com.example.vehicleRenting.mappers;

import com.example.vehicleRenting.models.Persona;
import com.example.vehicleRenting.models.Renta;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface RentaMapper {
    @Insert("INSERT INTO RENTA_ANUAL (PERSONA_ID, PROFESION_ID, ANIO, IMPORTE, IS_CUENTA_PROPIA, IAE, CIF_EMPLEADOR, FECHA_INICIO_EMPLEO) VALUES (#{persona.personaId}, #{profesion.profesionId}, #{anyo}, #{importe}, #{isCuentaPropia}, #{iae}, #{cifEmpleador}, #{fechaInicioEmpleo, jdbcType=DATE})")
    @Options(useGeneratedKeys = true, keyProperty = "rentaId", keyColumn = "RENTA_ID")
    void insertRenta(Renta renta);
    /*
    @Insert("INSERT INTO RENTA_ANUAL (PERSONA_ID, PROFESION_ID, ANIO, IMPORTE, IS_CUENTA_PROPIA, IAE, CIF_EMPLEADOR,FECHA_INICIO_EMPLEO) VALUES (#{persona.personaId}, #{profesion.profesionId}, #{anio}, #{importe}, #{isCuentaPropia}, #{iae}, #{cifEmpleador}, #{fechaInicioEmpleo, jdbcType=DATE})")
    @Options(useGeneratedKeys = true, keyProperty = "rentaId", keyColumn="RENTA_ID")
    void insertPersona(Renta renta); */
}
