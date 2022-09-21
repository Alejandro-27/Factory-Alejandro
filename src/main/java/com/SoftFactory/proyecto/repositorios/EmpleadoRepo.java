package com.SoftFactory.proyecto.repositorios;

import com.SoftFactory.proyecto.entidades.Empleado;
import com.SoftFactory.proyecto.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmpleadoRepo extends JpaRepository <Empleado, Integer> {

    //@Query(value = "SELECT *FROM movimiento_de_dinero empleado_1 in(select id from empleado where empresa_id = ?1)", nativeQuery = true)
    @Query(value = "SELECT * FROM empleado where empresa_id = ?1", nativeQuery= true)
    public abstract ArrayList<Empresa> fiandByEmpresa(Integer id);
}
