package hu.zbalint.bugland.dao;

import hu.zbalint.bugland.model.UserGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGroupDAO extends CrudRepository<UserGroup, Long> {
    List<UserGroup> findById(Long id);
}
