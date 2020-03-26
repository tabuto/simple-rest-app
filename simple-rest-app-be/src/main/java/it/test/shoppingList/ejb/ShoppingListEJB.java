package it.test.shoppingList.ejb;
import it.test.shoppingList.entities.*;

import javax.persistence.*;
import javax.ejb.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class ShoppingListEJB implements ShoppingList, Serializable {

    @PersistenceContext(name = "LDS001", unitName = "LDS001", type = PersistenceContextType.TRANSACTION)
    EntityManager entityManager;

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public ImShoppingListEntity createShoppingList(ImShoppingListEntity lista) {
        ImShoppingListEntity newImShoppingListEntity = new ImShoppingListEntity();
        newImShoppingListEntity.setCompany(lista.getCompany());
        newImShoppingListEntity.setOwner(lista.getOwner());
        newImShoppingListEntity.setTitle(lista.getTitle());
        newImShoppingListEntity.setCreatedBy(lista.getOwner());
        newImShoppingListEntity.setLastUpdatedBy(lista.getOwner());
        newImShoppingListEntity.setShared("0");
        entityManager.persist(newImShoppingListEntity);
        entityManager.flush();
        return  newImShoppingListEntity;
    }

    @Override
    public ImShoppingListEntity getShoppingList(long id)
    {
        ImShoppingListEntity result = null;
		try {
            Query query = entityManager.createQuery("SELECT s FROM ImShoppingListEntity s where s.id = :id");
            query.setParameter("id", id);
            result = (ImShoppingListEntity) query.getSingleResult();
            }
        catch (NoResultException e) {
        return result;
        }
		catch (Exception e) {
        return result;
        }
		return  result;
    }

    @Override
    public ImShoppingListEntity getFullShoppingList(long id) {
        ImShoppingListEntity result;
        try {
            Query query = entityManager.createQuery("SELECT s FROM ImShoppingListEntity s JOIN FETCH s.productEntityList WHERE s.id = :id");
            query.setParameter("id", id);
            result = (ImShoppingListEntity) query.getSingleResult();
            return  result;
        }
        catch (NoResultException e) {
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public ImShoppingListEntity updateShoppingList(ImShoppingListEntity lista) throws Exception {
        ImShoppingListEntity list = getShoppingList(lista.getId());
        if (list == null)
            throw new Exception("Lista ID " + lista.getId() + " non presente");
        else
        {
            list.setLastUpdatedOn((Timestamp) new Date());
            entityManager.merge(list);
        }
        return list;
    }

    @Override
    public boolean deleteShoppingList(ImShoppingListEntity lista) {
        ImShoppingListEntity list = getShoppingList(lista.getId());
        if (list == null)
        return false;
        else
        return deleteShoppingListByID(lista.getId());
    }

    @Override
    public boolean deleteShoppingListByID(long id) {
        ImShoppingListEntity list = getShoppingList(id);
        if (list == null)
            return false;
        else
        {
            entityManager.remove(list);
            return true;
        }

    }
    public ImShoppingListProductEntity createProduct (ImShoppingListProductEntity product)
    {
        ImShoppingListProductEntity prod = product;
        prod.setLastChangeOn((Timestamp)new Date());
        prod.setCreatedOn((Timestamp)new Date());
        entityManager.persist(prod);
        return prod;
    }

    @Override
    public ImShoppingListProductEntity getProduct(long id) {
        ImShoppingListProductEntity result;
        try {
            Query query = entityManager.createQuery("SELECT s FROM ImShoppingListProductEntity s  WHERE s.productId = :id");
            query.setParameter("id", id);
            result = (ImShoppingListProductEntity) query.getSingleResult();
            return  result;
        }
        catch (NoResultException e) {
            return null;
        }
        catch (Exception e) {
            return null;
        }

    }

    @Override
    public ImShoppingListProductEntity updateProduct(ImShoppingListProductEntity product) throws Exception {
        ImShoppingListProductEntity prod = getProduct(product.getProductId());
        if (prod == null)
            throw new Exception("Product ID " + product.getProductId() + " non presente");
        else
        {
            prod.setLastChangeOn((Timestamp) new Date());
            entityManager.merge(prod);
        }
        return prod;
    }

    @Override
    public boolean deleteProduct(ImShoppingListProductEntity product) {
        ImShoppingListProductEntity prod = getProduct(product.getProductId());
        if (prod == null)
            return false;
        else
            return deleteProductByID(prod.getProductId());
    }

    @Override
    public boolean deleteProductByID(long id) {
        ImShoppingListProductEntity prod = getProduct(id);
        if (prod == null)
            return false;
        else
        {
            entityManager.remove(prod);
            return true;
        }
    }
}
