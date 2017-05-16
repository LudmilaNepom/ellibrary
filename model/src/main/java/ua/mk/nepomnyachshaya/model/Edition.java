package ua.mk.nepomnyachshaya.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@MappedSuperclass


public abstract class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", length = 128)
    private String name;
    @Column(name = "description", length = 128)
    private String description;
    @Column(name = "year")
    private Integer year;
    @Column(name = "isbnOrIssn", length = 128)
    private String isbnOrIssn;
    @OneToOne
    private Category category;
    @ManyToMany
    private List<Work> works = new ArrayList <>();

    public Edition() {
    }

    public Edition(String name, int year, String isbnOrIssn) {
        this.name = name;
        this.year = year;
        String reg = "[^0-9,-]";
        this.isbnOrIssn = isbnOrIssn.replaceAll(reg, "");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbnOrIssn() {
        return isbnOrIssn;
    }

    public void setIsbnOrIssn(String isbnOrIssn) {
        this.isbnOrIssn = isbnOrIssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public List<Work> getWorks() {

        return works;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edition)) return false;

        Edition edition = (Edition) o;

        if (getId() != edition.getId()) return false;
        if (getYear() != edition.getYear()) return false;
        if (getName() != null ? !getName().equals(edition.getName()) : edition.getName() != null) return false;
        if (getIsbnOrIssn() != null ? !getIsbnOrIssn().equals(edition.getIsbnOrIssn()) : edition.getIsbnOrIssn() != null)
            return false;
        return getWorks() != null ? getWorks().equals(edition.getWorks()) : edition.getWorks() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getYear();
        result = 31 * result + (getIsbnOrIssn() != null ? getIsbnOrIssn().hashCode() : 0);
        result = 31 * result + (getWorks() != null ? getWorks().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year;
    }
}
