package ws;

import dao.Cidade;
import dao.CidadeDAO;
import dao.Jogo;
import dao.JogoDAO;
import io.dropwizard.jersey.params.IntParam;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cidades")
@Produces(MediaType.APPLICATION_JSON)
public class CidadeResource {
    private CidadeDAO dao;
    
    public CidadeResource(CidadeDAO dao){
        this.dao = dao;
    }
    @GET
    public List<Cidade> get() {
        return dao.lerTodos();
    }
    
    @POST
    public Cidade create(Cidade cidade) {
        return dao.criar(cidade);
    }
    
     @PUT
    @Path("{id}")
    public Response update(@PathParam("id") IntParam id, Cidade cidade) {
        cidade.setId(id.get());
        
        if (dao.atualizar(cidade)) {
            return Response.ok().build();
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    
   @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") IntParam id) {
        if (dao.apagar(id.get())) {
            return Response.ok().build();
        } else {
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}