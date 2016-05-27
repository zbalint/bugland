package hu.zbalint.bugland.model;

public class ArticleWithAuthor {
    private User user;
    private Article article;

    public ArticleWithAuthor(User user, Article article) {
        this.user = user;
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public Article getArticle() {
        return article;
    }
}
