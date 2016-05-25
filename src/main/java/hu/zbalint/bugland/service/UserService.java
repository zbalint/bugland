package hu.zbalint.bugland.service;

import hu.zbalint.bugland.dao.UserDAO;
import hu.zbalint.bugland.exception.AuthenticationException;
import hu.zbalint.bugland.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    UserDAO userDAO;

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

        return user;
    }


}
