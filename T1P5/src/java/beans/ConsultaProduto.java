/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author aninh
 */

@ManagedBean
public class ConsultaProduto {

    
    private int indproduto;
    private String descricao;
    private double preco;
    private double estoque;    
    private List<ConsultaProduto> produtos;

    public int getIndproduto() {
        return indproduto;
    }

    public void setIndproduto(int indproduto) {
        this.indproduto = indproduto;
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

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public List<ConsultaProduto> getProdutos() {
        return produtos;
    }
    public List<ConsultaProduto> getlistaProdutos() {
        produtos = new ConsultaProduto().getlistaProdutos();
        return produtos;
    }

    public void setProdutos(List<ConsultaProduto> produtos) {
        this.produtos = produtos;
    }

    

    
}
