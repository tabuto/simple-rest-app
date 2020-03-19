package it.test.shoppingList.rest;

import it.test.shoppingList.ejb.ShoppingList;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/shoppingList")
public class ShoppingListService {

    @EJB
    private ShoppingList shoppingList;

    @GET
    @Path("/version")
    public Response version(@Context HttpServletRequest req){
        return Response.ok(shoppingList.version()).build();
    }
}
