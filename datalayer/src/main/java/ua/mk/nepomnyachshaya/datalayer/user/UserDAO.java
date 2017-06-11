package ua.mk.nepomnyachshaya.datalayer.user;

import ua.mk.nepomnyachshaya.model.MyUser;
import java.util.List;

public interface UserDAO {
    MyUser add (MyUser myUser);
    void delete(int Id);
    MyUser update(MyUser myUser);
    MyUser get(int Id);
    List<MyUser> getAll();
    MyUser findByUserName (String name);
    boolean isUserNameUnique(String name);
}
