package com.ListMyList.model.list;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SqlListRepository extends ListRepository, JpaRepository <List, Long> {
}
