/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connection.connection_controleComissao;
import Model.model_vendedor;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Debora Freire T.I
 * @version 1.0
 * 
 */
public class dao_controleComissao {

    private Connection con = null;
    private PreparedStatement ps = null;
    ResultSet rs = null;

    public dao_controleComissao() {
        con = connection_controleComissao.getConnection(); //Se conecta ao banco de dados
    }

//Adicionar Vendendor no banco de dados

    public void adicionarVendedor(model_vendedor vendedor) {//A classe vendedor é paramentizada para pegar ou setar valores do banco de dados 
        try {
            //prepareStatement serve para levar ou trazer informações para o banco de dados de forma segura 
            ps = con.prepareStatement("INSERT INTO vendedor( nome, salario)VALUES(?,?)");//Adicionar um vendedor ao banco de dados
            //[preparando bd].[tipo da variavel]([posição].[lê a variavel]
            ps.setString(1, vendedor.getNomeVend());
            ps.setDouble(2, vendedor.getSalario());
            ps.executeUpdate();//Executa e atualiza o banco de dados
            JOptionPane.showMessageDialog(null, "O vendedor(a) foi adicionado com sucesso!"); //Mensagem de sucesso 
        } catch (Exception e) {//Tratamento de erro
            JOptionPane.showMessageDialog(null, "Erro ao salvar as informações: " + e);//Mensagem e erro especificados
        } finally {//Finalizando tudo
            connection_controleComissao.closeConnection(con, ps);//fechar o banco de dados
        }
    }
//Selecionar tudo da tabela
    //metodo publico e retorna obrigatóriamente uma lista
    public List<model_vendedor> selecionarVendedores() {//import java.util.List;
        String sql = "select nome,salario from vendedor";
        List<model_vendedor> listaVendedor = new ArrayList<>();//Criando uma lista para receber os objetos (nome e salario)
        try {
            ps = con.prepareStatement(sql);//Conexao segura executando a query
            rs = ps.executeQuery();//ele só executa já que retorna um resultset
            while (rs.next()) {//enquanto tiver resultado ....continue             
                model_vendedor vendedor = new model_vendedor();
                vendedor.setNomeVend(rs.getString("nome"));//vendedor escreve em nome do tipo String
                vendedor.setSalario(rs.getDouble("salario"));//vendedor escreve em salario do tipo Double
                
                listaVendedor.add(vendedor); // Adiciona na lista de vendedores, todos os dados possiveis
            }
        } catch (Exception e) {
            System.out.println("ERRO ao mostrar dados: "+e);//Mostra o erro na saida
            
        }finally{
            connection_controleComissao.closeConnection(con, ps, rs);//Fechando conexoes utilizadas 
        }
        return listaVendedor;//Retora a lista com os dados
    }
}
//Deus seja louvado
