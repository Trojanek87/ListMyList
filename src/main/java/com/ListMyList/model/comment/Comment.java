package com.ListMyList.model.comment;


import com.ListMyList.model.category.Category;
import com.ListMyList.model.list.List;
import com.ListMyList.model.task.Task;
import com.ListMyList.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
    @Table(name = "comments")
    public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Comment's contents must be not blank")
    private String content;
    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private List list;


    public Comment(){}

    public Comment(String con){
            this.content = con;
        }

    public Comment (String content, User creator, List list){
        this.content = content;
        this.creator = creator;
        this.list = list;
    }
    public Comment (String content, User creator, Category category){
        this.content = content;
        this.creator = creator;
        this.category = category;
    }
    public Comment (String content, User creator, Task task){
        this.content = content;
        this.creator = creator;
        this.task = task;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User created) {
        this.creator = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}

