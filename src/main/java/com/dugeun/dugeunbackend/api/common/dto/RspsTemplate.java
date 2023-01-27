package com.dugeun.dugeunbackend.api.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RspsTemplate<T> {
    private int status;
    private List<T> data;


    @Builder
    public RspsTemplate(int status, java.util.List<T> data) {
        this.status = status;
        this.data = data;
    }
}
