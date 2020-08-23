/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.service;

import java.util.List;
import org.hc.dao.UsuarioDao;
import org.hc.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodol
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao udao = new UsuarioDao();

    public Integer insert(Usuario m) {
        return udao.insert(m);
    }

    public Integer update(Usuario m) {
        return udao.update(m);
    }

    public boolean delete(Integer id_usuario) {
        return udao.delete(id_usuario);
    }

    public Usuario read(Integer id_usuario) {
        return udao.read(id_usuario);
    }

    public List<Usuario> getAll() {
        return udao.getAll();
    }
    
    
    public boolean validar_usuario(String login, String clave) {
        return udao.validar_usuario(login,clave);
    }
}
