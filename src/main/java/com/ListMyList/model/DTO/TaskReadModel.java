package com.ListMyList.model.DTO;

import com.ListMyList.model.task.Task;

public class TaskReadModel {

    private String content;
    private UserReadModel creator;
    private boolean done;
    private int NumberOfComments;

    public TaskReadModel(Task source) {
        this.content = source.getContent();
        this.creator = new UserReadModel(source.getCreator());
        this.done = source.isDone();
        this.NumberOfComments = source.getCommentsList().size();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserReadModel
    getCreator() {
        return creator;
    }

    public void setCreator(UserReadModel creator) {
        this.creator = creator;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getNumberOfComments() {
        return NumberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.NumberOfComments = numberOfComments;
    }
}
