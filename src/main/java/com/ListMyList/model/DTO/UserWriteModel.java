package com.ListMyList.model.DTO;

import com.ListMyList.model.user.User;

public class UserWriteModel {
    private String keycloakId;

    public User toUser(){
        User user = new User(this.keycloakId);
        return user;
    }


    public String getName() {
        return keycloakId;
    }

    public void setName(String keycloak_id) {
        this.keycloakId = keycloak_id;
    }
}
