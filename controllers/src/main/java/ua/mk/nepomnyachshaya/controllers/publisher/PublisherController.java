package ua.mk.nepomnyachshaya.controllers.publisher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/publisher")
public class PublisherController {
        public class AuthorController {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView getCategories() {
            return new ModelAndView("author/index");
        }


    }

}
