package com.ListMyList.logic;

import com.ListMyList.model.DTO.UserReadModel;
import com.ListMyList.model.DTO.UserWriteModel;
import com.ListMyList.model.user.User;
import com.ListMyList.model.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UserReadModel> readUser (Long id){
        if (userRepository.existsById(id)) {
            return Optional.ofNullable(new UserReadModel(userRepository.findById(id).get()));
        }
        return Optional.empty();
    }

    public Optional<UserReadModel> readUser (String name){
        if (userRepository.existsByName(name)) {
            return Optional.ofNullable(new UserReadModel(userRepository.findByName(name).get()));
        }
        return Optional.empty();
    }

    public List<UserReadModel> findAll(){
        List<UserReadModel> allUsers = new ArrayList<>();

        for (User user: userRepository.findAll()) {
            allUsers.add(new UserReadModel(user));
        }
        return allUsers;
    }
    @PostMapping()
    public User createUser (UserWriteModel toCreate){
        User result = userRepository.save(toCreate.toUser());
        return result;
    }

    public Set<com.ListMyList.model.list.List> userCreatedListList(Long id){
        if (userRepository.existsById(id)){
            return userRepository.findById(id).get().getCreatedLists();
        }
        return new HashSet<com.ListMyList.model.list.List>();
    }

    public Set<com.ListMyList.model.list.List> userOnListList(Long id){
        if (userRepository.existsById(id)){
            return userRepository.findById(id).get().getOnLists();
        }
        return new HashSet<com.ListMyList.model.list.List>();
    }


}
