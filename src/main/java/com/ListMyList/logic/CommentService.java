package com.ListMyList.logic;

import com.ListMyList.model.DTO.CommentReadModel;
import com.ListMyList.model.DTO.CommentWriteModel;
import com.ListMyList.model.comment.Comment;
import com.ListMyList.model.comment.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService (final CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Optional<CommentReadModel> readComment (Long id){
        if (commentRepository.existsById(id)) {
            return Optional.ofNullable(new CommentReadModel(commentRepository.findById(id).get()));
        }
        return Optional.empty();
    }

    public List<CommentReadModel> findAll(){
        List<CommentReadModel> allComments = new ArrayList<>();

        for (Comment comment: commentRepository.findAll()) {
            allComments.add(new CommentReadModel(comment));
        }
        return allComments;
    }

    public Comment createComment (CommentWriteModel toCreate){
        Comment result = commentRepository.save(toCreate.toComment());
        return result;
    }
}
