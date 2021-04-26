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
public class Produto {

    private int idProduto;
    private String descricao;
    private double preco;
    private double estoque;
    private String observacao;
    private int idcategoria;

    public Produto() {
    }

    public Produto(int idcadastro, String descricao, double preco, double qtdEstoque, String observacao, int idcategoria) {
        this.idProduto = idcadastro;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = qtdEstoque;
        this.observacao = observacao;
        this.idcategoria = idcategoria;
    }

    public List<Categoria> consultar(String filtro) {
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

    private boolean jaExiste() {
        boolean existe = false;
        try {
            String sql = "select count(*) qt from produto where idproduto = ?";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.idProduto);
            ResultSet executeQuery = stm.executeQuery();
            if (executeQuery.next()) {
                existe = executeQuery.getInt("qt") > 0;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return existe;
    }

    public boolean salvar() {
        try {
            Connection con = Conexao.conectar();
            String sql = " insert into produto(descricao, observacao, preco, estoque, idcategoria)"
                    + "values(?,?,?,?,?)";

            if (jaExiste()) {
                sql = " update produto set "
                        + " descricao = ?,"
                        + " observacao = ?,"
                        + " preco = ?,"
                        + " estoque = ?,"
                        + " idcategoria = ?"
                        + " where idproduto = ?";

                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.descricao);
                stm.setString(2, this.observacao);
                stm.setDouble(3, this.preco);
                stm.setDouble(4, this.estoque);
                stm.setInt(5, idcategoria);
                stm.setInt(6, this.idProduto);
                stm.execute();
            } else {
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.descricao);
                stm.setString(2, this.observacao);
                stm.setDouble(3, this.preco);
                stm.setDouble(4, this.estoque);
                stm.setInt(5, idcategoria);
                stm.execute();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return true;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idcadastro) {
        this.idProduto = idcadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return new Categoria().getCategoria(idcategoria + "");
    }

}
