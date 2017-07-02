package ua.mk.nepomnyachshaya.datalayer.review;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Review;

import java.util.List;

/**
 *
 */
@Repository
public class ReviewManager extends AbstractDAO<Review> implements ReviewDAO {

    public ReviewManager(){
        super(Review.class);
    }
    @Transactional
    @Override
    public Review add (Review review){
        List<Review> rev=em.createNativeQuery("SELECT * " +
                "FROM Review " +
                "WHERE Review.aClass=? and Review.idOf=? and Review.ip=?", Review.class)
                .setParameter(1, review.getCriticizedObject().getaClass())
                .setParameter(2, review.getCriticizedObject().getIdOf())
                .setParameter(3, review.getIp())
                .getResultList();
        if (rev.size()==0) return super.add(review);
        else return review;
    }
}
