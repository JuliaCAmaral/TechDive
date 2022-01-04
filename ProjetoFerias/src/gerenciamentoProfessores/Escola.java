package gerenciamentoProfessores;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Escola {

    private ArrayList<Docente> docentes = new ArrayList<Docente>();

    private ArrayList<Turma> turmas = new ArrayList<Turma>();

    public void ensalarTurma(int idDocente, int idTurma) {
        Turma turma = getTurma(idTurma);

        Docente docente = getDocente(idDocente);

        for (Docente verificaDocente : turma.getDocentes()) {
            if (verificaDocente == docente) {
                throw new RuntimeException("O docente já está cadastrado na turma.");

            }
        }

        docente.addTurmasAtendidas(turma);

        turma.addDocentes(docente);
    }

    public int addDocente(String nome) {

        Docente docente = new Docente(nome);

        int idDocente = docentes.size() + 1;

        docente.setIdentificacao(idDocente);
        docentes.add(docente);
        return idDocente;
    }

    public int addTurma(String nome, int quantidadeAlunos, LocalDate dataInicio) {

        Turma turma = new Turma(nome, quantidadeAlunos, dataInicio);

        int idTurma = turmas.size() + 1;

        turma.setIdentificacao(idTurma);
        turmas.add(turma);

        return idTurma;
    }

    public Docente getDocente(int idDocente) {
        for (Docente docente: docentes) {
            if (idDocente == docente.getIdentificacao())
                return docente;
        }
        throw new InvalidParameterException("Docente não encontrado.");
    }

    public Turma getTurma(int idTurma) {
        for (Turma turma: turmas) {
            if (idTurma == turma.getIdentificacao())
                return turma;
        }
        throw new InvalidParameterException("Turma não encontrada.");
    }

    public Docente[] getDocentes() {
        return docentes.toArray(new Docente[0]);
    }

    public Turma[] getTurmas() {
        return turmas.toArray(new Turma[0]);
    }


}
