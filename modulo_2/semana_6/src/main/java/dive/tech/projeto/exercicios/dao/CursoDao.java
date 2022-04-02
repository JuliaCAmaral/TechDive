package dive.tech.projeto.exercicios.dao;

import dive.tech.projeto.exercicios.entity.Curso;
import dive.tech.projeto.exercicios.entity.Disciplina;

import javax.enterprise.context.ApplicationScoped;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CursoDao {

    private List<Curso> cursos = criarCursos();

    public Curso criar(Curso curso) {
        if (curso.getId() == null) {
            curso.setId(cursos.size() + 1l);
        }
        cursos.add(curso);
        return curso;
    }

    public List<Curso> obterCursos() {
        return cursos;
    }

    private static List<Curso> criarCursos() {
        List<Curso> cursos = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            Curso curso = new Curso(i);

            for (int j = 1; j < 4; j++) {
                Disciplina disciplina = new Disciplina(curso.getNome(), j);
                curso.getDisciplinas().add(disciplina);
            }

            cursos.add(curso);
        }
        return cursos;
    }

    public Curso getById(Long id) {
        Curso curso = obterCursos()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findAny()
                .orElse(null);

        if (curso == null) {
            throw new InvalidParameterException("Curso de ID " + id +" não encontrado.");
        }
        return curso;
    }

    /**
     * Essa lista retornará três cursos: "Curso 1", "Curso 2" e "Curso 3".
     * Cada curso terá três disciplinas, e cada disciplina terá o nome "Disciplina X do Curso Y".
     * Os cursos estão no seguinte formado:
     * [
     *     {
     *         "id": 1,
     *         "nome": "Curso 1",
     *         "disciplinas": [
     *             {
     *                 "id": 1,
     *                 "nome": "Disciplina 1 do Curso 1"
     *             },
     *             {
     *                 "id": 2,
     *                 "nome": "Disciplina 2 do Curso 1"
     *             },
     *             {
     *                 "id": 3,
     *                 "nome": "Disciplina 3 do Curso 1"
     *             }
     *         ]
     *     },
     *     {
     *         "id": 2,
     *         "nome": "Curso 2",
     *         "disciplinas": [
     *             {
     *                 "id": 1,
     *                 "nome": "Disciplina 1 do Curso 2"
     *             },
     *             {
     *                 "id": 2,
     *                 "nome": "Disciplina 2 do Curso 2"
     *             },
     *             {
     *                 "id": 3,
     *                 "nome": "Disciplina 3 do Curso 2"
     *             }
     *         ]
     *     },
     *     {
     *         "id": 3,
     *         "nome": "Curso 3",
     *         "disciplinas": [
     *             {
     *                 "id": 1,
     *                 "nome": "Disciplina 1 do Curso 3"
     *             },
     *             {
     *                 "id": 2,
     *                 "nome": "Disciplina 2 do Curso 3"
     *             },
     *             {
     *                 "id": 3,
     *                 "nome": "Disciplina 3 do Curso 3"
     *             }
     *         ]
     *     }
     * ]
     */


}
