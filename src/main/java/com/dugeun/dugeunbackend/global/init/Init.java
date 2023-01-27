package com.dugeun.dugeunbackend.global.init;

import com.dugeun.dugeunbackend.domain.professor.Major;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Init {

    private final ProfessorService professorService;

    @Transactional
    @PostConstruct
    public void init(){
        String[] professorNames = new String[]{"이상윤", "이승진", "김덕봉", "정연식", "김명철", "홍은지", "유상신"
                , "노은하", "김태우", "박정식", "이하규", "정인철", "이종현", "홍성준", "임충규", "김학수"};

        for (String professorName : professorNames) {
            Professor professor = Professor.builder()
                    .professorName(professorName)
                    .major(Major.SOFT)
                    .build();
            professorService.save(professor);
        }
    }

}
