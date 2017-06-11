package ua.mk.nepomnyachshaya.controllers.book;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class BookFromView implements Serializable{
    @JsonView
    private String id;
    @JsonView
    @Size(max=128, min = 1)
    @Pattern(regexp = "^[0-9a-zA-Zа-яёА-ЯЁ\\s\\-.,!?\"]+$")
    private String name;
    @JsonView
    @Size(max=128, min = 1)
    @Pattern(regexp = "^[0-9a-zA-Zа-яёА-ЯЁ\\s\\-.,:!?\"]+$")
    private String description;
    @JsonView
    @Max(2017)
    @Min(1900)
    @Pattern(regexp = "^[0-9]+$")
    private String year;
    @JsonView
    @Size(max=34, min =10)
    @Pattern(regexp = "^[0-9A-Z\\s\\-:]+$")
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
        return "Book:" +
                "id - " + id +
                ", name - " + name +
                ", description - " + description +
                ", isbnOrIssn - " + isbnOrIssn +
                ", year - " + year +
                ", publisher - " + publisherId + ".";
    }
}
