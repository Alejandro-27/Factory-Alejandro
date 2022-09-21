package com.SoftFactory.proyecto.servicios;

import com.SoftFactory.proyecto.entidades.Empleado;
import com.SoftFactory.proyecto.entidades.Empresa;
import com.SoftFactory.proyecto.repositorios.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServi {

    @Autowired
    EmpleadoRepo empleadoRepo;

    //Metodo para ver todos los empleados

    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepo.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }


    //Metodo para ver al empleado por el id

    public Empleado getEmpleadoById(Integer id){
        return empleadoRepo.findById(id).get();
    }

    //Metodo que permite guardar o actualizar un usuario

    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        Empleado empl=empleadoRepo.save(empleado);
        return empl;
    }

    //Metod para eliminar un empleado por el ID

    public boolean deleteEmpleado(Integer id){
        empleadoRepo.deleteById(id);
        if (empleadoRepo.findById(id)!=null){
            return true;
        }
        return false;
    }

    //Metodo para ver los empleados que tiene cirta empresa

    public ArrayList<Empresa> empleadosByEmpresa(Integer id){
        return empleadoRepo.fiandByEmpresa(id);
    }




}
