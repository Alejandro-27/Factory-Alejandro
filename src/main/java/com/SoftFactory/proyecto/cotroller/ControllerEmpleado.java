package com.SoftFactory.proyecto.cotroller;

import com.SoftFactory.proyecto.entidades.Empleado;
import com.SoftFactory.proyecto.entidades.Empresa;
import com.SoftFactory.proyecto.servicios.EmpleadoServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerEmpleado {

    @Autowired
    EmpleadoServi empleadoServi;

    //permite consultar todos los usuarios
    @GetMapping("/users")
    public List<Empleado> verEmpleados() {
        return empleadoServi.getAllEmpleados();
    }


    //permite consultar un solo usuarios
    @PostMapping("/users")
    public Empleado guardarEmpleados(@RequestBody Empleado empl) {
        return this.empleadoServi.saveOrUpdateEmpleado(empl);
    }


    //El sistema permite consultar un solo usuario
    @GetMapping("/users/{id}")
    public Empleado empleadoById(@PathVariable("id") Integer id){
        return this.empleadoServi.getEmpleadoById(id);
    }

    @PatchMapping("/users/{id}")
    public Empleado patchEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
        Empleado empl = empleadoServi.getEmpleadoById(id);
        empl.setNombre(empleado.getNombre());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRol(empleado.getRol());
        empl.setPassword(empleado.getPassword());
        empl.setEstado(empleado.getEstado());

        return empleadoServi.saveOrUpdateEmpleado(empl);
    }


    //El sistema permite eliminar un usuario
    @DeleteMapping("/users/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer id){
        boolean resp = this.empleadoServi.deleteEmpleado(id);
        if(resp){
            return "Se ha eliminado el empleado correctamente";
        }
        return "Ocurrió un error al eliminar el empleado";
    }


    //Metodo para ver los empleados que tiene una empresa
    @GetMapping("/enterprises{id}/users")
    public ArrayList<Empresa> emplForEmpresa(@PathVariable("id") Integer id){
        return empleadoServi.empleadosByEmpresa(id);
    }
}
