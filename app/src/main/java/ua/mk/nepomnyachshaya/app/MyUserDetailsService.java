package ua.mk.nepomnyachshaya.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.mk.nepomnyachshaya.datalayer.user.UserDAO;
import ua.mk.nepomnyachshaya.model.MyUser;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        MyUser myUser;
        myUser =  userDAO.findByUserName(username);
        if (myUser != null) {
            List<GrantedAuthority> authorities =
                    new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(myUser.getUserRole()));
            return new User(
                    myUser.getName(),
                    myUser.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    authorities);
        }

        throw new UsernameNotFoundException(
                "User '" + username + " not found.");
    }
}