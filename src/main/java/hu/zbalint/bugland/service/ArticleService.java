package hu.zbalint.bugland.service;

import hu.zbalint.bugland.dao.ArticleDAO;
import hu.zbalint.bugland.dao.CategoryDAO;
import hu.zbalint.bugland.exception.ArticleNotFoundException;
import hu.zbalint.bugland.model.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private static Logger log = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    UserService userService;
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    CategoryDAO categoryDAO;

    public List<Article> getArticles() {
        return (List<Article>) articleDAO.findAll();
    }

    public Article getArticle(long id) throws ArticleNotFoundException {
        log.info("ID: " + id);
        List<Article> articles = this.articleDAO.findById(id);
        if (articles.size() == 0) {
            throw new ArticleNotFoundException("Article not found with id: " + id);
        }

        return articles.get(0);
    }
}
