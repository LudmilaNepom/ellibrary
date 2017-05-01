package ua.mk.nepomnyachshaya.datalayer.review;

import ua.mk.nepomnyachshaya.model.Review;

import java.util.List;

/**
 *
 */
public interface ReviewDAO {
    public Review add (Review review);
    public void delete(long Id);
    public Review update(Review review);
    public Review get(long Id);
    public List<Review> getAll();
}
