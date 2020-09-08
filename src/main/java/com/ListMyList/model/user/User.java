package com.ListMyList.model.user;



import com.ListMyList.model.category.Category;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.list.List;
import com.ListMyList.model.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Users name must be not blaank")
    private String name;
    private String keycloak_id;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "creator", fetch = FetchType.LAZY)
    private Set<List> createdLists;
    @ManyToMany (fetch = FetchType.LAZY)
    private Set<List> onLists;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "creator", fetch = FetchType.LAZY)
    private Set<Category> categoryList;
    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "creator", fetch = FetchType.LAZY)
    private Set<Task> tasksList;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "creator", fetch = FetchType.LAZY)
    private Set<Comment> commentsList;

    public User() {
    }

    public User(String keycloakId){
        this.keycloak_id = keycloakId;
        this.name = "new user";
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

    public String getKeycloak_id() {
        return keycloak_id;
    }

    public void setKeycloak_id(String keycloak_id) {
        this.keycloak_id = keycloak_id;
    }

    public Set<List> getCreatedLists() {
        return createdLists;
    }

    public void setCreatedLists(Set<List> createdLists) {
        this.createdLists = createdLists;
    }

    public Set<List> getOnLists() {
        return onLists;
    }

    public void setOnLists(Set<List> onLists) {
        this.onLists = onLists;
    }

    public Set<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Set<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(Set<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public Set<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(Set<Comment> commentsList) {
        this.commentsList = commentsList;
    }
}
