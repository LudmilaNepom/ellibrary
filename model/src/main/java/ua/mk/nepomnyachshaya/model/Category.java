package ua.mk.nepomnyachshaya.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "Category", uniqueConstraints =
@UniqueConstraint(columnNames = {"nameOfCategory", "idOfSuperCategory"}))
@NamedQuery(name = "Category.getAll", query = "SELECT c from Category c")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nameOfCategory;
    @Column
    private String descriptionOfCategory;
    @Column
    private long idOfSuperCategory;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category(String nameOfCategory, String descriptionOfCategory) {
        this.nameOfCategory = nameOfCategory;
        this.descriptionOfCategory = descriptionOfCategory;
    }

    public long getIdOfSuperCategory() {
        return idOfSuperCategory;
    }

    public void setIdOfSuperCategory(long idOfSuperCategory) {
        this.idOfSuperCategory = idOfSuperCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setDescriptionOfCategory(String descriptionOfCategory) {
        this.descriptionOfCategory = descriptionOfCategory;
    }

    public String getDescriptionOfCategory() {
        return descriptionOfCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (getId() != category.getId()) return false;
        if (getIdOfSuperCategory() != category.getIdOfSuperCategory()) return false;
        if (!getNameOfCategory().equals(category.getNameOfCategory())) return false;
        return getDescriptionOfCategory() != null ? getDescriptionOfCategory().equals(category.getDescriptionOfCategory()) : category.getDescriptionOfCategory() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getNameOfCategory().hashCode();
        result = 31 * result + (getDescriptionOfCategory() != null ? getDescriptionOfCategory().hashCode() : 0);
        result = 31 * result + (int) (getIdOfSuperCategory() ^ (getIdOfSuperCategory() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "nameOfCategory='" + nameOfCategory + '\'' +
                ", descriptionOfCategory='" + descriptionOfCategory + '\'' +
                ", idOfSuperCategory=" + idOfSuperCategory +
                '}';
    }
}
