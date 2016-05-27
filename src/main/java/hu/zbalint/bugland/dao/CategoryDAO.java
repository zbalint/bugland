package hu.zbalint.bugland.dao;

import hu.zbalint.bugland.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryDAO extends CrudRepository<Category, Long> {
    List<Category> findById(Long id);
}
