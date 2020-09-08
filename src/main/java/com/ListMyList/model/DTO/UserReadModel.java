package com.ListMyList.model.DTO;

import com.ListMyList.model.user.User;

public class UserReadModel {
    private String name;
    private int numberOfLists;
    private int numberOfOnLists;

    public UserReadModel (User user){
        this.name = user.getName();
        this.numberOfLists = user.getCreatedLists().size();
        this.numberOfOnLists = user.getOnLists().size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfLists() {
        return numberOfLists;
    }

    public void setNumberOfLists(int numberOfLists) {
        this.numberOfLists = numberOfLists;
    }

    public int getNumberOfOnLists() {
        return numberOfOnLists;
    }

    public void setNumberOfOnLists(int numberOfOnLists) {
        this.numberOfOnLists = numberOfOnLists;
    }
}
