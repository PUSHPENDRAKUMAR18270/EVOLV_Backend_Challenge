package com.evolv.blogCRUD.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {

    /*
    * member variables
    * blogId:        The unique id to identify the post.
    * title:         The post title to be displayed on the Post Page
    * content:       The column used to store the post data.
    * dateOfPublish: It stores the date and time at which the post is created.
    * lastUpdated: 	 It stores the date and time at which the post is updated.
    * summary:       The summary of the post to mention the key highlights
    * slug:          The post slug to form the URL.
    * */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long blogId;

    @Column(nullable = false,unique=true)
    private String title;

    @Lob @Column(nullable = false)
    private String content;

    @Column(name = "dateOfPublish",columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
    private Date dateOfPublish;

    @Column(name = "lastUpdated",columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
    private Date lastUpdated;

    @OneToMany
    private List<Comment> comments;

    @Lob
    private String summary;

    private String slug;

    public Blog(long blogId,String title, String content, Date dateOfPublish, Date lastUpdated, String summary, String slug) {
        this.blogId=blogId;
        this.title = title;
        this.content = content;
        this.dateOfPublish = dateOfPublish;
        this.lastUpdated = lastUpdated;
        this.summary = summary;
        this.slug = slug;
    }

    public Blog() {

    }

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(Date dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateOfPublish=" + dateOfPublish +
                ", lastUpdated=" + lastUpdated +
                ", summary='" + summary + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }
}
