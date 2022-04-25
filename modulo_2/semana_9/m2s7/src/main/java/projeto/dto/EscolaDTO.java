package projeto.dto;

import projeto.entity.Escola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EscolaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private EnderecoDTO endereco;

    private Date dataDeCriacao;

    private List<TurmaDTO> turmas = new ArrayList<>();

    public EscolaDTO() {
    }

    public EscolaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EscolaDTO(Escola escola) {
        this.id = escola.getId();
        this.nome = escola.getNome();
        this.endereco = new EnderecoDTO(escola.getEndereco());
        this.dataDeCriacao = escola.getDataDeCriacao();
        this.turmas = escola.getTurmas()
                .stream()
                .map(TurmaDTO::new)
                .sorted(Comparator.comparing(TurmaDTO::getIdTurma))
                .collect(Collectors.toList());
    }

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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public List<TurmaDTO> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<TurmaDTO> turmas) {
        this.turmas = turmas;
    }
}
