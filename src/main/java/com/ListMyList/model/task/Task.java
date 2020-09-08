package com.ListMyList.model.task;

import com.ListMyList.model.category.Category;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.user.User;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "Task's contents must be not blaank")
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task", fetch = FetchType.LAZY)
    private Set<Comment> commentsList;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private boolean done;




    public Task() {
    }

    public Task(String content, User creator, Category category) {
        this.content = content;
        this.creator = creator;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String contents) {
        this.content = contents;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User created) {
        this.creator = created;
    }

    public Set<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(Set<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void updateFrom(final Task source){
        commentsList = source.commentsList;
    }



}

