package hu.zbalint.bugland.service;

import hu.zbalint.bugland.dao.UserDAO;
import hu.zbalint.bugland.exception.AuthenticationException;
import hu.zbalint.bugland.exception.NotLoggedInException;
import hu.zbalint.bugland.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    HttpSession session;

    public User authenticate(String email, String password) throws AuthenticationException {
        log.info(session.getId());

        List<User> userList = userDAO.findByEmail(email);
        User user = null;
        if (userList.size() == 1) {
            user = userList.get(0);
            if (!user.getPassword().equals(password)) {
                throw new AuthenticationException("Invalid password");
            }
        } else {
            throw new AuthenticationException("Invalid email");
        }

        if (session.getAttribute("user") == null) {
            session.setAttribute("user", user);
        }

        return user;
    }

    public User getCurrentUser() throws NotLoggedInException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new NotLoggedInException();
        }

        return user;
    }

    public boolean hasRights() {
        return false;
    }
}
