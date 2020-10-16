package fja.edu.br.controladores;

import fja.edu.br.dominio.contratos.IProduto;
import fja.edu.br.dominio.entidades.Produto;
import fja.edu.br.infra.repositorio.ProdutoRepositorio;
import java.util.List;

public class ProdutoController {

    private Produto produto;
    private List<Produto> produtos = null;
    
    private IProduto produtoRepositorio = new ProdutoRepositorio();
    
    public ProdutoController() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        if(produtos == null) {
            produtos = produtoRepositorio.getListaTodos();
        }
        return produtos;
    }
}
