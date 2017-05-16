package ua.mk.nepomnyachshaya.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "Series")
@NamedQuery(name = "Series.getAll", query = "SELECT s from Series s")

public class Series implements Reviewable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nameOfSeries;
    @OneToMany
    private List<Work> worksInSeries = new ArrayList();

    public Series() {
    }

    public Series(String nameOfSeries, List<Work> worksInSeries) {
        this.nameOfSeries = nameOfSeries;
        this.worksInSeries = worksInSeries;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNameOfSeries(String nameOfSeries) {
        this.nameOfSeries = nameOfSeries;
    }

    public String getNameOfSeries() {
        return nameOfSeries;
    }

    public void setWorksInSeries(List<Work> worksInSeries) {
        this.worksInSeries = worksInSeries;
        for (Work w:worksInSeries) {
            w.setSeriesBelong(true);
        }
    }

    public List<Work> getWorksInSeries() {
        return worksInSeries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Series)) return false;

        Series series = (Series) o;

        if (getId() != series.getId()) return false;
        if (getNameOfSeries() != null ? !getNameOfSeries().equals(series.getNameOfSeries()) : series.getNameOfSeries() != null)
            return false;
        return getWorksInSeries() != null ? getWorksInSeries().equals(series.getWorksInSeries()) : series.getWorksInSeries() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getNameOfSeries() != null ? getNameOfSeries().hashCode() : 0);
        result = 31 * result + (getWorksInSeries() != null ? getWorksInSeries().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Series: " +
                "nameOfSeries" + nameOfSeries +
                ", number worksInSeries=" + worksInSeries.size();
    }
}
