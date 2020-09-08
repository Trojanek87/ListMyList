package com.ListMyList.model.DTO;

import com.ListMyList.model.list.List;
import com.ListMyList.model.user.User;

public class ListWriteModel {
    private String name;
    private User creator;

    public List toList(){
        return new List(this.name, this.creator);
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

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
