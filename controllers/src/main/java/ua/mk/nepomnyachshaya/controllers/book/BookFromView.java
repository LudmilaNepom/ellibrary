package ua.mk.nepomnyachshaya.controllers.book;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * Created by User on 16.05.2017.
 */
public class BookFromView implements Serializable{
    @JsonView
    private String id;
    @JsonView
    private String name;
    @JsonView
    private String description;
    @JsonView
    private String year;
    @JsonView
    private String isbnOrIssn;
    @JsonView
    private String publisherId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbnOrIssn() {
        return isbnOrIssn;
    }

    public void setIsbnOrIssn(String isbn) {
        this.isbnOrIssn = isbn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public String toString() {
        return "BookFromView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isbnOrIssn='" + isbnOrIssn + '\'' +
                ", year='" + year + '\'' +
                ", publisher='" + publisherId + '\'' +
                '}';
    }
}
