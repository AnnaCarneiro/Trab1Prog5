/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import models.Produto;

/**
 *
 * @author aninh
 */
@ManagedBean
public class Categoria {
    
    private int idcategoria;
    private String descricao;
    private List<Categoria> categorias;
    
    public int getIdcategoria() {
        return idcategoria;
    }
    
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<Categoria> getLista() {
        categorias = new Produto().consultar("");
        return categorias;
    }
    
    public Categoria getCategoria(String idCategoria) {
        categorias = new Produto().consultar(idCategoria);
        if (categorias.isEmpty()) {
            return null;
        }
        
        return categorias.get(0);
    }
    
}
