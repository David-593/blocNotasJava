
package com.mycompany.bloc_notas.controller;

//import com.company.blocNotas.dto.UsuarioDto;
import com.company.blocNotas.service.imp.UsuarioService;
import com.company.blocNotas.service.itf.ICategoriaService;
//import com.mycompany.blocNotas.entities.UsuarioEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
//import java.util.List;

@Path("/usuario")
@RequestScoped
public class UsuarioController {
    
    @Inject
    private ICategoriaService ICategoriaService;
    
    //Post
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createUser(JsonObject usuario){
        try {
            if(!usuario.containsKey("nombres") || !usuario.containsKey("apellidos")
                    || !usuario.containsKey("nacimiento") || !usuario.containsKey("email")
                    || !usuario.containsKey("clave") ){
                
            }
        } catch (Exception e) {
        }
        return null;
    }
    /*
    // Obtener usuario por ID
    @GET
    @Path("/{usuId}")
    public Response getUsersById(@PathParam("usuId") Long usuId) {
        try {
            UsuarioDto usuario = UsuarioService.getUserById(usuId);
            return Response.ok(usuario).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
    
    @GET
    public Response getAllUsers(){
        try {
            List<UsuarioEntity> usuarios = UsuarioService.getAllUser();
            if(usuarios.isEmpty()){
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            return Response.ok(usuarios).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    // Actualizar usuario
    @PUT
    @Path("/{usuId}")
    public Response updateUsers(@PathParam("usuId") Long id, UsuarioEntity usuario) {
        try {
            UsuarioEntity updatedUser = (UsuarioEntity) UsuarioService.updateUser(id, usuario);
            return Response.ok(updatedUser).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    // Eliminar usuario
    @DELETE
    @Path("/{usuId}")
    public Response deleteUsers(@PathParam("usuId") Long usuId) {
        try {
            UsuarioService.deleteUser(usuId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }*/
}
