package com.ListMyList.model.user;

import com.ListMyList.model.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

    User save(User entity);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);
}
