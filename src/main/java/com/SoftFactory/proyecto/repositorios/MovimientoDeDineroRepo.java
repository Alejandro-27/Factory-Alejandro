package com.SoftFactory.proyecto.repositorios;

import com.SoftFactory.proyecto.entidades.MovimientoDeDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientoDeDineroRepo extends JpaRepository<MovimientoDeDinero, Integer> {

    //Método para filtrar movimientos por empleados
    @Query(value ="select * from movimiento_de_dinero where empleado_id= ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDeDinero> fiandByEmpleado(Integer id);


    //Método para filtrar movimientos por empresa
    @Query(value = "SELECT *FROM movimiento_de_dinero empleado_1 in(select id from empleado where empresa_id = ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDeDinero> fiandByEmpresa(Integer id);
}
