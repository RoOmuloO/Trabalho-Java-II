/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author romul
 * @param <C>
 * @param <K>
 */
public interface IDAO<C,K> {
    
    public void salvar(C p) throws SQLException, ClassNotFoundException;
    public void alterar(C p) throws SQLException, ClassNotFoundException;
    public void apagar(C p) throws SQLException, ClassNotFoundException;
    public C buscarPelaChave(K p) throws SQLException, ClassNotFoundException;
    public ArrayList<C> buscarTodos() throws SQLException, ClassNotFoundException;
    public int quantidade() throws SQLException, ClassNotFoundException;
}
