package dive.tech.projeto.exercicios.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/sistema")
public class SistemaController {

    @GET
    @Path("/cabecalho")
    @Produces("text/plain")
    public String exibirHeaders(@Context HttpHeaders headers) {
        String resposta = "";

        for (String nomeHeader : headers.getRequestHeaders().keySet()) {
            String valor = headers.getRequestHeaders().getFirst(nomeHeader);
            resposta += nomeHeader + ": " + valor + "\n";
        }
        return resposta;
    }

    @GET
    @Path("/cookie")
    @Produces("text/plain")
    public String cookie(@HeaderParam("cookie") String cookies) {
        return "Cookies encontrados: " + cookies;
    }

    @POST
    @Path("/cookie")
    @Produces("text/plain")
    public Response cookies(@QueryParam("valorCookie") String valorCookie) {
        NewCookie cookie = new NewCookie("Meu cookie", valorCookie);
        return Response
                .ok("Criei o cookie \"meuCookie\" com o valor \"" + valorCookie + "\"!")
                .cookie(cookie)
                .build();
    }
}
