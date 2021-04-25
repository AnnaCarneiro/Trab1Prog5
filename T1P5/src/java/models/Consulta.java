/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author aninh
 */
public class Consulta {
    private int iddescricao;
    private String descricao;
    private String categoria;
    private double preco;
    private int estoque;
    private String editar;
    private String excluir;  
    
    public Consulta(){
        
    }

    public Consulta(int iddescricao, String descricao, String categoria, double preco, int estoque, String editar, String excluir) {
        this.iddescricao = iddescricao;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
        this.editar = editar;
        this.excluir = excluir;
    }

    public int getIddescricao() {
        return iddescricao;
    }

    public void setIddescricao(int iddescricao) {
        this.iddescricao = iddescricao;
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
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
