package br.edu.fja.aula5.controllers;

import br.edu.fja.aula5.models.Produto;
import br.edu.fja.aula5.models.Vendedor;
import br.edu.fja.aula5.servico.VendedorServico;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorServico servico;

    @GetMapping("/buscaporid/{id}")
    public Vendedor buscaPorId(@PathVariable("id") long id) {
        return servico.buscaPorId(id);
    }

    @GetMapping("/buscatodos")
    public List<Vendedor> buscaTodos() {
        return servico.buscaTodos();
    }

    @PostMapping("/cadastrar")
    public Vendedor cadastrar(@RequestBody Vendedor vendedor) {
        return servico.inserir(vendedor);
    }

    @PutMapping("/alterar")
    public Vendedor alterar(@RequestBody Vendedor vendedor) {
        return servico.alterar(vendedor);
    }

    @DeleteMapping("/apagar/{id}")
    public void apagar(@PathVariable("id") long id) {
        servico.apagar(id);
    }
    // SOBRECARREGANDO o médodo apagar
    @DeleteMapping("/apagar")
    public void apagar(@RequestBody Vendedor vendedor) {
        servico.apagar(vendedor.getIdvendedor());
    }
}
