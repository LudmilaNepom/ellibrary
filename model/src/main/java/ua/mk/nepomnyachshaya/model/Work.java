package ua.mk.nepomnyachshaya.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;


/**
 *
 */
@Entity
@Table(name = "Work")
@NamedQueries(
        {@NamedQuery(name = "Work.getAll", query = "SELECT w from Work w"),
                @NamedQuery(name = "Work.getByCategoryId", query = "SELECT w from Work w WHERE categoryOfWork_id= :id"),
                @NamedQuery(name = "Work.getByCategoryName", query =
                        "SELECT w from Work w JOIN w.categoryOfWork c  WHERE c.nameOfCategory = :name")}
)

public class Work implements Reviewable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nameOfWork;
    @ManyToMany
    private List<Author> authorsOfWork = new ArrayList<>();
    @OneToOne
    private Category categoryOfWork;
    @Column
    private String dateOfCreation;
    @Column
    private boolean seriesBelong;

    public Work() {
    }

    public Work(String nameOfWork, List<Author> authorsOfWork, String dateOfCreation) {
        this.nameOfWork = nameOfWork;
        this.authorsOfWork = authorsOfWork;
        this.dateOfCreation = dateOfCreation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNameOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setAuthorsOfWork(List<Author> authorsOfWork) {
        this.authorsOfWork = authorsOfWork;
    }

    public List<Author> getAuthorsOfWork() {
        return authorsOfWork;
    }

    public void setCategoryOfWork(Category categoryOfWork) {
        this.categoryOfWork = categoryOfWork;
    }

    public Category getCategoryOfWork() {
        return categoryOfWork;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public boolean isSeriesBelong() {
        return seriesBelong;
    }

    public void setSeriesBelong(boolean seriesBelong) {
        this.seriesBelong = seriesBelong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work)) return false;

        Work work = (Work) o;

        if (getId() != work.getId()) return false;
        if (getNameOfWork() != null ? !getNameOfWork().equals(work.getNameOfWork()) : work.getNameOfWork() != null)
            return false;
        return getAuthorsOfWork() != null ? getAuthorsOfWork().equals(work.getAuthorsOfWork()) : work.getAuthorsOfWork() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getNameOfWork() != null ? getNameOfWork().hashCode() : 0);
        result = 31 * result + (getAuthorsOfWork() != null ? getAuthorsOfWork().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Work{" +
                "nameOfWork='" + nameOfWork + '\'' +
                ", categoryOfWork=" + categoryOfWork.getNameOfCategory() +
                ", dateOfCreation='" + dateOfCreation + '\'' +
                ", seriesBelong=" + seriesBelong +
                '}';
    }
}
