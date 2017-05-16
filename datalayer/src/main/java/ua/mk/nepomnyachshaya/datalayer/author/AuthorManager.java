package ua.mk.nepomnyachshaya.datalayer.author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Author;

import java.util.List;

/**
 *
 */

@Repository
public class AuthorManager extends AbstractDAO<Author> implements AuthorDAO {

    public AuthorManager(){
        super(Author.class);
    }

    @Transactional(readOnly = true)
    public List<Author> getAuthorsByBookId(int id){
        List<Author> authorsByBookId=em.createNativeQuery("SELECT a.* " +
                "FROM Author a " +
                "JOIN book_author ba on a.id=ba.authors_id " +
                "WHERE ba.Book_id=?",Author.class)
                .setParameter(1, id)
                .getResultList();
        return authorsByBookId;
    }
    @Transactional(readOnly = true)
    public List<Author> getAuthorsByFirstLettersOfSurname(String str) {
        List<Author> authorsByFirstLettersOfSurname = em.createNativeQuery("SELECT a.* " +
                "FROM Author a " +
                "where a.lastName like ?", Author.class)
                .setParameter(1, str + "%")
                .getResultList();
        return authorsByFirstLettersOfSurname;

    }
}
