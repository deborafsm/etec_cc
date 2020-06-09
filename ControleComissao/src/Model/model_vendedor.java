/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Debora Freire T.I
 * @version 1.0
 * 
 */
public class model_vendedor {
    private String nomeVend;
    private double salario;
    private double valorVenda;

    public model_vendedor() {
    }

    public model_vendedor(String nomeVend, double salario, double valorVenda) {
        this.nomeVend = nomeVend;
        this.salario = salario;
        this.valorVenda = valorVenda;
    }

    public model_vendedor(double salario, double valorVenda) {
        this.salario = salario;
        this.valorVenda = valorVenda;
    }
    

    public String getNomeVend() {
        return nomeVend;
    }

    public void setNomeVend(String nomeVend) {
        this.nomeVend = nomeVend;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
        
       
//Deus seja louvado    
}
