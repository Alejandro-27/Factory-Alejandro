/*
package com.SoftFactory.proyecto.cotroller;

import com.SoftFactory.proyecto.entidades.Empresa;
import com.SoftFactory.proyecto.servicios.EmpresaServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Controlador {
    @Autowired
    EmpresaServi empresaServi;

    @GetMapping({"/", "/VerListaEmpresas"})
    public String verEmpresas(Model model, @ModelAttribute ("mensaje") String mensaje) {
        List<Empresa> listaEmpresas = empresaServi.getAllEmpresa();
        model.addAttribute("factlist", listaEmpresas);
        model.addAttribute("mensaje", mensaje);
        return "verListaEmpresas"; //llamamos al HTML
    }

    @GetMapping("/AgregarEmpresas")
    public String newEmpresa(Model model, @ModelAttribute ("mensaje") String mensaje) {
        Empresa emp = new Empresa();
        model.addAttribute("emp", emp);
        model.addAttribute("mensaje", mensaje);
        return "agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes) {
        if (empresaServi.saveOrUpdateEmpresa(emp)) {
            redirectAttributes.addFlashAttribute("mensaje", "guaradada");
            return "redirect:/VerListaEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje", "errorGuardar" );
        return "redirect:/AgregarEmpresas";
    }


    @GetMapping ("/EditarEmpresa/{id}")
    public String editarEmpresa ( Model model, @PathVariable Integer id, @ModelAttribute ("mensaje") String mensaje) {
        Empresa emp = empresaServi.getEmpresaById ( id );
        model.addAttribute ("emp" , emp );
        model.addAttribute("mensaje", mensaje);
        return "editarEmpresa" ;
    }


    @PostMapping("/ActualizarEmpresa")
    public String actualizarEmpresa(@ModelAttribute("emp") Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaServi.saveOrUpdateEmpresa(emp)){
            redirectAttributes.addFlashAttribute("mensaje","actualizada");
            return "redirect:/VerListaEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","Error al actualizar la empresa");
        return "redirect:/EditarEmpresa";
    }


    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if(empresaServi.deleEmpresa(id)){
            redirectAttributes.addFlashAttribute("mensaje","eliminada");
            return "redirect:/VerListaEmpresas";
        }
        redirectAttributes.addFlashAttribute("mensaje","errorDelete");
        return "redirect:/VerListaEmpresas";
    }



}
*/