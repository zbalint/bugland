package hu.zbalint.bugland.controller;


import hu.zbalint.bugland.exception.AuthenticationException;
import hu.zbalint.bugland.model.User;
import hu.zbalint.bugland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, Model model, String email, String password) {
        try {
            User user = this.userService.authenticate(email, password);
            if (session.getAttribute("user") == null) {
                session.setAttribute("user", user);
            }
            model.addAttribute(user);
            log.info("Auth success");
            return "redirect:/";
        } catch (AuthenticationException ex) {
            log.error("Auth failed: " + ex.getMessage());
            model.addAttribute("error", true);
        }

        return "login";
    }
}
