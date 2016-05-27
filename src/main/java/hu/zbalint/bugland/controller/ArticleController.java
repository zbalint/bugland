package hu.zbalint.bugland.controller;

import hu.zbalint.bugland.dao.ArticleDAO;
import hu.zbalint.bugland.exception.ArticleNotFoundException;
import hu.zbalint.bugland.exception.UserNotFoundException;
import hu.zbalint.bugland.model.Article;
import hu.zbalint.bugland.model.ArticleWithAuthor;
import hu.zbalint.bugland.model.User;
import hu.zbalint.bugland.service.ArticleService;
import hu.zbalint.bugland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    private static Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String article(Model model, @RequestParam long id) {
        try {
            this.articleService.getArticles(1, 1);
            Article article = this.articleService.getArticle(id);
            User user = this.userService.getUserById(article.getAuthorId());
            ArticleWithAuthor articleWithAuthor = new ArticleWithAuthor(user, article);
            model.addAttribute("article", articleWithAuthor);
        } catch (ArticleNotFoundException e) {
            log.error(e.getMessage());
            return "error";
        } catch (UserNotFoundException e) {
            log.error(e.getMessage());
            return "error";
        }
        return "post";
    }

    @RequestMapping(value = "/getAll")
    public
    @ResponseBody
    List<Article> getArticles() {
        return articleService.getArticles();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addArticle(String name, String content) {

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveArticle(String name, String content) {

    }
}
