package dive.tech.projeto.exercicios.service;

import dive.tech.projeto.exercicios.dao.CursoDao;
import dive.tech.projeto.exercicios.entity.Curso;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CursoService {

    private CursoDao dao = new CursoDao();

    public List<Curso> obterCursos() {
        return dao.obterCursos();
    }

    public Curso criarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso está nulo.");
        }
        dao.criar(curso);
        return curso;
    }



    // Crie os métodos aqui!
}
