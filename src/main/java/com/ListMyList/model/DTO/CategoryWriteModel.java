package com.ListMyList.model.DTO;

import com.ListMyList.model.category.Category;
import com.ListMyList.model.list.List;
import com.ListMyList.model.user.User;

public class CategoryWriteModel {
    private String name;
    private User creator;
    private List list;

    public Category toCategory(){
        return new Category(this.name, this.creator, this.list);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
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
