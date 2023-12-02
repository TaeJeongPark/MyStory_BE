package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : Education
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 교육 정보 Entity
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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Long id;                        // 관리번호

    private LocalDateTime startDate;        // 시작일

    private LocalDateTime endDate;          // 종료일

    @Column(nullable = false)
    private String name;                    // 교육명

    private String supervisionName;         // 주관기관

}
