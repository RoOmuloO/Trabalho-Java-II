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
public class TabelaDePrecos {
    private int id;
    private String pontoInicial,pontoFinal;
    private double distancia, valorPorKm, valorTotal;
    private String tipo;

    public TabelaDePrecos() {
    }

    public TabelaDePrecos(int id, String pontoInicial, String pontoFinal, double distancia, double valorPorKm, double valorTotal, String tipo) {
        this.id = id;
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
        this.distancia = distancia;
        this.valorPorKm = valorPorKm;
        this.valorTotal = valorTotal;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(String pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public String getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(String pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }

    public void setValorPorKm(double valorPorKm) {
        this.valorPorKm = valorPorKm;
    }

    public double getValorTotal() {
        return valorTotal;
    } 

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getTipo(String tipo) {
        return tipo;
        }

   
    
    
}
