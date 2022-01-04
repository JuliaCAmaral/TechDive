package gerenciamentoProfessores;

import java.time.LocalDate;

public class Aula {

    private LocalDate dia;

    private Docente docente;

    private Assunto assunto;

    public Aula(LocalDate dia, Docente docente, Assunto assunto) {
        this.dia = dia;
        this.docente = docente;
        this.assunto = assunto;
    }

    public LocalDate getDia() {
        return dia;
    }

    public Docente getDocente() {
        return docente;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public String getNomeDocente() {
        Docente docente = getDocente();
        return docente.getNome();
    }

    public String getDescricaoAssunto() {
        Assunto assunto = getAssunto();
        return assunto.getDescricao();
    }
}
