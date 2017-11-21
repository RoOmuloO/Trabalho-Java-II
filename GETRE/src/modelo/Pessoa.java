/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author romul
 */
public class Pessoa {
    
    private int id;
    private String nome,sobrenome, CPF;
    
        
    public Pessoa(int id, String nome,String sobrenome, String CPF){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
    }
    
    public int getId(){
        return id;
    }
    
    public void setID(){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCPF(){
        return CPF;
    }
    
    public void setCPF (String CPF){
        this.CPF = CPF;
    }
    
    public String getSobrenome(){
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
}
