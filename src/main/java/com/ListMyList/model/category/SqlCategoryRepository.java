package com.ListMyList.model.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SqlCategoryRepository extends CategoryRepository, JpaRepository <Category, Long> {
}
