
package com.mycompany.bloc_notas.controller;

import com.company.blocNotas.dto.usuarioDto;
import com.company.blocNotas.service.usuarioService;
import com.mycompany.blocNotas.entities.Usuario;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class usuarioController {
    
    @EJB
    private usuarioService usuarioService;
    
    @POST
    public Response createUsers(Usuario usuario){
        try{
            usuarioService.createUser(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        } catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    
    // Obtener usuario por ID
    @GET
    @Path("/{id}")
    public Response getUsersById(@PathParam("id") Long id) {
        try {
            usuarioDto usuario = usuarioService.getUserById(id);
            return Response.ok(usuario).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    // Actualizar usuario
    @PUT
    @Path("/{id}")
    public Response updateUsers(@PathParam("id") Long id, Usuario usuario) {
        try {
            Usuario updatedUser = usuarioService.updateUser(id, usuario);
            return Response.ok(updatedUser).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    // Eliminar usuario
    @DELETE
    @Path("/{id}")
    public Response deleteUsers(@PathParam("id") Long id) {
        try {
            usuarioService.deleteUser(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
