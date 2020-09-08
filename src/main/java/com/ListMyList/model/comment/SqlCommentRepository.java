package com.ListMyList.model.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SqlCommentRepository extends CommentRepository, JpaRepository <Comment, Long> {
}
