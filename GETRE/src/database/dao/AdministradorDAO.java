/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Administrador;
import modelo.Cliente;

/**
 *
 * @author romul
 */
public class AdministradorDAO implements IDAO<Administrador,Integer> {

    @Override
    public void salvar(Administrador p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO usuario_administrador(nome,CPF) VALUES(?,?);";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1,p.getNome());
        pst.setString(2,p.getCPF());
        
        
        pst.execute();    }

    @Override
    public void alterar(Administrador p) throws SQLException, ClassNotFoundException {
Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "UPDATE usuario_administrador SET nome = ?,CPF = ? WHERE idusuario_administrador = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1,p.getNome());
            pst.setString(2,p.getCPF());
            pst.setInt(3,p.getId());
            
            
            pst.execute();    }

    @Override
    public void apagar(Administrador p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "DELETE FROM usuario_administrador WHERE idusuario_administrador = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setInt(1,p.getId());
            
            
            pst.execute();
    }

    @Override
    public Administrador buscarPelaChave(Integer p) throws SQLException, ClassNotFoundException {
Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_administrador WHERE idusuario_administrador = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setInt(1,p);
            
            ResultSet rs = pst.executeQuery();
            
            Administrador adm = null;
            
            if(rs.next()){
                    adm = new Administrador(p,rs.getString("nome"), rs.getString("CPF"), rs.getString("sobrenome"));
            }
            
            return adm;    }

    @Override
    public ArrayList<Administrador> buscarTodos() throws SQLException, ClassNotFoundException {
            Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_administrador;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            ArrayList<Administrador> lista = new ArrayList<>();
            
            while(rs.next()){
               Administrador adm = new Administrador(rs.getInt("idcliente"),rs.getString("nome"), rs.getString("CPF"), rs.getString("sobrenome"));
               lista.add(adm);
            }
            
            return lista;    
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
 Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT count(*) qtde FROM usuario_administrador;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            rs.next();
                
            return rs.getInt("qtde");    }
    
     public ArrayList<Administrador> buscarPeloCPFPeloNome(String CPF, String nome) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_administrador WHERE CPF LIKE ? AND nome LIKE ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1,"%"+CPF+"%");
            pst.setString(2, "%"+nome+"%");
            
            
            ResultSet rs = pst.executeQuery();
            ArrayList<Administrador> lista = new ArrayList<>();
            
            while(rs.next()){
               Administrador adm = new Administrador(rs.getInt("idusuario_administrador"),rs.getString("nome"),rs.getString("CPF"),rs.getString("sobrenome"));
               lista.add(adm);
            }
            
            return lista;
    }
    
}
