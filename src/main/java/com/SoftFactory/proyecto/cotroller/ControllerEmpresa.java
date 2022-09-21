package com.SoftFactory.proyecto.cotroller;

import com.SoftFactory.proyecto.entidades.Empresa;
import com.SoftFactory.proyecto.servicios.EmpresaServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class ControllerEmpresa {

    @Autowired
    EmpresaServi empresaServi;

    @GetMapping("/enterprises")
    public List<Empresa> verEmpresas() {
        return empresaServi.getAllEmpresa();
    }

    @PostMapping("/enterprises")
    public Empresa guardarEmpresa(@RequestBody Empresa emp) {
        return this.empresaServi.saveOrUpdateEmpresa(emp);

    }

    @GetMapping("/enterprises/{id}")

    public Empresa empresaById(@PathVariable ("id") Integer id){
        return this.empresaServi.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa patchEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
        Empresa emp = empresaServi.getEmpresaById(id);
        emp.setNombreEmpresa(empresa.getNombreEmpresa());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());

        return empresaServi.saveOrUpdateEmpresa(emp);
    }

    @DeleteMapping("/enterprises/{id}")
    public String eliminarEmpresa(@PathVariable("id") Integer id){
        boolean resp = this.empresaServi.deleEmpresa(id);
        if(resp){
            return "Se ha eliminado la empresa correctamente";
        }
        return "Ocurrió un error al eliminar la empresa";
    }

}