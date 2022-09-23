package com.SoftFactory.proyecto.entidades;

import com.SoftFactory.proyecto.Entidades.Enum_RolName;

import javax.persistence.*;

@Entity
@Table(name="Empleado")

public class Empleado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;

    private String nombre;

    private String correo;
    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;
    private com.SoftFactory.proyecto.Entidades.Enum_RolName rol;

    private String password;
    private boolean estado;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String correo, Empresa empresa, Enum_RolName rol, String password, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
        this.password = password;
        this.estado = estado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Enum_RolName getRol() {
        return rol;
    }

    public void setRol(Enum_RolName rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
