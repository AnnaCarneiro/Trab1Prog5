/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.ConsultaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.utils.Conexao;

/**
 *
 * @author aninh
 */
public class Consulta {

    private int idproduto;
    private String descricao;
    private String categoria;
    private double preco;
    private double estoque;
    private String editar;
    private String excluir;

    public Consulta() {

    }

    public Consulta(int idproduto, String descricao, String categoria, double preco, double estoque, String editar, String excluir) {
        this.idproduto = idproduto;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
        this.editar = editar;
        this.excluir = excluir;
    }

    public List<ConsultaProduto> consultarProduto(String filtro) {
        ResultSet rs = null;
        List<ConsultaProduto> listaProdutos = new ArrayList<>();
        try {
            String sql = "select * from produto"
                    + " where descricao like '%" + filtro + "%'";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                ConsultaProduto prod = new ConsultaProduto();  
               prod.setIndproduto(rs.getInt("idproduto"));
               prod.setDescricao(rs.getString("descricao"));
               prod.setPreco(rs.getDouble("preco"));
               prod.setEstoque(rs.getDouble("estoque"));
               listaProdutos.add(prod);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return listaProdutos;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public String getEditar() {
        return editar;
    }

    public void setEditar(String editar) {
        this.editar = editar;
    }

    public String getExcluir() {
        return excluir;
    }

    public void setExcluir(String excluir) {
        this.excluir = excluir;
    }

}
