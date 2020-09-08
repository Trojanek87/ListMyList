package com.ListMyList.logic;

import com.ListMyList.model.DTO.CategoryReadModel;
import com.ListMyList.model.DTO.CategoryWriteModel;
import com.ListMyList.model.category.Category;
import com.ListMyList.model.category.CategoryRepository;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.task.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(final CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Optional<CategoryReadModel> readCategory (Long id){
        if (categoryRepository.existsById(id)) {
            return Optional.ofNullable(new CategoryReadModel(categoryRepository.findById(id).get()));
        }
        return Optional.empty();
    }

    public List<CategoryReadModel> findAll(){
        List<CategoryReadModel> allCategory = new ArrayList<>();

        for (Category category: categoryRepository.findAll()) {
            allCategory.add(new CategoryReadModel(category));
        }
        return allCategory;
    }

    public Category createList (CategoryWriteModel toCreate){
        Category result = categoryRepository.save(toCreate.toCategory());
        return result;
    }

    public Set<Comment> commentList(Long id){
        if (categoryRepository.existsById(id)){
            return categoryRepository.findById(id).get().getCommentsList();
        }
        return new HashSet<Comment>();
    }

    public Set<Task> taskList(Long id){
        if (categoryRepository.existsById(id)){
            return categoryRepository.findById(id).get().getTasksList();
        }
        return new HashSet<Task>();
    }


}
