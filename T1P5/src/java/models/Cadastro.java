/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Categoria;
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
public class Cadastro {

    private int idcadastro;
    private String descricao;  
    private String preco;
    private String qtdEstoque;
    private String observacao;
    private String estoque;
    private String idcategoria;

    public Cadastro() {
    }

    public Cadastro(int idcadastro, String descricao, String preco, String qtdEstoque, String observacao) {
        this.idcadastro = idcadastro;
        this.descricao = descricao;        
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.observacao = observacao;
    }

    
    public List<Categoria > consultar(String filtro) {
        ResultSet rs = null;
        List<Categoria> lista = new ArrayList<>();
        try {
            String sql = "select * from categoria"
                    + " where descricao like '%" + filtro + "%'";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setIdcategoria(rs.getInt("idcategoria"));
                cat.setDescricao(rs.getString("descricao"));
                lista.add(cat);                
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }

    public boolean salvar() {
        try {
            String sql = "insert into produto(descricao, observacao, preco, estoque, idcategoria)"
                    + "values(?,?,?,?,?)";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.descricao);
            stm.setString(2, this.observacao);
            stm.setString(3, this.preco);
            stm.setString(4, this.estoque);
            stm.setString(5, this.idcategoria);            
            stm.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    public int getIdcadastro() {
        return idcadastro;
    }

    public void setIdcadastro(int idcadastro) {
        this.idcadastro = idcadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(String qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
