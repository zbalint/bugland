package hu.zbalint.bugland.controller;

import hu.zbalint.bugland.exception.AuthenticationException;
import hu.zbalint.bugland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String email, String password) {
        if (this.userService.isLoggedIn()) {
            return "redirect:/";
        }

        try {
            model.addAttribute(this.userService.authenticate(email, password));
            log.info("Auth success");
            return "redirect:/";
        } catch (AuthenticationException ex) {
            log.error("Auth failed: " + ex.getMessage());
            model.addAttribute("error", true);
        }

        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }
}
