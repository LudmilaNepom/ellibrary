package ua.mk.nepomnyachshaya.datalayer.category;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.Category;

/**
 *
 */
@Repository
public class CategoryManager extends AbstractDAO<Category> implements CategoryDAO {

    public CategoryManager(){
        super(Category.class);
    }
}
