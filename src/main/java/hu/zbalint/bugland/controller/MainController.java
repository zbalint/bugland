package hu.zbalint.bugland.controller;

import hu.zbalint.bugland.dao.UserDAO;
import hu.zbalint.bugland.exception.NotLoggedInException;
import hu.zbalint.bugland.exception.UserNotFoundException;
import hu.zbalint.bugland.model.Article;
import hu.zbalint.bugland.model.ArticleWithAuthor;
import hu.zbalint.bugland.model.User;
import hu.zbalint.bugland.model.UserGroup;
import hu.zbalint.bugland.service.ArticleService;
import hu.zbalint.bugland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        List<Article> articleList = this.articleService.getArticles();
        List<ArticleWithAuthor> articles = new ArrayList<>();
        articleList.forEach(article -> {
            try {
                User user = userService.getUserById(article.getAuthorId());
                articles.add(new ArticleWithAuthor(user, article));
            } catch (UserNotFoundException ex) {
                log.error("Article does not have author: " + ex.getMessage());
            }
        });
        model.addAttribute("articles", articles);
        if (this.userService.isLoggedIn()) {
            try {
                model.addAttribute("user", this.userService.getCurrentUser());
                model.addAttribute("isAdmin", this.userService.hasRights(new UserGroup("Admin")));
            } catch (NotLoggedInException ex) {
                log.error("User is not logged in");
            }
            return "home";
        }
        return "index";
    }

    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/post")
    public String post() {
        return "post";
    }
}
