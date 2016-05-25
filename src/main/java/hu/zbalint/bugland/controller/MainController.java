package hu.zbalint.bugland.controller;

import hu.zbalint.bugland.dao.UserDAO;
import hu.zbalint.bugland.exception.NotLoggedInException;
import hu.zbalint.bugland.model.UserGroup;
import hu.zbalint.bugland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        if (this.userService.isLoggedIn()) {
            try {
                model.addAttribute("user", this.userService.getCurrentUser());
                model.addAttribute("isAdmin", this.userService.hasRights(new UserGroup("Admin")));
            } catch (NotLoggedInException ex) {
                log.error("User is not logged in");
            }
            return "home";
        }
        return "index";
    }

    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/post")
    public String post() {
        return "post";
    }
}
