

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;


@Path("/RecursosServidor")
public class RecursosServidor {

    //apenas retorna o texo referido no enunciado
    @GET
    @Produces("text/plain")
    public String getM() {

        return "Um pedido REST foi envido para mim";
    }

    //apenas retorna o texto referido no enunciado
    @GET
    @Path("/{ip}")
    public String get(@PathParam("ip") String ip ) {

        return "Foi enviado para mim o recurso" + ip;
    }
}
