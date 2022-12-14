package com.SoftFactory.proyecto.servicios;

import com.SoftFactory.proyecto.entidades.Empresa;
import com.SoftFactory.proyecto.repositorios.EmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServi {
    @Autowired
    EmpresaRepo empresaRepo;
    //metodo que retornĂ¡ la lista deempresas usando metodos heredados del jpaRepository
    public List<Empresa> getAllEmpresa(){
        List<Empresa>empresaList = new ArrayList<>();
        empresaRepo.findAll().forEach(empresa -> empresaList.add(empresa));//recorremos la
        return empresaList;
    }
    //metodo que trae un objetode tipo empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaRepo.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    /*public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepo.save(empresa);
        if (empresaRepo.findById(emp.getId())!=null){
           return true;
        }
        return false;
    }*/


    //Metodo para el @RestController

    public Empresa saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepo.save(empresa);
        return emp;
    }


    //Metodo para eliminar empresa registradas teniendo el id

    public boolean deleEmpresa(Integer id){
        empresaRepo.deleteById(id);
        if (empresaRepo.findById(id)!=null){
            return true;
        }
        return false;
    }

}
