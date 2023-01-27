package com.dugeun.dugeunbackend.domain.professor.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }
}
