package ua.mk.nepomnyachshaya.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 */
@Entity
@Table(name = "Review")
@NamedQuery(name = "Review.getAll", query = "SELECT b from Review b")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Embedded
    private ReviewableForDB criticizedObject;
    @Transient
    private Reviewable criticizedOb;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateOfReview;
    @Column
    private String authorOfReview;
    @Column
    private String comments;
    @Column
    private Integer rating;

    public Review() {
    }

    public Review(Reviewable criticizedOb, Date dateOfReview, String authorOfReview, int rating) {
        this.criticizedOb=criticizedOb;
        this.criticizedObject =new ReviewableForDB(criticizedOb);
        this.dateOfReview = dateOfReview;
        this.authorOfReview = authorOfReview;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setCriticizedОb(Reviewable criticizedОb) {
        this.criticizedOb =criticizedОb;
        this.criticizedObject=new ReviewableForDB(criticizedОb);
    }

    public Reviewable getCriticizedОb() {
        return criticizedOb;
    }

    public ReviewableForDB getCriticizedObject() {
        return criticizedObject;
    }

    public void setCriticizedObject(ReviewableForDB criticizedObject) {
        this.criticizedObject = criticizedObject;
    }

    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public Date getDateOfReview() {
        return dateOfReview;
    }

    public void setAuthorOfReview(String authorOfReview) {
        this.authorOfReview = authorOfReview;
    }

    public String getAuthorOfReview() {
        return authorOfReview;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }

    public void setRating(int rating) {
        if (rating < 11 && rating > 0) {
            this.rating = rating;
        } else this.rating = null;
    }

    public Integer getRatings() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;

        Review review = (Review) o;

        if (getId() != review.getId()) return false;
        if (criticizedOb != null ? !criticizedOb.equals(review.criticizedOb) : review.criticizedOb != null)
            return false;
        if (getDateOfReview() != null ? !getDateOfReview().equals(review.getDateOfReview()) : review.getDateOfReview() != null)
            return false;
        if (getAuthorOfReview() != null ? !getAuthorOfReview().equals(review.getAuthorOfReview()) : review.getAuthorOfReview() != null)
            return false;
        if (getComments() != null ? !getComments().equals(review.getComments()) : review.getComments() != null)
            return false;
        return getRating() != null ? getRating().equals(review.getRating()) : review.getRating() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (criticizedOb != null ? criticizedOb.hashCode() : 0);
        result = 31 * result + (getDateOfReview() != null ? getDateOfReview().hashCode() : 0);
        result = 31 * result + (getAuthorOfReview() != null ? getAuthorOfReview().hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "criticizedОbject=" + criticizedObject.getaClass() +
                ", dateOfReview=" + dateOfReview +
                ", authorOfReview='" + authorOfReview + '\'' +
                ", comments='" + comments + '\'' +
                ", rating=" + rating +
                '}';
    }
}

