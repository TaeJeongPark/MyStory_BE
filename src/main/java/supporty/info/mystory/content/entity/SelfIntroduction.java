package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : SelfIntroduction
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 자기소개 Entity
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
public class SelfIntroduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "self_introduction_id")
    private Long id;                        // 관리번호

    @Column(length = 2000)
    private String growth;                  // 성장과정

    @Column(length = 2000)
    private String reason;                  // 지원동기

    @Column(length = 2000)
    private String meritFault;              // 장단점

    @Column(length = 2000)
    private String aspiration;              // 포부

    @OneToOne(mappedBy = "selfIntroduction", fetch = FetchType.LAZY)
    private StoryList storyList;            // 스토리 목록

}
