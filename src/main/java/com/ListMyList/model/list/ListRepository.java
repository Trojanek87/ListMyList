package com.ListMyList.model.list;

import com.ListMyList.model.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ListRepository {

    java.util.List<com.ListMyList.model.list.List> findAll();

    Page<com.ListMyList.model.list.List> findAll(Pageable page);

    Optional<com.ListMyList.model.list.List> findById(Long id);

    com.ListMyList.model.list.List save(com.ListMyList.model.list.List entity);

    void deleteById(Long id);

    boolean existsById(Long id);

}
