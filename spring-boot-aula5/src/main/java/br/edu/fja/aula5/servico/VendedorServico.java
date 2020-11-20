package br.edu.fja.aula5.servico;


import br.edu.fja.aula5.models.Vendedor;
import br.edu.fja.aula5.repositorio.IVendedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorServico {

    @Autowired
    IVendedorRepositorio repositorio;

    public Vendedor inserir(Vendedor vendedor) {
        return repositorio.save(vendedor);
    }

    public Vendedor alterar(Vendedor vendedor) {
        Vendedor vend = buscaPorId(vendedor.getIdvendedor());

        if (!vend.getNome().equalsIgnoreCase(vendedor.getNome()))
            vend.setNome(vendedor.getNome());

        if (vend.getComissao() != vendedor.getComissao())
            vend.setComissao(vendedor.getComissao());


        return repositorio.save(vend);
    }

    public List<Vendedor> buscaTodos() {
        return repositorio.findAll();
    }

    public Vendedor buscaPorId(long id) {
        return repositorio.findById(id).orElseThrow(null);
    }

    public void apagar(long id) {
        repositorio.deleteById(id);
    }
}
