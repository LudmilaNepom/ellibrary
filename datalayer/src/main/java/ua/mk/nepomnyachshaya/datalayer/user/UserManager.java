package ua.mk.nepomnyachshaya.datalayer.user;

import org.springframework.stereotype.Repository;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.MyUser;

import javax.persistence.NoResultException;


@Repository
public class UserManager extends AbstractDAO<MyUser> implements UserDAO {
    public UserManager() {
        super(MyUser.class);
    }

    public MyUser findByUserName(String name) {
        try {
            MyUser userBYName = (MyUser) em.createNativeQuery("SELECT u.* " +
                    "FROM MyUser u " +
                    "WHERE u.name=?", MyUser.class)
                    .setParameter(1, name)
                    .getSingleResult();
            return userBYName;
        } catch (NoResultException e) {
            return null;
        }

    }

    public boolean isUserNameUnique(Integer id, String name) {
        MyUser user = findByUserName(name);
        return (user == null || ((id != null) && (user.getId().equals(id))));
    }
}
