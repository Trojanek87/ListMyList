package com.ListMyList.model.DTO;

import com.ListMyList.model.comment.Comment;

public class CommentReadModel {
    private String content;
    private UserReadModel creator;

    public CommentReadModel(Comment comment){
        this.content = comment.getContent();
        this.creator = new UserReadModel(comment.getCreator());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserReadModel getCreator() {
        return creator;
    }

    public void setCreator(UserReadModel creator) {
        this.creator = creator;
    }
}
