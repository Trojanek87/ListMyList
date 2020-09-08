package com.ListMyList.model.comment;

import com.ListMyList.model.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CommentRepository {

    List<Comment> findAll();

    Page<Comment> findAll(Pageable page);

    Optional<Comment> findById(Long id);

    Comment save(Comment entity);

    void deleteById(Long id);

    boolean existsById(Long id);
}
