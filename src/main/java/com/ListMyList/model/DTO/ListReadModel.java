package com.ListMyList.model.DTO;

import com.ListMyList.model.list.List;

public class ListReadModel {
    private String name;
    private UserReadModel creator;
    private int numberOfCategory;
    private int numberOfComment;

    public ListReadModel(List list){
        this.name = list.getName();
        this.creator = new UserReadModel(list.getCreator());
        this.numberOfCategory = list.getCategoryList().size();
        this.numberOfComment = list.getCommentsList().size();
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

    public int getNumberOfCategory() {
        return numberOfCategory;
    }

    public void setNumberOfCategory(int numberOfCategory) {
        this.numberOfCategory = numberOfCategory;
    }

    public int getNumberOfComment() {
        return numberOfComment;
    }

    public void setNumberOfComment(int numberOfComment) {
        this.numberOfComment = numberOfComment;
    }
}
