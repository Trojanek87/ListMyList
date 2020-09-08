package com.ListMyList.model.DTO;

import com.ListMyList.model.category.Category;

public class CategoryReadModel {
    private String name;
    private UserReadModel creator;
    private int numberOfTask;
    private int numberOfComment;

    public CategoryReadModel(Category category){
        this.name = category.getName();
        this.creator = new UserReadModel(category.getCreator());
        this.numberOfTask = category.getTasksList().size();
        this.numberOfComment = category.getCommentsList().size();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserReadModel getCreator() {
        return creator;
    }

    public void setCreator(UserReadModel creator) {
        this.creator = creator;
    }

    public int getNumberOfTask() {
        return numberOfTask;
    }

    public void setNumberOfTask(int numberOfTask) {
        this.numberOfTask = numberOfTask;
    }

    public int getNumberOfComment() {
        return numberOfComment;
    }

    public void setNumberOfComment(int numberOfComment) {
        this.numberOfComment = numberOfComment;
    }
}
