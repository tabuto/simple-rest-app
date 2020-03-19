package it.test.shoppingList.ejb;

import javax.ejb.Local;

@Local
public interface ShoppingList {

    public String version();
}
