package com.ListMyList.logic;

import com.ListMyList.model.DTO.ListReadModel;
import com.ListMyList.model.DTO.ListWriteModel;
import com.ListMyList.model.category.Category;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.list.ListRepository;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ListService {

    final private ListRepository listRepository;

    public ListService (final ListRepository listRepository){
        this.listRepository = listRepository;
    }

    public Optional<ListReadModel> readList (Long id){
        if (listRepository.existsById(id)) {
            return Optional.ofNullable(new ListReadModel(listRepository.findById(id).get()));
        }
        return Optional.empty();
    }

    public List<ListReadModel> findAll(){
        List<ListReadModel> allLists = new ArrayList<>();

        for (com.ListMyList.model.list.List list: listRepository.findAll()) {
            allLists.add(new ListReadModel(list));
        }
        return allLists;
    }

    public com.ListMyList.model.list.List createList (ListWriteModel toCreate){
        com.ListMyList.model.list.List result = listRepository.save(toCreate.toList());
        return result;
    }

    public Set<Comment> commentList(Long id){
        if (listRepository.existsById(id)){
            return listRepository.findById(id).get().getCommentsList();
        }
        return new HashSet<Comment>();
    }

    public Set<Category> categoryList(Long id){
        if (listRepository.existsById(id)){
            return listRepository.findById(id).get().getCategoryList();
        }
        return new HashSet<Category>();
    }
}
