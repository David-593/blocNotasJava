
package com.mycompany.bloc_notas.controller;

import com.company.blocNotas.dto.categoriaDto;
import com.company.blocNotas.service.categoriaService;
import com.mycompany.blocNotas.entities.Categoria;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categorias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class categoriaController {
    
    @EJB
    private categoriaService categoriaService;
    //Post
    @POST
    public Response createCategories(Categoria categoria){
        try {
            categoriaService.createCategoria(categoria);
            return Response.status(Response.Status.CREATED).entity(categoria).build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    } 
    
    //Get by id
    @GET
    @Path("/{cateId}")
    public Response getCategoriesById(@PathParam("cateId") Long cateId){
        try{
            categoriaDto categoria = categoriaService.getCategoriaById(cateId);
            return Response.ok(categoria).build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    
    //Update by id
    @PUT
    @Path("/{cateId}")
    public Response updateCategorie(@PathParam("cateId") Long cateId, Categoria categoria){
        try{
            Categoria categoriaUpdated = categoriaService.updateCategoria(cateId, categoria);
            return Response.ok(categoriaUpdated).build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    //Delete 
    @DELETE
    @Path("/{cateId}")
    public Response deleteCategorie(@PathParam("cateId") Long cateId){
        try{
            categoriaService.deleteCategoria(cateId);
            return Response.noContent().build();
        }catch(Exception e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
