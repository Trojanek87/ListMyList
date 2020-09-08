package com.ListMyList.model.category;

import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.list.List;
import com.ListMyList.model.task.Task;
import com.ListMyList.model.user.User;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;


@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Category's name must be not blank")
    private String name;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Comment> commentsList;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Task> tasksList;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private List list;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;


    public Category() {
    }
    public Category(String name, User creator, List list){
        this.name = name;
        this.creator = creator;
        this.list = list;
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

    public Set<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(Set<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public Set<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(Set<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User created) {
        this.creator = created;
    }
}