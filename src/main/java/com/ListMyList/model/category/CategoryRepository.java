package com.ListMyList.model.category;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> findAll();

    Page<Category> findAll(Pageable page);

    Optional<Category> findById(Long id);

    Category save(Category entity);

    void deleteById(Long id);

    boolean existsById(Long id);
}
