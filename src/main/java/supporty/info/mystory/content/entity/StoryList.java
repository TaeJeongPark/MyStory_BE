package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;
import supporty.info.mystory.common.utils.BaseEntity;

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
    private Long id;                        // 관리번호

    @Column(nullable = false)
    private String title;                   // 제목

    @Column(nullable = false)
    private int state;                      // 상태 코드

}
