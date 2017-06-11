package ua.mk.nepomnyachshaya.datalayer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.nepomnyachshaya.datalayer.AbstractDAO;
import ua.mk.nepomnyachshaya.model.MyUser;
import javax.persistence.TypedQuery;


@Repository
public class UserManager extends AbstractDAO<MyUser> implements UserDAO {
    @Autowired
   protected PasswordEncoder passwordEncoder;
    public UserManager() {
        super(MyUser.class);
    }
    @Override
    public MyUser findByUserName(String name) {
        MyUser myUser;
            TypedQuery<MyUser> typedQuery=em.createNamedQuery("MyUser.getByName", MyUser.class);
            myUser = typedQuery.setParameter("name", name).getSingleResult();
            return myUser;
    }
    @Override
    public boolean isUserNameUnique(String name) {
        try{MyUser user = findByUserName(name);} catch(Exception e){
            return true;
        }
        return false;
    }
    @Override
    @Transactional
    public MyUser add(MyUser object){
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        MyUser objectFromDB = em.merge(object);
        return objectFromDB;
    }
    @Override
    @Transactional
    public MyUser update(MyUser object){
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        MyUser objectFromDB = em.merge(object);
        return objectFromDB;
    }
}
