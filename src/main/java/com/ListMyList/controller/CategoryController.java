package com.ListMyList.controller;

import com.ListMyList.logic.CategoryService;
import com.ListMyList.model.DTO.CategoryWriteModel;
import com.ListMyList.model.category.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    ResponseEntity<Category> createComment(@RequestBody @Valid CategoryWriteModel toCreate) {
        logger.warn("Comment added");
        Category result = categoryService.createList(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
}
