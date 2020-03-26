package it.test.shoppingList.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.test.shoppingList.ejb.ShoppingList;
import it.test.shoppingList.entities.ImShoppingListEntity;

import javax.ejb.EJB;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@Path("/shoppingList")
public class ShoppingListService {
    @QueryParam("id")
    private Long id;
    @EJB
    private ShoppingList shoppingList;

    @GET
    @Path("/version")
    public Response version(@Context HttpServletRequest req){
        return Response.ok(shoppingList.version()).build();
    }
    @GET
    @Path("/shoppinglist/get")
    public Response shoppingList(@Context HttpServletRequest req){

        return Response.ok(shoppingList.getShoppingList(id).toString()).build();
    }

    @GET
    @Path("/shoppinglist/getfull")
    public Response fullShoppingList(@Context HttpServletRequest req){

        return Response.ok(shoppingList.getFullShoppingList(id).toString()).build();
    }

    @POST
    @Path("/shoppinglist/insert")
    public Response newShoppingList(@Context HttpServletRequest req){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ImShoppingListEntity imShoppingListEntity =
                    objectMapper.readValue(req.getInputStream(), ImShoppingListEntity.class);
            return Response.ok(shoppingList.createShoppingList(imShoppingListEntity).toString()).build();
        }
        catch (Exception ex)
        {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/shoppinglist/update")
    public Response updShoppingList(@Context HttpServletRequest req){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ImShoppingListEntity imShoppingListEntity =
                    objectMapper.readValue(req.getInputStream(), ImShoppingListEntity.class);
            return Response.ok(shoppingList.updateShoppingList(imShoppingListEntity).toString()).build();
        }
        catch (Exception ex)
        {
            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("/shoppinglist/delete")
    public Response delShoppingList(@Context HttpServletRequest req){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ImShoppingListEntity imShoppingListEntity =
                    objectMapper.readValue(req.getInputStream(), ImShoppingListEntity.class);
            boolean resp = shoppingList.deleteShoppingList(imShoppingListEntity);
            if (resp)
                return Response.ok().build();
            else
                return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch (Exception ex)
        {
            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("/shoppinglist/deleteID")
    public Response delShoppingListId(@Context HttpServletRequest req){
        boolean resp = shoppingList.deleteShoppingListByID(id);
        if (resp)
            return Response.ok().build();
        else
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
}
