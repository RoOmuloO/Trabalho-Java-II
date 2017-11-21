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
import modelo.Motorista;

/**
 *
 * @author romul
 */
public class MotoristaDAO implements IDAO<Motorista,Integer> {

    @Override
    public void salvar(Motorista p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO usuario_motorista(nome,CPF,CNH) VALUES(?,?,?);";
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1,p.getNome());
        pst.setString(2,p.getCPF());
        pst.setString(3,p.getCNH());
        
        pst.execute();
    }

    @Override
    public void alterar(Motorista p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "UPDATE usuario_cliente SET nome = ?,CPF = ?, CNH = ? WHERE idusuario_motorista = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1,p.getNome());
            pst.setString(2,p.getCPF());
            pst.setString(3, p.getCNH());
            pst.setInt(4,p.getId());
            
            
            pst.execute();
    }

    @Override
    public void apagar(Motorista p) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "DELETE FROM usuario_motorista WHERE idusuario_motorista = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setInt(1,p.getId());
            
            
            pst.execute();
    }

    @Override
    public Motorista buscarPelaChave(Integer p) throws SQLException, ClassNotFoundException {
            Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_motorista WHERE idusuario_motorista = ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setInt(1,p);
            
            ResultSet rs = pst.executeQuery();
            
            Motorista mot = null;
            
            if(rs.next()){
                    mot = new Motorista(p,rs.getString("nome"), rs.getString("CPF"), rs.getString("CNH"));
            }
            
            return mot;
        }

    @Override
    public ArrayList<Motorista> buscarTodos() throws SQLException, ClassNotFoundException {
         Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_motorista;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            ArrayList<Motorista> lista = new ArrayList<>();
            
            while(rs.next()){
               Motorista mot = new Motorista(rs.getInt("idcliente"),rs.getString("nome"), rs.getString("CPF"), rs.getString("CNH"));
               lista.add(mot);
            }
            
            return lista;    
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
 Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT count(*) qtde FROM usuario_motorista;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            
            rs.next();
                
            return rs.getInt("qtde");    }

    public ArrayList<Motorista> buscarPeloCPFPeloNome(String CPF, String nome) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM usuario_motorista WHERE CPF LIKE ? AND nome LIKE ?;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1,"%"+CPF+"%");
            pst.setString(2, "%"+nome+"%");
            
            
            ResultSet rs = pst.executeQuery();
            ArrayList<Motorista> lista = new ArrayList<>();
            
            while(rs.next()){
               Motorista mot = new Motorista(rs.getInt("idcliente"),rs.getString("nome"), rs.getString("CPF"), rs.getString("CNH"));
               lista.add(mot);
            }
            
            return lista;
    }
    
    
}
