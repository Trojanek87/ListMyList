package com.ListMyList.model.list;

import com.ListMyList.model.category.Category;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.user.User;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "lists")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "List's name must be not blank")
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;
    @ManyToMany (mappedBy = "onLists", fetch = FetchType.LAZY)
    private Set<User> userList;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "list", fetch = FetchType.LAZY)
    private Set<Comment> commentsList;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "list", fetch = FetchType.LAZY)
    private Set<Category> categoryList;


    public List() {
    }
    public List(String name, User creator){
        this.name = name;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User created) {
        this.creator = created;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    public Set<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(Set<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public Set<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void updateFrom(final List source){
        commentsList = source.commentsList;}
}