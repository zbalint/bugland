package hu.zbalint.bugland.dao;

import hu.zbalint.bugland.model.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleDAO extends CrudRepository<Article, Long> {
    List<Article> findById(Long id);

//    List<Article> findByTitle(String title);

    List<Article> findById(String query, Pageable pageable);
}
