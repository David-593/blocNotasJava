/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloc_notas.controller;

import com.company.blocNotas.dto.NotaDto;
import com.company.blocNotas.service.notaService;
import com.mycompany.blocNotas.entities.Nota;
import jakarta.ejb.EJB;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author andre
 */
@Path("/notas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class notaController {
    
    @EJB
    private notaService notaService;
    
    //Post
    @POST
    public Response createNotes(Nota nota) throws Exception{
        try {
            if (nota == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Nota es obligatoria").build();
            }
            notaService.CreateNota(nota);
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
            NotaDto nota = notaService.FindByIdNota(notaId);
            return Response.ok(nota).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    //Get all notes
    @GET
    public Response getAllNotes(){
        try {
            List<NotaDto> notas = notaService.findAllNota();
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
    public Response updateNote(@PathParam("notaId") Long notaId, Nota notaActualizada){
        try {
            Nota notaUpdated = notaService.updateNota(notaId, notaActualizada);
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
            notaService.deleteNota(notaId);
            return Response.noContent().build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
