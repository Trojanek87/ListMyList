package com.ListMyList.controller;


import com.ListMyList.logic.CommentService;
import com.ListMyList.model.DTO.CommentWriteModel;
import com.ListMyList.model.comment.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    CommentController(final CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    ResponseEntity<Comment> createComment(@RequestBody @Valid CommentWriteModel toCreate) {
        if (toCreate.getContent() == null)
            return ResponseEntity.badRequest().build();

        logger.warn("Comment added");
        Comment result = commentService.createComment(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

}

