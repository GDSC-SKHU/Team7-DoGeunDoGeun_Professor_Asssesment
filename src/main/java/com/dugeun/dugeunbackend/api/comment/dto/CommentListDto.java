package com.dugeun.dugeunbackend.api.comment.dto;

import com.dugeun.dugeunbackend.domain.professor.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CommentListDto {

    private String username = "익명";
    private String content;

    // comment의 리스트를 commentList의 리스트로

    public static CommentListDto of(Comment comment){
        return CommentListDto.builder()
                .content(comment.getContent())
                .username(comment.getUsername())
                .build();
    }

    public static List<CommentListDto> ofList(List<Comment> comments){
        return comments.stream()
                .map(comment -> CommentListDto.of(comment))
                .collect(Collectors.toList());
    }

    @Builder
    public CommentListDto(String username, String content) {
        this.username = username;
        this.content = content;
    }
}
