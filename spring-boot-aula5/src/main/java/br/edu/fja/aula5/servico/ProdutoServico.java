package br.edu.fja.aula5.servico;

import br.edu.fja.aula5.models.Produto;
import br.edu.fja.aula5.models.Vendedor;
import br.edu.fja.aula5.repositorio.IProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    @Autowired
    IProdutoRepositorio repositorio;

    public Produto inserir(Produto produto) {
        return  repositorio.save(produto);
    }

    public List<Produto> buscaTodos() {
        return repositorio.findAll();
    }

    public  Produto buscaPorId(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Produto alterar(Produto produto) {
        return repositorio.save(produto);
    }

    public void apagar(long id) {
        repositorio.deleteById(id);
    }

}
