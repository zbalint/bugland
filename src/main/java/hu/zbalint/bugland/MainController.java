package hu.zbalint.bugland;

import hu.zbalint.bugland.dao.UserDAO;
import hu.zbalint.bugland.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public String index() {
        for (User user : userDAO.findById(2L)) {
            System.out.println("************** " + user.getFirstName());
        }
        return "index";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
