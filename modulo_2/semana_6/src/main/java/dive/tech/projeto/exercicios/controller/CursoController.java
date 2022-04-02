package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Curso;
import dive.tech.projeto.exercicios.service.CursoService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/curso")
@ApplicationScoped
public class CursoController {

    CursoService service = new CursoService();

    @GET
    @Produces("application/json")
    public Response listarCursos() {
        List<Curso> cursos = service.obterCursos();

        return Response
                .ok(cursos)
                .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarCurso(Curso curso) {
        try {
            service.criarCurso(curso);
            return Response
                    .ok(curso)
                    .status(Response.Status.CREATED)
                    .build();
        } catch (Exception e) {
            return Response
                    .ok(e.getMessage())
                    .build();
        }
    }
}
