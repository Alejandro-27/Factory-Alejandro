package com.SoftFactory.proyecto.servicios;

import com.SoftFactory.proyecto.entidades.Empleado;
import com.SoftFactory.proyecto.entidades.MovimientoDeDinero;
import com.SoftFactory.proyecto.repositorios.MovimientoDeDineroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientosServi {

    @Autowired
    MovimientoDeDineroRepo movimientoDeDineroRepo;

    //Metodo para ver todos los movimientos

    public List<MovimientoDeDinero> getAllMovimientos(){
        List<MovimientoDeDinero> movimientosList = new ArrayList<>();
        movimientoDeDineroRepo.findAll().forEach(MovimientoDeDinero -> movimientosList.add(MovimientoDeDinero));
        return movimientosList;
    }


    //Metodo para ver el movimiento por el ID
    public MovimientoDeDinero getMovimientoById (Integer id ){
        return movimientoDeDineroRepo.findById(id).get();
    }


    //Metodo que permite guardar o actualizar un movimiento
    public MovimientoDeDinero guardarOActualizarMovi (MovimientoDeDinero movimientoDeDinero){
        MovimientoDeDinero movi = movimientoDeDineroRepo.save(movimientoDeDinero);
        return movi;
    }

    //Metodo que elimina un movimiento por el ID
    public boolean deleteMovimiento(Integer id){
        movimientoDeDineroRepo.deleteById(id);
        if (movimientoDeDineroRepo.findById(id).isPresent()){
            return true;
        }
        return false;
    }

    //Obterner el movimiento teniendo en cuenta el id del empleado
    public ArrayList<MovimientoDeDinero> obtenerPorEmpleado(Integer id) {
        return movimientoDeDineroRepo.fiandByEmpleado(id);
    }


    //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
    public ArrayList<MovimientoDeDinero> obtenerPorEmpresa(Integer id){
        return movimientoDeDineroRepo.fiandByEmpresa(id);
    }

}
