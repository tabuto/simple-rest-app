package it.test.shoppingList.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IM_SHOPPING_LIST_ESS_PRODUCT_B", schema = "LDS001", catalog = "LDS001")
public class ImShoppingListEssProductBEntity {
    private long id;
    private String company;
    private String codArt;
    private String description;
    private String stsActive;
    private Integer grm;
    private Integer subgrm;
    private String grmDesc;
    private String subgrmDesc;

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
    @Column(name = "COD_ART")
    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "STS_ACTIVE")
    public String getStsActive() {
        return stsActive;
    }

    public void setStsActive(String stsActive) {
        this.stsActive = stsActive;
    }

    @Basic
    @Column(name = "GRM")
    public Integer getGrm() {
        return grm;
    }

    public void setGrm(Integer grm) {
        this.grm = grm;
    }

    @Basic
    @Column(name = "SUBGRM")
    public Integer getSubgrm() {
        return subgrm;
    }

    public void setSubgrm(Integer subgrm) {
        this.subgrm = subgrm;
    }

    @Basic
    @Column(name = "GRM_DESC")
    public String getGrmDesc() {
        return grmDesc;
    }

    public void setGrmDesc(String grmDesc) {
        this.grmDesc = grmDesc;
    }

    @Basic
    @Column(name = "SUBGRM_DESC")
    public String getSubgrmDesc() {
        return subgrmDesc;
    }

    public void setSubgrmDesc(String subgrmDesc) {
        this.subgrmDesc = subgrmDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImShoppingListEssProductBEntity that = (ImShoppingListEssProductBEntity) o;
        return id == that.id &&
                Objects.equals(company, that.company) &&
                Objects.equals(codArt, that.codArt) &&
                Objects.equals(description, that.description) &&
                Objects.equals(stsActive, that.stsActive) &&
                Objects.equals(grm, that.grm) &&
                Objects.equals(subgrm, that.subgrm) &&
                Objects.equals(grmDesc, that.grmDesc) &&
                Objects.equals(subgrmDesc, that.subgrmDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, codArt, description, stsActive, grm, subgrm, grmDesc, subgrmDesc);
    }
}
