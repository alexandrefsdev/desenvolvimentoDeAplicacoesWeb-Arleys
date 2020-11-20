package br.edu.fja.aula5.repositorio;

import br.edu.fja.aula5.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepositorio extends JpaRepository<Produto,Long> {
}
