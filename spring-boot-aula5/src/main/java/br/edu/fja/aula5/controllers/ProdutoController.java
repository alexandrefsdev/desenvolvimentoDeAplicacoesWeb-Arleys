package br.edu.fja.aula5.controllers;

import br.edu.fja.aula5.models.Produto;
import br.edu.fja.aula5.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServico servico;

    @GetMapping("/buscaporid/{id}")
    public Produto buscaPorId(@PathVariable("id") long id) {
        return servico.buscaPorId(id);
    }

    @GetMapping("/buscatodos")
    public List<Produto> buscaTodos() {
        return servico.buscaTodos();
    }

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody Produto produto) {
        return servico.inserir(produto);
    }

    @PutMapping("/alterar")
    public Produto alterar(@RequestBody Produto produto) {
        return servico.alterar(produto);
    }

    @DeleteMapping("/apagar/{id}")
    public void apagar(@PathVariable("id") long id) {
        servico.apagar(id);
    }

    @DeleteMapping("/apagar")
    public void apagar(@RequestBody Produto produto) {
        servico.apagar(produto.getIdproduto());
    }
}
