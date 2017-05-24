package ua.mk.nepomnyachshaya.app;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.mk.nepomnyachshaya.datalayer.user.UserDAO;
import ua.mk.nepomnyachshaya.model.MyUser;

import java.util.ArrayList;
import java.util.List;


public class MyUserDetailsService implements UserDetailsService {
    private final UserDAO userDAO;
    public MyUserDetailsService(UserDAO userDAO) {
        this.userDAO=userDAO;
    }
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        MyUser myUser = userDAO.findByUserName(username);
        if (myUser != null) {
            List<GrantedAuthority> authorities =
                    new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(myUser.getUserRole()));
            return new User(
                    myUser.getName(),
                    myUser.getPassword(),
                    authorities);
        }


        throw new UsernameNotFoundException(
                "User '" + username + "' not found.");
    }
}