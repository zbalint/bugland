package hu.zbalint.bugland.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String subtitle;
    private String content;
    private Date releaseDate;
    private Date lastModifiedDate;
    private long authorId;
    private long modifierId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_types",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    protected Article() {
    }

    public Article(String title, String subtitle, String content, Date releaseDate, Date lastModifiedDate, long authorId, long modifierId) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.releaseDate = releaseDate;
        this.lastModifiedDate = lastModifiedDate;
        this.authorId = authorId;
        this.modifierId = modifierId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getModifierId() {
        return modifierId;
    }

    public void setModifierId(long modifierId) {
        this.modifierId = modifierId;
    }
}
