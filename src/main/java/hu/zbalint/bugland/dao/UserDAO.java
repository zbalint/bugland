package hu.zbalint.bugland.dao;

import hu.zbalint.bugland.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDAO extends CrudRepository<User, Long> {
    List<User> findById(Long id);
}
