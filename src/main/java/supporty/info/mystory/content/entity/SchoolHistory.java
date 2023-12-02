package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : SchoolHistory
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 학력사항 Entity
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
public class SchoolHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_history_id")
    private Long id;                        // 관리번호

    private LocalDateTime startDate;        // 입학일

    private LocalDateTime endDate;          // 졸업일

    @Column(nullable = false)
    private String schoolName;              // 학교명

    private String departmentName;          // 학과명

    private String graduationStatus;        // 졸업 구분

    private String score;                   // 학점

    private String maxScore;                // 최대 점수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_list_id")
    private StoryList storyList;            // 스토리 목록

}
