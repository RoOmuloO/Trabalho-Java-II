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
public class Motorista extends Pessoa{
    
    private String CNH;
    
    public Motorista(String CNH, int id, String nome, String sobrenome, String CPF){
        super(id, nome, sobrenome, CPF);
        this.CNH = CNH;
    }

    public Motorista(int id, String nome, String CPF, String CNH) {
        super(id,nome,CPF,CNH);
    }
    
    public String getCNH(){
        return CNH;
    }
    
    public void setCNH(String CNH){
        this.CNH = CNH;
    }
    
    
}
