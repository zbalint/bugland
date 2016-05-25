package hu.zbalint.bugland.controller;

import hu.zbalint.bugland.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ArticleController {

    @Autowired
    ArticleDAO articleDAO;

//    @RequestMapping("/article/add")
//    public void addArticle(String name, String content) {
//
//    }
//
//    @RequestMapping("/article/save")
//    public void saveArticle(String name, String content) {
//
//    }
}
