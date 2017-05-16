package ua.mk.nepomnyachshaya.datalayer.review;

import ua.mk.nepomnyachshaya.model.Review;

import java.util.List;

/**
 *
 */
public interface ReviewDAO {
     Review add (Review review);
     void delete(int Id);
     Review update(Review review);
     Review get(int Id);
     List<Review> getAll();
}
