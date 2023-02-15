package com.dugeun.dugeunbackend.api.professor.service;

import com.dugeun.dugeunbackend.api.ability.dto.AbilityListDto;
import com.dugeun.dugeunbackend.api.comment.dto.CommentListDto;
import com.dugeun.dugeunbackend.api.common.dto.RspsTemplate;
import com.dugeun.dugeunbackend.api.common.dto.SingleRspsTemplate;
import com.dugeun.dugeunbackend.api.professor.dto.AddAssessmentDto;
import com.dugeun.dugeunbackend.api.professor.dto.MainPageProfessorDto;
import com.dugeun.dugeunbackend.api.professor.dto.ProfessorDetailDto;
import com.dugeun.dugeunbackend.domain.professor.Major;
import com.dugeun.dugeunbackend.domain.professor.Professor;
import com.dugeun.dugeunbackend.domain.professor.ProfessorService;
import com.dugeun.dugeunbackend.domain.professor.ability.Ability;
import com.dugeun.dugeunbackend.domain.professor.ability.AbilityRepository;
import com.dugeun.dugeunbackend.domain.professor.ability.AbilityService;
import com.dugeun.dugeunbackend.domain.professor.comment.Comment;
import com.dugeun.dugeunbackend.domain.professor.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ApiProfessorService {

    private final ProfessorService professorService;
    private final AbilityService abilityService;
    private final AbilityRepository abilityRepository;
    private final CommentService commentService;

    @Transactional
    public RspsTemplate<MainPageProfessorDto> findAllByMajor(Major major) {
        List<Professor> professors;
        if (major == null){
            professors = professorService.findAll();
        } else {
            professors = professorService.findAllByMajor(major);
        }

        List<MainPageProfessorDto> mainPageProfessorDtos = MainPageProfessorDto.ofList(professors);

        RspsTemplate<MainPageProfessorDto> response = RspsTemplate.<MainPageProfessorDto>builder()
                .status(HttpStatus.OK.value())
                .data(mainPageProfessorDtos)
                .build();

        return response;
    }

    @Transactional
    public SingleRspsTemplate<ProfessorDetailDto> findDetailById(Long id) {
        System.out.println("============시작===========");
        Instant start = Instant.now();

        // id로 조회, 교수의 능력치를 담은 detailDto 반환
        Professor professor = professorService.findByIdFetchComment(id);

        // 통계 쿼리를 실행해 Dto에 담는다.
        AbilityListDto avgAbilityDto = findAvgByProfessorId(id);
        // 담긴 자료를 바탕으로 Rating을 산출한다.
        Integer sum = avgAbilityDto.getSum(); // rating을 제외한 값의 합
        int rating = (int) Math.round(sum / 5.0 / 20.0);
        avgAbilityDto.setRating(rating); // rating은 정수로 변환

        List<CommentListDto> commentListDtos = CommentListDto.ofList(professor.getComments());

        ProfessorDetailDto professorDetailDto = ProfessorDetailDto.builder()
                .professorName(professor.getProfessorName())
                .major(professor.getMajor())
                .ability(avgAbilityDto)
                .comments(commentListDtos)
                .build();
        Instant end = Instant.now();

        System.out.println("수행시간: " + Duration.between(start, end).toMillis() + " ms");
        return SingleRspsTemplate.<ProfessorDetailDto>builder()
                .status(HttpStatus.OK.value())
                .data(professorDetailDto)
                .build();
    }

    @Transactional
    public void addAssessment(Long id, AddAssessmentDto addAssessmentDto) {
        Professor professor = professorService.findById(id);

        Ability ability = addAssessmentDto.toEntity(professor);
        abilityService.save(ability);

        Comment comment = Comment.builder()
                .content(addAssessmentDto.getCommentContent())
                .professor(professor)
                .build();

        commentService.save(comment);
    }

    // DTO를 반환하므로 API패키지에서 Repository 접근
    public AbilityListDto findAvgByProfessorId(Long id) {
        return abilityRepository.findAvgByProfessorId(id);
    }
}




















