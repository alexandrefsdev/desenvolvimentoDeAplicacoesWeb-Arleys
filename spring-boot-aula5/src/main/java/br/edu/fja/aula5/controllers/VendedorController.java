package br.edu.fja.aula5.controllers;

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

    @RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public Vendedor cadastrar(@RequestBody Vendedor vendedor) {
        return servico.inserir(vendedor);
    }

}
