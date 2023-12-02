package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : Career
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 경력 Entity
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
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long id;                        // 관리번호

    private LocalDateTime startDate;        // 시작일

    private LocalDateTime endDate;          // 종료일

    private String duty;                    // 직무

    @Column(nullable = false)
    private String companyName;             // 회사명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_list_id")
    private StoryList storyList;            // 스토리 목록

}
