
package com.mycompany.bloc_notas.controller;

import com.company.blocNotas.service.imp.NotaService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/notas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class notaController {
    
    @EJB
    private NotaService notaService;
    
    //Post
   /* @POST
    public Response createNotes(NotaDto nota) throws Exception{
        try {
            if (nota == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Nota es obligatoria").build();
            }
            NotaService.CreateNota(nota);
            return Response.status(Response.Status.CREATED).entity(nota).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    
    //Get note by id
    @GET
    @Path("/{notaId}")
    public Response getNotesById(@PathParam("notaId") Long notaId ){
        try {
            NotaDto nota = NotaService.FindByIdNota(notaId);
            return Response.ok(nota).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    //Get all notes
    @GET
    public Response getAllNotes(){
        try {
            List<NotaDto> notas = NotaService.findAllNota();
            if(notas.isEmpty()){
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            return Response.ok(notas).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    //Update
    @PUT
    @Path("/{notaId}")
    public Response updateNote(@PathParam("notaId") Long notaId, NotaEntity notaActualizada){
        try {
            NotaEntity notaUpdated = NotaService.updateNota(notaId, notaActualizada);
            return Response.ok(notaUpdated).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    //Delete
    @DELETE
    @Path("/{notaId}")
    public Response deleteNote(@PathParam("notaId") Long notaId){
        try {
            NotaService.deleteNota(notaId);
            return Response.noContent().build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }*/
}
