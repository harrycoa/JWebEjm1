/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hc.model.Usuario;
import org.hc.service.UsuarioService;
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
public class UsuarioController extends GeneralController{
        
    @Autowired
    private UsuarioService us;
    
    @RequestMapping(value = "/validar_usuario", method = RequestMethod.POST)
    public String validar_usuario(HttpServletRequest request ,Model modelo) {
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        
       boolean rpta=us.validar_usuario(usuario, this.getMD5(clave));
      
        String retorno;
        if(rpta){
            retorno="principal";
        }else{
            retorno="index";
            msj="USUARIO O CONTRASEÑA INCORRECTO";
            modelo.addAttribute("msj",msj);
        }
        
        return retorno;
    }
           
}
