/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import models.Produto;

/**
 *
 * @author aninh
 */
@ManagedBean
public class BeanCadastro {

    private int idproduto;
    private String descricao;
    private double preco;
    private String observacao;
    private Double estoque;
    private int idcategoria;

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idcontato) {
        this.idproduto = idcontato;
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

    public Double getQtdEstoque() {
        return estoque;
    }

    public void setQtdEstoque(Double qtdEstoque) {
        this.estoque = qtdEstoque;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (descricao.equals("")) {
            msg = new FacesMessage("Informe Descrição");
            view.addMessage(null, msg);
        }

        if (estoque.equals("")) {
            msg = new FacesMessage("Informe Quantidade em Estoque");
            view.addMessage(null, msg);
        }
        if (observacao.equals("")) {
            msg = new FacesMessage("Informe Observação");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            Produto cad = new Produto(idproduto, descricao, preco, estoque, observacao, idcategoria);
            if (cad.salvar()) {
                msg = new FacesMessage("Contato salvo com sucesso");
                view.addMessage(null, msg);
            }
        }
    }
}
