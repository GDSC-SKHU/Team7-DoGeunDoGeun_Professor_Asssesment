package com.dugeun.dugeunbackend.domain.professor;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Major {
    SOFT, CE, INFO_AND_COMM, AI;

    //  Json -> DTO 의 역직렬화를 도와주는 JsonCreator. 커스텀 Setter 역할을 한다.
    //  그리고 이 메소드는 @RequestParam 으로 들어오는 커스텀 컨버터에도 등록되어 있음.
    @JsonCreator
    public static Major from(String type){
        return Major.valueOf(type.toUpperCase());
    }
}
