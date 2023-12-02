package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;
import supporty.info.mystory.common.utils.BaseEntity;
import supporty.info.mystory.user.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : StoryList
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 스토리 목록 Entity
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoryList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_list_id")
    private Long id;                            // 관리번호

    @Column(nullable = false)
    private String title;                       // 제목

    @Column(nullable = false)
    private int state;                          // 상태 코드

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;                          // 가입자

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_user_id")
    private ResumeUser resumeUser;              // 이력자

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "self_introduction_id")
    private SelfIntroduction selfIntroduction;  // 자기소개

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private Skill skill;                        // 기술스택

    @OneToMany(mappedBy = "storyList", fetch = FetchType.LAZY)
    private List<Certificate> certificate = new ArrayList<>();                  // 자격증 목록

    @OneToMany(mappedBy = "storyList", fetch = FetchType.LAZY)
    private List<Education> education = new ArrayList<>();                      // 교육 목록

    @OneToMany(mappedBy = "storyList", fetch = FetchType.LAZY)
    private List<Awarded> awarded = new ArrayList<>();                          // 수상 목록

    @OneToMany(mappedBy = "storyList", fetch = FetchType.LAZY)
    private List<Career> career = new ArrayList<>();                            // 경력 목록

    @OneToMany(mappedBy = "storyList", fetch = FetchType.LAZY)
    private List<ActivityExperience> activityExperience = new ArrayList<>();    // 활동 경험 목록

    @OneToMany(mappedBy = "storyList", fetch = FetchType.LAZY)
    private List<SchoolHistory> schoolHistory = new ArrayList<>();              // 학력 목록

}
