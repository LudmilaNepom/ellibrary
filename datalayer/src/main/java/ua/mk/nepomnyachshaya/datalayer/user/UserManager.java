package ua.mk.nepomnyachshaya.datalayer.user;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.MyUser;

/**
 * Created by User on 23.05.2017.
 */
@Repository
public class UserManager extends AbstractDAO<MyUser> implements UserDAO{
    public UserManager(Class<MyUser> type) {
        super(type);
    }
    public MyUser findByUserName(String name){
        MyUser userBYName=(MyUser) em.createNativeQuery("SELECT p.* " +
                "FROM User u " +
                "WHERE u.name=?", MyUser.class)
                .setParameter(1, name)
                .getSingleResult();
        return userBYName;
    }
}
