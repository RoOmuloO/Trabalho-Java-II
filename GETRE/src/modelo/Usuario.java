/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author romul
 */
public class Usuario {
    private int id;
    private String nome, login,senha;
    private Date dataUltimoAcesso;
    private String tipo;
    

    public Usuario(int id, String nome, String login, String senha, Date dataUltimoAcesso, String tipo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.dataUltimoAcesso = dataUltimoAcesso;
        this.tipo = tipo;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
