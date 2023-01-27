package com.dugeun.dugeunbackend.global.converter;

import com.dugeun.dugeunbackend.domain.professor.Major;
import org.springframework.core.convert.converter.Converter;

// RequestParam 에서 바로 ENUM 으로 받아오기 위한 컨버터 구현
// 대소문자까지 완벽히 같아야 스프링 기본 컨버터가 쿼리 파라미터를 ENUM 으로 바꿔주므로, 따로 구현
public class MajorConverter implements Converter<String , Major> {

    @Override
    public Major convert(String source) {
        return Major.from(source);
    }
}
