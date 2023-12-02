package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : Skill
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 기술스택 Entity
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
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;                        // 관리번호

    @Column(length = 200)
    private String languages;               // 언어

    @Column(length = 200)
    private String frameworkLibrary;        // 프레임워크/라이브러리

    @Column(length = 200)
    private String server;                  // 서버

    @Column(length = 200)
    private String toolDevops;              // 도구/DevOps

    @Column(length = 200)
    private String environment;             // 환경

    @Column(length = 200)
    private String etc;                     // 기타

}
