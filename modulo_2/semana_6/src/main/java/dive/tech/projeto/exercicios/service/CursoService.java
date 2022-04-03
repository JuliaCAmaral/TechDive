package dive.tech.projeto.exercicios.service;

import dive.tech.projeto.exercicios.dao.CursoDao;
import dive.tech.projeto.exercicios.entity.Curso;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CursoService {

    private CursoDao dao = new CursoDao();

    public List<Curso> obterCursos() {
        return dao.listar();
    }

    public Curso criarCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso está nulo.");
        }
        dao.criar(curso);
        return curso;
    }

    public Curso getById(Long id) {
        Curso curso = dao.getById(id);
        return curso;
    }

    public void editarCurso(Curso curso) {
        dao.update(curso);
    }

    public void deletarCurso(Long id) {
        dao.deletar(id);
    }

    public List<Curso> getByName(String nome) {
        return dao.getByNome(nome);
    }
}
