package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : ActivityExperience
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 활동 경험 Entity
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
public class ActivityExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_experience_id")
    private Long id;                        // 관리번호

    private String startMonth;              // 시작일

    private String endMonth;                // 종료일

    private String content;                 // 활동 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_list_id")
    private StoryList storyList;            // 스토리 목록

}
