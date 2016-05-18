package hu.zbalint.bugland.dao;

import hu.zbalint.bugland.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleDAO extends CrudRepository<Article, Long> {
    List<Article> findById(long id);
}
