package hu.zbalint.bugland.controller;

import hu.zbalint.bugland.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "home";
        }
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/post")
    public String post() {
        return "post";
    }
}
