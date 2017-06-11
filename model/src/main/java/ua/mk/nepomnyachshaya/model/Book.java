package ua.mk.nepomnyachshaya.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Entity
    @Table(name = "Book")
    @NamedQueries({@NamedQuery(name = "Book.getAll", query = "SELECT b from Book b"),
    })

    public class Book extends Edition implements Reviewable, Serializable {

        @ManyToMany
        private List<Author> authors = new ArrayList<>();

        @NotNull
        @ManyToOne
        private Publisher publisher;
        private boolean series;


    public Book() {
    }

    public Book(String name, int year, String isbnOrIssn, List<Author> authors, Publisher publisher) {
        super(name, year, isbnOrIssn);
        this.authors = authors;
        this.publisher = publisher;
        this.setIsbnOrIssn("ISBN: " + this.getIsbnOrIssn());
    }


    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setSeries(boolean series) {
        this.series = series;
    }

    public boolean isSeries() {
        return series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        if (isSeries() != book.isSeries()) return false;
        if (getAuthors() != null ? !getAuthors().equals(book.getAuthors()) : book.getAuthors() != null) return false;
        return getPublisher().equals(book.getPublisher());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAuthors() != null ? getAuthors().hashCode() : 0);
        result = 31 * result + getPublisher().hashCode();
        result = 31 * result + (isSeries() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", authors " + Arrays.toString(authors.toArray()) +
                ", publisher " + publisher.getPublisherName() +
                ", series " + series;
    }
}
