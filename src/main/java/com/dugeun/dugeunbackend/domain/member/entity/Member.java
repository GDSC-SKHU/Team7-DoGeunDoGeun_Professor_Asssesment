package com.dugeun.dugeunbackend.domain.member.entity;

import com.dugeun.dugeunbackend.domain.common.BaseEntity;
import com.dugeun.dugeunbackend.domain.member.constant.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Role role;

    @Column(length = 250)
    private String refreshToken;

    private LocalDateTime tokenExpirationTime; // refreshToken 만료 시간.

    @Builder
    public Member(Long memberId, String email, String password, Role role, String refreshToken,
                  LocalDateTime tokenExpirationTime) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.refreshToken = refreshToken;
        this.tokenExpirationTime = tokenExpirationTime;
    }

}
