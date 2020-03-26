package it.test.shoppingList.ejb;

import it.test.shoppingList.entities.*;

import javax.ejb.Local;

@Local
public interface ShoppingList {

    public String version();


    public ImShoppingListEntity getShoppingList(long id);
    public ImShoppingListEntity getFullShoppingList(long id);
    public ImShoppingListEntity createShoppingList(ImShoppingListEntity lista);
    public ImShoppingListEntity updateShoppingList(ImShoppingListEntity lista) throws Exception;
    public boolean deleteShoppingList(ImShoppingListEntity lista);
    public boolean deleteShoppingListByID(long id);

    public  ImShoppingListProductEntity createProduct(ImShoppingListProductEntity product);
    public  ImShoppingListProductEntity getProduct(long id);
    public  ImShoppingListProductEntity updateProduct(ImShoppingListProductEntity product) throws Exception;
    public  boolean deleteProduct(ImShoppingListProductEntity product);
    public  boolean deleteProductByID(long id);

}
