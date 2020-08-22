/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hc.model.Marca;
import org.hc.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author rodol
 */
@Controller
public class MarcaController {
    @Autowired
    private MarcaService ms;
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicio(){   
        
        return "index";
    }
    
    @RequestMapping(value = "/listar_marcas", method = RequestMethod.GET)
    public String listar_marcas(Model modelo){
    
        List<Marca> lista_marcas = ms.getAll();
        
        modelo.addAttribute("lista_marcas", lista_marcas);
         
        
        return "marca";
    }
    
    
    @RequestMapping(value = "/save_marca", method = RequestMethod.POST)
    public String save_marca(HttpServletRequest request,Model modelo){
    
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        
        // traemos el model
        Marca m= new Marca();
        m.setNombre(nombre);
        m.setDescripcion(descripcion);
        
        // insertar en la base de datos
        Integer id_marca=ms.insert(m);        
        System.out.println("nombre: "+nombre+", descripcion" + descripcion);
        
        // Listamos nuevamente
        List<Marca> lista_marcas = ms.getAll();        
        modelo.addAttribute("lista_marcas", lista_marcas);
        
        return "marca";
    }
    
    
    
    @RequestMapping(value = "/eliminar_marca", method = RequestMethod.POST)
    public String eliminar_marca(HttpServletRequest request ,Model modelo) {
        
        String id_marca = request.getParameter("id_marca");
        
        boolean rpta=ms.delete(Integer.parseInt(id_marca));
        
        System.out.println("id_marca: "+id_marca);
        
        List<Marca> lista_marcas= ms.getAll();        
        modelo.addAttribute("lista_marcas", lista_marcas);
        
        return "marca";
    }
    
    
    @RequestMapping(value = "/view_edit_marca", method = RequestMethod.POST)
    public String view_edit_marca(HttpServletRequest request ,Model modelo) {
        String id_marca = request.getParameter("id_marca");
        Marca m=ms.read(Integer.parseInt(id_marca));
      
        modelo.addAttribute("me", m);
        return "marca_edit";
    }
    
    @RequestMapping(value = "/edit_marca", method = RequestMethod.POST)
    public String edit_marca(HttpServletRequest request ,Model modelo) {
        String id_marca = request.getParameter("id_marca");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Marca m= new Marca();
        m.setIdMarca(Integer.parseInt(id_marca));
        m.setNombre(nombre);
        m.setDescripcion(descripcion); 
   
        Integer rpta=ms.update(m);
        List<Marca> lista_marcas= ms.getAll();        
        modelo.addAttribute("lista_marcas", lista_marcas);
        return "marca";
    }    
    
}
