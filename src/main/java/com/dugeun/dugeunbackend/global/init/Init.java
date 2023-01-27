package com.dugeun.dugeunbackend.global.init;

import com.dugeun.dugeunbackend.domain.professor.Major;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import com.dugeun.dugeunbackend.domain.professor.ability.AbilityService;
import com.dugeun.dugeunbackend.domain.professor.comment.Comment;
import com.dugeun.dugeunbackend.domain.professor.comment.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Init {

    private final ProfessorService professorService;
    private final AbilityService abilityService;
    private final CommentService commentService;

    @Getter
    static class ProfessorAndName{
        private String name;
        private Major major;

        public ProfessorAndName(String name, Major major) {
            this.name = name;
            this.major = major;
        }
    }

    @Transactional
    @PostConstruct
    public void init(){
        List<ProfessorAndName> professorAndNames = new ArrayList<>();
        professorAndNames.add(new ProfessorAndName("이상윤", Major.AI));
        professorAndNames.add(new ProfessorAndName("이승진", Major.SOFT));
        professorAndNames.add(new ProfessorAndName("김덕봉", Major.CE));
        professorAndNames.add(new ProfessorAndName("정연식", Major.CE));
        professorAndNames.add(new ProfessorAndName("김명철", Major.SOFT));
        professorAndNames.add(new ProfessorAndName("홍은지", Major.SOFT));
        professorAndNames.add(new ProfessorAndName("유상신", Major.SOFT));
        professorAndNames.add(new ProfessorAndName("노은하", Major.SOFT));
        professorAndNames.add(new ProfessorAndName("김태우", Major.CE));
        professorAndNames.add(new ProfessorAndName("박정식", Major.CE));
        professorAndNames.add(new ProfessorAndName("이하규", Major.CE));
        professorAndNames.add(new ProfessorAndName("정인철", Major.CE));
        professorAndNames.add(new ProfessorAndName("이종현", Major.CE));
        professorAndNames.add(new ProfessorAndName("홍성준", Major.AI));
        professorAndNames.add(new ProfessorAndName("임충규", Major.CE));
        professorAndNames.add(new ProfessorAndName("김학수", Major.CE));


//        String[] professorNames = new String[]{"이상윤", "이승진", "김덕봉", "정연식", "김명철", "홍은지", "유상신"
//                , "노은하", "김태우", "박정식", "이하규", "정인철", "이종현", "홍성준", "임충규", "김학수"};
        for (ProfessorAndName pNa : professorAndNames) {
            Professor professor = Professor.builder()
                    .professorName(pNa.getName())
                    .major(pNa.getMajor())
                    .build();


            professorService.save(professor);

            Ability ability1 = Ability.builder()
                    .professor(professor)
                    .assignment(100)
                    .kindness(100)
                    .humanity(100)
                    .sensibility(100)
                    .teaching(100)
                    .build();
            Ability ability2 = Ability.builder()
                    .professor(professor)
                    .assignment(10)
                    .kindness(10)
                    .humanity(10)
                    .sensibility(10)
                    .teaching(10)
                    .build();
            abilityService.save(ability1);
            abilityService.save(ability2);

            Comment comment1 = Comment.builder()
                    .content("안아줘요")
                    .professor(professor)
                    .build();
            Comment comment2 = Comment.builder()
                    .content("안아달라니까요")
                    .professor(professor)
                    .build();
            commentService.save(comment1);
            commentService.save(comment2);
        }
    }


}

