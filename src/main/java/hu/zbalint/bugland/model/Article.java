package hu.zbalint.bugland.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String content;
    private Date releaseDate;
    private Date lastModifiedDate;
    private long AuthorId;
    private long ModifierId;

    protected Article() {
    }

    public Article(String name, String content, Date releaseDate, Date lastModifiedDate, long authorId, long modifierId) {
        this.name = name;
        this.content = content;
        this.releaseDate = releaseDate;
        this.lastModifiedDate = lastModifiedDate;
        AuthorId = authorId;
        ModifierId = modifierId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return AuthorId;
    }

    public void setAuthorId(long authorId) {
        AuthorId = authorId;
    }

    public long getModifierId() {
        return ModifierId;
    }

    public void setModifierId(long modifierId) {
        ModifierId = modifierId;
    }
}
