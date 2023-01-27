package com.dugeun.dugeunbackend.api.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SingleRspsTemplate<T> {
    private int status;
    private T data;

    @Builder
    public SingleRspsTemplate(int status, T data) {
        this.status = status;
        this.data = data;
    }
}
