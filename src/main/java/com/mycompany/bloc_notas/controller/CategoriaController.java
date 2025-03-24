package com.mycompany.bloc_notas.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.company.blocNotas.service.itf.ICategoriaService;
import com.mycompany.blocNotas.entities.Categoria;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import java.util.List;

@Path("/categoria")
@RequestScoped
public class CategoriaController {

    @Inject
    private ICategoriaService categoriaService;

    //Post
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createCategory(JsonObject categoria) {
        try {
            if (!categoria.containsKey("nombre")) {
                String msg = "nombre campo obligatorio";
                return Response.status(Response.Status.BAD_REQUEST).entity(msg).build();
            }
            Categoria categoriaRsponse = categoriaService.createCategoria(categoria);
            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("codigo", categoriaRsponse.getCateId())
                    .add("nombre", categoriaRsponse.getCateNombre())
                    .build();
            return Response.status(Response.Status.CREATED).entity(jsonResponse).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/allCategories")
    public Response getAllCategories(JsonObject categoria){
        try {
            List<Categoria> categoriaResponse = categoriaService.gettAllCategoria(categoria);
            if (categoriaResponse.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("no existen categorias").build();
            }
            JsonArray jsonArray = categoriaResponse.stream()
                .map((Categoria categoria1) -> Json.createObjectBuilder()
                        .add("codigo", categoria1.getCateId())
                        .add("nombre", categoria1.getCateNombre())
                        .build())
                        .collect(Json::createArrayBuilder, JsonArrayBuilder::add, JsonArrayBuilder::add)
                        .build();

            // Crear el JsonObject final
            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("categorias", jsonArray)
                    .build();

        return Response.ok(jsonResponse).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    //Delete 
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response deleteCategory(JsonObject categoria){
        try {
            if(!categoria.containsKey("id")){
                String str = "Entidad con este id no ha sido encontrada";
                return Response.status(Response.Status.BAD_REQUEST).entity(str).build();
            }
            Categoria categoriaResponse = categoriaService.deleteCategoria(categoria);
            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("id", categoriaResponse.getCateId())
                    .build();
            return Response.ok().entity(jsonResponse).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    //Get by id
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getCategory")
    public Response getCategoryById(JsonObject categoria){
        try {
            if(!categoria.containsKey("id")){
                String str = "Entidad con este id no ha sido encontrada";
                return Response.status(Response.Status.BAD_REQUEST).entity(str).build();
            }
            Categoria categoriaRespose = categoriaService.getCategoriaById(categoria);
            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("id", categoriaRespose.getCateId())
                    .add("nombre", categoriaRespose.getCateNombre())
                    .build();
            return Response.ok().entity(jsonResponse).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateCategory(JsonObject categoria){
        try {
            if(!categoria.containsKey("id")){
                String str = "Entidad con este id no ha sido encontrada";
                Response.status(Response.Status.BAD_REQUEST).entity(str).build();
            }
            
            Categoria categoriaResponse = categoriaService.modifyCategoria(categoria);
            JsonObject jsonResponse = Json.createObjectBuilder()
                    .add("id", categoriaResponse.getCateId())
                    .add("nombre", categoriaResponse.getCateNombre()).build();
            
            return Response.ok().entity(jsonResponse).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
