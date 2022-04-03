package dive.tech.projeto.exercicios.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

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
}
