package com.SoftFactory.proyecto.cotroller;

import com.SoftFactory.proyecto.entidades.Empleado;
import com.SoftFactory.proyecto.entidades.MovimientoDeDinero;
import com.SoftFactory.proyecto.servicios.MovimientosServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerMovimientos {

    @Autowired
    MovimientosServi movimientosServi;

    //El sistema permite consultar todos los movimientos de dinero
    @GetMapping("movements")
    public List<MovimientoDeDinero> verMovimientos(){
        return movimientosServi.getAllMovimientos();
    }

    //El sistema permite guardar los movimientos de dinero
    @PostMapping("/movements")
    public MovimientoDeDinero guardarMovimientos(@RequestBody MovimientoDeDinero movi) {
        return this.movimientosServi.guardarOActualizarMovi(movi);
    }


    //El sistema permite consultar un solo movimiento por el ID
    @GetMapping("/movements/{id}")
    public MovimientoDeDinero movimientoById(@PathVariable("id") Integer id){
        return movimientosServi.getMovimientoById(id);
    }


    @PatchMapping("/movements/{id}")
    public MovimientoDeDinero patchMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDeDinero movimiento){
        MovimientoDeDinero movi = movimientosServi.getMovimientoById(id);
        movi.setMontoDelMovimiento(movi.getMontoDelMovimiento());
        movi.setConceptoMovimiento(movi.getConceptoMovimiento());
        movi.setUsuario(movi.getUsuario());

        return movimientosServi.guardarOActualizarMovi(movi);
    }


    //El sistema permite eliminar un movimiento de dinero
    @DeleteMapping("/movements/{id}")
    public String eliminarMovimiento(@PathVariable("id") Integer id){
        boolean resp = movimientosServi.deleteMovimiento(id);
        if(resp){
            return "Se ha eliminado el movimiento de dinero correctamente";
        }
        return "Ocurrió un error al eliminar el movimiento de dinero" ;
    }


    //El sistema permite consultar el movimiento que realizó un empleado
    @GetMapping("/users/{id}/movements")
    public ArrayList <MovimientoDeDinero> movimientosByEmpleado(@PathVariable("id") Integer id){
        return movimientosServi.obtenerPorEmpleado(id);
    }

    //El sistema permite consultar el movimiento de un empleado por la empresa
    @GetMapping("/enterprises/{id}/movements")
    public ArrayList<MovimientoDeDinero> movimientosPorEmpresa(@PathVariable("id") Integer id){
        return movimientosServi.obtenerPorEmpresa(id);
    }


}
