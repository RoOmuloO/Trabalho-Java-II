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
import modelo.Cliente;

/**
 *
 * @author romul
 */
public class ClienteDAO implements IDAO<Cliente,Integer>{

    @Override
    public void salvar(Cliente p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO usuario_cliente(nome,CPF,Sobrenome) VALUES(?,?,?);";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1,p.getNome());
        pst.setString(2,p.getCPF());
        pst.setString(3,p.getSobrenome());
        
        pst.execute();
    }

    @Override
    public void alterar(Cliente p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "UPDATE usuario_cliente SET nome = ?,CPF = ?, sobrenome = ? WHERE idcliente = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1,p.getNome());
            pst.setString(2,p.getCPF());
            pst.setString(3, p.getSobrenome());
            pst.setInt(4,p.getId());
            
            
            pst.execute();
    }

    @Override
    public void apagar(Cliente p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "DELETE FROM usuario_cliente WHERE idcliente = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setInt(1,p.getId());
            
            
            pst.execute();
    }

    @Override
    public Cliente buscarPelaChave(Integer p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_cliente WHERE idcliente = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setInt(1,p);
            
            ResultSet rs = pst.executeQuery();
            
            Cliente cli = null;
            
            if(rs.next()){
                    cli = new Cliente(p,rs.getString("nome"), rs.getString("CPF"), rs.getString("sobrenome"));
            }
            
            return cli;
    }

    @Override
    public ArrayList<Cliente> buscarTodos() throws SQLException, ClassNotFoundException {
            Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_cliente;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            ArrayList<Cliente> lista = new ArrayList<>();
            
            while(rs.next()){
               Cliente cli = new Cliente(rs.getInt("idcliente"),rs.getString("nome"), rs.getString("CPF"), rs.getString("sobrenome"));
               lista.add(cli);
            }
            
            return lista;    
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
             Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT count(*) qtde FROM usuario_cliente;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            rs.next();
                
            return rs.getInt("qtde");
    }
    
    public ArrayList<Cliente> buscarPeloCPFPeloNome(String CPF, String nome) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_cliente WHERE CPF LIKE ? AND nome LIKE ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1,"%"+CPF+"%");
            pst.setString(2, "%"+nome+"%");
            
            
            ResultSet rs = pst.executeQuery();
            ArrayList<Cliente> lista = new ArrayList<>();
            
            while(rs.next()){
               Cliente cli = new Cliente(rs.getInt("idcliente"),rs.getString("nome"), rs.getString("CPF"), rs.getString("sobrenome"));
               lista.add(cli);
            }
            
            return lista;
    }
}
