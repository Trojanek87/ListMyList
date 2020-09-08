package com.ListMyList.model.DTO;

import com.ListMyList.model.category.Category;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.list.List;
import com.ListMyList.model.task.Task;
import com.ListMyList.model.user.User;

public class CommentWriteModel {
    private String content;
    private User creator;
    private List list;
    private Category category;
    private Task task;

    public Comment toComment(){
        if(this.list!=null)
            return new Comment(this.content, this.creator, this.list);
        else if(this.category!=null)
            return new Comment(this.content, this.creator, this.category);
        else
            return new Comment(this.content, this.creator, this.task);
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

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
