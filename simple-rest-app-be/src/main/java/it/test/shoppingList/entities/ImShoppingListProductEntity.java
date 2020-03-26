package it.test.shoppingList.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "IM_SHOPPING_LIST_PRODUCT", schema = "LDS001", catalog = "LDS001")
public class ImShoppingListProductEntity {
    private long productId;
    private long listId;
    private String esselungaId;
    private String title;
    private String quantity;
    private BigInteger selected;
    private String image;
    private String createdBy;
    private Timestamp createdOn;
    private String lastChangeBy;
    private Timestamp lastChangeOn;

    @Id
    @Column(name = "PRODUCT_ID")
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }


    @Basic
    @Column(name = "LIST_ID")
    public long getListId() { return listId;}
    public void setListId(long listId){ this.listId = listId; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LIST_ID", updatable = false, insertable = false)
    public ImShoppingListEntity list;

    @Basic
    @Column(name = "ESSELUNGA_ID")
    public String getEsselungaId() {
        return esselungaId;
    }

    public void setEsselungaId(String esselungaId) {
        this.esselungaId = esselungaId;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "QUANTITY")
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "SELECTED")
    public BigInteger getSelected() {
        return selected;
    }

    public void setSelected(BigInteger selected) {
        this.selected = selected;
    }

    @Basic
    @Column(name = "IMAGE")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "CREATED_ON")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "LAST_CHANGE_BY")
    public String getLastChangeBy() {
        return lastChangeBy;
    }

    public void setLastChangeBy(String lastChangeBy) {
        this.lastChangeBy = lastChangeBy;
    }

    @Basic
    @Column(name = "LAST_CHANGE_ON")
    public Timestamp getLastChangeOn() {
        return lastChangeOn;
    }

    public void setLastChangeOn(Timestamp lastChangeOn) {
        this.lastChangeOn = lastChangeOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImShoppingListProductEntity that = (ImShoppingListProductEntity) o;
        return productId == that.productId &&
                listId == that.listId &&
                Objects.equals(esselungaId, that.esselungaId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(selected, that.selected) &&
                Objects.equals(image, that.image) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(lastChangeBy, that.lastChangeBy) &&
                Objects.equals(lastChangeOn, that.lastChangeOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId,listId, esselungaId, title, quantity, selected, image, createdBy, createdOn, lastChangeBy, lastChangeOn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImShoppingListProductEntity{");
        sb.append("productId=").append(productId);
        sb.append(", listId='").append(listId).append('\'');
        sb.append(", esselungaId='").append(esselungaId).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", quantity='").append(quantity).append('\'');
        sb.append(", selected=").append(selected);
        sb.append(", image='").append(image).append('\'');
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", createdOn=").append(createdOn);
        sb.append(", lastChangeBy='").append(lastChangeBy).append('\'');
        sb.append(", lastChangeOn=").append(lastChangeOn);
        sb.append('}');
        return sb.toString();
    }
}
