package projeto.dto;

import projeto.entity.Escola;

import java.io.Serializable;
import java.util.Date;

public class EscolaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private EnderecoDTO endereco;

    private Date dataDeCriacao;

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
}
