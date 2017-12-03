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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.ETipoUsuario;
import modelo.Usuario;

/**
 *
 * @author romul
 */
public class UsuarioDAO implements IDAO<Usuario,Integer>{

    @Override
    public void salvar(Usuario p) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Usuario p) throws SQLException, ClassNotFoundException {
Connection c = ConnectionFactory.getConnection();

        String sql = "UPDATE usuario SET "
                + "nome = ?,"
                + "login = ?,"
                + "senha = ?,"
                + "data_ultimo_acesso = ?,"
                + "tipo_usuario = ? "
                + "WHERE idUsuario = ?;";

        PreparedStatement pst = c.prepareStatement(sql);

        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        pst.setString(1, p.getNome());
        pst.setString(2, p.getLogin());
        pst.setString(3, p.getSenha());
        //pst.setString(4, sdf.format(p.getDataUltimoAcesso()) );
        pst.setObject(4, p.getDataUltimoAcesso());
        pst.setString(5, p.getTipo().toString());
        pst.setInt(6, p.getId());

        pst.executeUpdate();    }

    @Override
    public void apagar(Usuario p) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscarPelaChave(Integer p) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> buscarTodos() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario buscarPeloLoginESenha(String login, String senha) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnection();
        String sql = "select * from usuario where login = ? and senha = ?;";
        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, login);
        pst.setString(2, senha);
        

        ResultSet rs = pst.executeQuery();
        Usuario u = null;
        if (rs.next()) {
            u = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"),
                    rs.getString("login"), rs.getString("senha"),
                    null, 
                    rs.getString("tipo_usuario"));
        }
        return u;
    }
}
