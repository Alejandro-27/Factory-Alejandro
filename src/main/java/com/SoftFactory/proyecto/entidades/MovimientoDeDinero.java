package com.SoftFactory.proyecto.entidades;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MovimientoDeDinero")
public class MovimientoDeDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = " id ", nullable = false)
    private int id;
    private long montoDelMovimiento;
    private String conceptoMovimiento;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado usuario;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fecha;


    public MovimientoDeDinero() {
    }

    public MovimientoDeDinero(long montoDelMovimiento, String conceptoMovimiento, Empleado usuario, Date fecha) {
        this.montoDelMovimiento = montoDelMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMontoDelMovimiento() {
        return montoDelMovimiento;
    }

    public void setMontoDelMovimiento(long montoDelMovimiento) {
        this.montoDelMovimiento = montoDelMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}