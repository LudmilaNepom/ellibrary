package ua.mk.nepomnyachshaya.datalayer.book;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Book;
import ua.mk.nepomnyachshaya.model.Review;

import java.util.List;

/**
 *
 */

@Repository

public class BookManager extends AbstractDAO<Book> implements BookDAO{
    public BookManager(){
        super(Book.class);
    }
    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksByName(String nameOfBook) {
        List<Book> books=em.createNativeQuery("SELECT * " +
                "FROM Book " +
                "WHERE Book.name=?", Book.class)
                .setParameter(1, nameOfBook)
                .getResultList();
        return books;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksByAuthorSurname (String surnameOfAuthor) {
        List<Book> books=em.createNativeQuery("SELECT DISTINCT b.* " +
                "FROM book b " +
                "join book_author ba on b.id=ba.Book_id " +
                "join author a on ba.authors_id=a.id " +
                "where a.lastName=?", Book.class)
                .setParameter(1, surnameOfAuthor)
                .getResultList();
        return books;

    }
    @Transactional(readOnly = true)
    @Override
    public Double getRating (Book book) {
        List<Review> reviews=em.createNativeQuery("SELECT DISTINCT r.* " +
                "FROM book b " +
                "join review r on b.id=r.idOf " +
                "where b.id=? and r.aClass=?", Review.class)
                .setParameter(1, book.getId())
                .setParameter(2, "Book")
                .getResultList();
        Double sum=0d;
        for (Review review: reviews){
            sum+=review.getRating();
        }
        Double rating = sum/reviews.size();
        Integer i = rating.intValue();
        if (rating-i>=0.5d) rating = i +0.5d;
        else rating = i.doubleValue();
        return rating;

    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksByCategoryName(String nameOfCategory) {
        List<Book> books=em.createNativeQuery("SELECT b.* \n" +
                "FROM book b \n" +
                "join category c on b.category_id=c.id \n" +
                "where c.nameOfCategory=? or \n" +
                "c.idOfSuperCategory=(select id from category where category.nameOfCategory=?)",Book.class)
                .setParameter(1, nameOfCategory.toLowerCase())
                .setParameter(2, nameOfCategory.toLowerCase())
                .getResultList();
        return books;
    }
}
