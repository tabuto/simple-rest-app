package it.test.shoppingList.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "IM_SHOPPING_LIST", schema = "LDS001", catalog = "LDS001")
public class ImShoppingListEntity {
    private long id;
    private String company;
    private String owner;
    private String title;
    private String shared;
    private String createdBy;
    private Timestamp createdOn;
    private String lastUpdatedBy;
    private Timestamp lastUpdatedOn;
    private List<ImShoppingListProductEntity> productEntityList;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "OWNER")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
    @Column(name = "SHARED")
    public String getShared() {
        return shared;
    }

    public void setShared(String shared) {
        this.shared = shared;
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
    @Column(name = "LAST_UPDATED_BY")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Basic
    @Column(name = "LAST_UPDATED_ON")
    public Timestamp getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    @OneToMany(mappedBy = "list", fetch = FetchType.LAZY)
    public List<ImShoppingListProductEntity> getProductEntityList() {return productEntityList;}

    public void setProductEntityList(List<ImShoppingListProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImShoppingListEntity that = (ImShoppingListEntity) o;
        return id == that.id &&
                Objects.equals(company, that.company) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(title, that.title) &&
                Objects.equals(shared, that.shared) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(lastUpdatedBy, that.lastUpdatedBy) &&
                Objects.equals(lastUpdatedOn, that.lastUpdatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, owner, title, shared, createdBy, createdOn, lastUpdatedBy, lastUpdatedOn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImShoppingListEntity{");
        sb.append("id=").append(id);
        sb.append(", company='").append(company).append('\'');
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", shared='").append(shared).append('\'');
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", createdOn=").append(createdOn);
        sb.append(", lastUpdatedBy='").append(lastUpdatedBy).append('\'');
        sb.append(", lastUpdatedOn=").append(lastUpdatedOn);
        sb.append('}');
        return sb.toString();
    }
}
