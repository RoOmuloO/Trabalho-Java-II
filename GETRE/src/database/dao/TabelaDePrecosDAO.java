package database.dao;


import database.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.TabelaDePrecos;
import modelo.TipoDePorte;
import view.TelaTabelaDePrecos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romul
 */
public class TabelaDePrecosDAO {
    
   public ArrayList<TabelaDePrecos> buscarTodos() throws SQLException, ClassNotFoundException {
            Connection c = ConnectionFactory.getConnection();
            
                    
            String sql = "SELECT * FROM valores_distancias;";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            ArrayList<TabelaDePrecos> lista = new ArrayList<>();
            
            while(rs.next()){
               TabelaDePrecos tdp = new TabelaDePrecos(rs.getInt("idvalores_distancias"),rs.getString("ponto_inicial"),rs.getString("ponto_final"),rs.getDouble("distancia"),rs.getDouble("valor_por_Km"),rs.getDouble("Valor_Total"), (TipoDePorte) rs.getObject("tipo_porte"));
               lista.add(tdp);
            }
            
            return lista;    
    } 
}
