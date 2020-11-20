package br.edu.fja.aula5.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "vendedor")
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto - increment
    private long idvendedor;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "comissao", nullable = false)
    private double comissao;

    public Vendedor() {
    }

    public long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(long idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return idvendedor == vendedor.idvendedor &&
                Double.compare(vendedor.comissao, comissao) == 0 &&
                Objects.equals(nome, vendedor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvendedor, nome, comissao);
    }

}
