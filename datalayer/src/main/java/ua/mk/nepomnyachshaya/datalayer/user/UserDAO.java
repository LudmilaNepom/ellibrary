package ua.mk.nepomnyachshaya.datalayer.user;

import ua.mk.nepomnyachshaya.model.MyUser;
import java.util.List;

/**
 * Created by User on 23.05.2017.
 */
public interface UserDAO {
    MyUser add (MyUser myUser);
    void delete(int Id);
    MyUser update(MyUser myUser);
    MyUser get(int Id);
    List<MyUser> getAll();
    MyUser findByUserName (String name);
}
