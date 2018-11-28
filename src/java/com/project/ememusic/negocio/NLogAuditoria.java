/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.LogAuditoria;
import com.project.ememusic.persistencia.DaoLogAuditoria;
import java.util.List;

/**
 *
 * @author eliana.vargas
 */
public class NLogAuditoria {
    DaoLogAuditoria dao;
    
    public NLogAuditoria() {
        dao = new DaoLogAuditoria();

    }
    //buscar registro 

    
    public List<LogAuditoria> listarAuditorias(LogAuditoria Auditoria) {
        return dao.ListaAuditoria(Auditoria);
    }//fin public lista
}
