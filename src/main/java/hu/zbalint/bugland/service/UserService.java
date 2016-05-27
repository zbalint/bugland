package hu.zbalint.bugland.service;

import hu.zbalint.bugland.dao.UserDAO;
import hu.zbalint.bugland.exception.AuthenticationException;
import hu.zbalint.bugland.exception.NotLoggedInException;
import hu.zbalint.bugland.exception.UserNotFoundException;
import hu.zbalint.bugland.model.User;
import hu.zbalint.bugland.model.UserGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    HttpSession session;

    public User authenticate(String email, String password) throws AuthenticationException {
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

    public void logout() {
        session.invalidate();
    }

    public User getUserById(long id) throws UserNotFoundException {
        List<User> users = this.userDAO.findById(id);
        if (users.size() == 0) {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        return users.get(0);
    }

    public User getCurrentUser() throws NotLoggedInException {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new NotLoggedInException();
        }

        return user;
    }

    public boolean isLoggedIn() {
        return session.getAttribute("user") != null;
    }

    public boolean hasRights(UserGroup group) {
        try {
            User user = this.getCurrentUser();
            for (UserGroup userGroup : user.getGroups()) {
                if (userGroup.getName().equals(group.getName())) {
                    return true;
                }
            }
        } catch (NotLoggedInException e) {
            return false;
        }
        return false;
    }
}
