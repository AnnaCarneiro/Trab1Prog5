/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import models.Cadastro;

/**
 *
 * @author aninh
 */
@ManagedBean
public class BeanCadastro {

    private int idcadastro;
    private String descricao;   
    private String preco;
    private String observacao;
    private String qtdEstoque;
    private Categoria categoria;

    public int getIdcadastro() {
        return idcadastro;
    }

    public void setIdcadastro(int idcontato) {
        this.idcadastro = idcontato;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(String qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

   
    public void salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (descricao.equals("")) {
            msg = new FacesMessage("Informe Descrição");
            view.addMessage(null, msg);
        }        
                        
        if (preco.equals("")) {
            msg = new FacesMessage("Informe Preço");
            view.addMessage(null, msg);
        }

        if (qtdEstoque.equals("")) {
            msg = new FacesMessage("Informe Quantidade em Estoque");
            view.addMessage(null, msg);
        }
        if (observacao.equals("")) {
            msg = new FacesMessage("Informe Observação");
            view.addMessage(null, msg);
        }
        

        if (msg == null) {
            Cadastro cad = new Cadastro(idcadastro, descricao, preco, qtdEstoque, observacao);
            if (cad.salvar()) {
                msg = new FacesMessage("Contato salvo com sucesso");
                view.addMessage(null, msg);
            }
        }
    }
}
