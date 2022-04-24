package projeto.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(
        name = Escola.GET_ESCOLASDTO,
        query = "SELECT new projeto.dto.EscolaDTO(e.id, e.nome) " +
                "FROM Escola e " +
                "ORDER BY e.id")
public class Escola {

    public static final String GET_ESCOLASDTO = "GET_ESCOLASDTO";

    @Id
    @GeneratedValue
    @Column(name = "id_escola")
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Endereco endereco;

    private Date dataDeCriacao;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Turma> turmas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
