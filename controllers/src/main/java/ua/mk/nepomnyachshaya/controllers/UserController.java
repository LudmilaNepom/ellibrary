package ua.mk.nepomnyachshaya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.nepomnyachshaya.datalayer.user.UserDAO;
import ua.mk.nepomnyachshaya.model.MyUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
public class UserController {
//    @Autowired
//    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    UserDAO userDAO;

    @Autowired
    MessageSource messageSource;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello() {
        System.out.println("method is working");
        return new ModelAndView("index");
    }

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/user" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<MyUser> users = userDAO.getAll();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userlist";
    }

    /**
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        MyUser myUser = new MyUser();
        myUser.setId(0);
        model.addAttribute("myUser", myUser);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
    public String saveUser(@Valid MyUser myUser, BindingResult result,
                           ModelMap model) {
        System.out.println(myUser.toString());

        if (result.hasErrors()) {

            return "registration";
        }

        /*
         * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation
         * and applying it on field [sso] of Model class [User].
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         *
         */
        myUser.setId(null);
        if(!userDAO.isUserNameUnique(myUser.getName())){

            FieldError nameError =new FieldError("myUser","name",
                    messageSource.getMessage("non.unique.name", new String[]{myUser.getName()}, Locale.getDefault()));
            result.addError(nameError);
            return "registration";
        }

       userDAO.add(myUser);

        model.addAttribute("success", "User " + myUser.getName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";

    }


    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable String id, ModelMap model) {
        MyUser user = userDAO.get(new Integer(id));
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String updateUser(@Valid MyUser user, BindingResult result,
                             ModelMap model, @PathVariable String id) {

        if (result.hasErrors()) {
            return "registration";
        }

        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }*/


        userDAO.update(user);

        model.addAttribute("success", "User " + user.getName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }


    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        userDAO.delete(new Integer(id));
        return "redirect:/user";
    }

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
            return "login";
    }

    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal(){
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
//    private boolean isCurrentAuthenticationAnonymous() {
//        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return authenticationTrustResolver.isAnonymous(authentication);
//    }


}
