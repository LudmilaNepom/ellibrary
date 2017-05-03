package ua.mk.nepomnyachshaya.controllers.Category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getCategories() {
        return new ModelAndView("category/index");
    }


}
