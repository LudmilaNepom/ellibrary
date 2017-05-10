package ua.mk.nepomnyachshaya.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "Publisher", uniqueConstraints =
@UniqueConstraint(columnNames = {"publisherName", "country"}))
@NamedQuery(name = "Publisher.getAll", query = "SELECT p from Publisher p")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String publisherName;
    private String country;


    public Publisher() {
    }

    public Publisher(String publisherName, String country) {
        this.publisherName = publisherName;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;

        Publisher publisher = (Publisher) o;

        if (getId() != publisher.getId()) return false;
        if (getPublisherName() != null ? !getPublisherName().equals(publisher.getPublisherName()) : publisher.getPublisherName() != null)
            return false;
        return getCountry() != null ? getCountry().equals(publisher.getCountry()) : publisher.getCountry() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getPublisherName() != null ? getPublisherName().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new String(id+publisherName + ", "+country);
    }
}

