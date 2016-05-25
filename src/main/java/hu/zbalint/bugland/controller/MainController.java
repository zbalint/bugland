package hu.zbalint.bugland.controller;

import hu.zbalint.bugland.dao.UserDAO;
import hu.zbalint.bugland.exception.NotLoggedInException;
import hu.zbalint.bugland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        if (userService.isLoggedIn()) {
            try {
                model.addAttribute("user", userService.getCurrentUser());
            } catch (NotLoggedInException ex) {
                ex.printStackTrace();
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
