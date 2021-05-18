package com.evolv.blogCRUD.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
//@Table(indexes =
//    {
//            @Index(name = "blog_id_index", columnList = "blogId"),
//            @Index(name = "comment_id_index", columnList = "commentId")
//    }
//)
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long commentId;

    //foreign key reference and index create
    @ManyToOne
    private Blog blog;

    private long parentCommentId;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(name = "dateOfPublish",columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
    private Date createdAt;

    public Comment(long commentId, long parentCommentId, String content, Date createdAt) {
        this.commentId = commentId;
        this.parentCommentId = parentCommentId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment()
    {

    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
