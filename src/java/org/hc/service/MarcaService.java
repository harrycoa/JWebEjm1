/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hc.service;

import java.util.List;
import org.hc.dao.MarcaDao;
import org.hc.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodol
 */
@Service
public class MarcaService {

    @Autowired
    private MarcaDao mdao = new MarcaDao();

    public Integer insert(Marca m) {
        return mdao.insert(m);
    }

    public Integer update(Marca m) {
        return mdao.update(m);
    }

    public boolean delete(Integer id_marca) {
        return mdao.delete(id_marca);
    }

    public Marca read(Integer id_marca) {
        return mdao.read(id_marca);
    }

    public List<Marca> getAll() {
        return mdao.getAll();
    }
}
