package ua.mk.nepomnyachshaya.datalayer.review;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Review;

/**
 *
 */
@Repository
public class ReviewManager extends AbstractDAO<Review> implements ReviewDAO {

    public ReviewManager(){
        super(Review.class);
    }
}
