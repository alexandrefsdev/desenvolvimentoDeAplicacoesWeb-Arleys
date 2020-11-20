package br.edu.fja.aula5.repositorio;

import br.edu.fja.aula5.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CLASSE QUE FAZ A CONEXÃO COM O BANCO
@Repository
public interface IVendedorRepositorio extends JpaRepository<Vendedor, Long> {

}
