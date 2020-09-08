package com.ListMyList.model.DTO;

import com.ListMyList.model.category.Category;
import com.ListMyList.model.task.Task;
import com.ListMyList.model.user.User;

public class TaskWriteModel {

    private String content;
    private User creator;
    private Category category;

    public Task toTask() {
        return new Task(this.content, this.creator, this.category);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
