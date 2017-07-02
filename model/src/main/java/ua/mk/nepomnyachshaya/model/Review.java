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
    private Integer id;
    @Embedded
    private ReviewableForDB criticizedObject;
    @Transient
    private Reviewable criticizedOb;
    @Column
    private long dateOfReview;
    @Column
    private String ip;
    @Column
    private Double rating;

    public Review() {
    }

    public Review(Reviewable criticizedOb, long dateOfReview, String ip, Double rating) {
        this.criticizedOb = criticizedOb;
        this.criticizedObject = new ReviewableForDB(criticizedOb);
        this.dateOfReview = dateOfReview;
        this.ip = ip;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCriticizedОb(Reviewable criticizedОb) {
        this.criticizedOb = criticizedОb;
        this.criticizedObject = new ReviewableForDB(criticizedОb);
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

    public void setDateOfReview(long dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public long getDateOfReview() {
        return dateOfReview;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setRating(Double rating) {
        if (rating < 6 && rating > 0) {
            this.rating = rating;
        } else this.rating = 0d;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (getDateOfReview() != review.getDateOfReview()) return false;
        if (Double.compare(review.getRating(), getRating()) != 0) return false;
        if (!getId().equals(review.getId())) return false;
        if (!criticizedOb.equals(review.criticizedOb)) return false;
        return getIp().equals(review.getIp());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCriticizedObject() != null ? getCriticizedObject().hashCode() : 0);
        result = 31 * result + (criticizedOb != null ? criticizedOb.hashCode() : 0);
        result = 31 * result + (int) (getDateOfReview() ^ (getDateOfReview() >>> 32));
        result = 31 * result + (getIp() != null ? getIp().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review{" +
                "criticizedОbject=" + criticizedObject.getaClass() +
                ", dateOfReview=" + dateOfReview +
                ", rating=" + rating +
                '}';
    }
}

