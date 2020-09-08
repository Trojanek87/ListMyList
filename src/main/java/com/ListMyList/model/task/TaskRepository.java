package com.ListMyList.model.task;

import com.ListMyList.model.comment.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();

    Page<Task> findAll(Pageable page);

    Optional<Task> findById(Long id);

    List<Task> findByDone (@Param("state") boolean done);

    Task save (Task entity);

    void deleteById (Long id);

    boolean existsById(Long id);

    //Task update (Task entity);

}
