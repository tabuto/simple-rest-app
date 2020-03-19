package it.test.shoppingList.ejb;
import javax.ejb.*;

@Stateless
public class ShoppingListEJB implements ShoppingList{


    @Override
    public String version() {
        return "1.0";
    }
}
