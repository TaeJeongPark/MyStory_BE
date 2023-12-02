package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : Awarded
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 수상 내역 Entity
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
public class Awarded {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "awarded_id")
    private Long id;                        // 관리번호

    private LocalDateTime awardedDate;      // 수상일

    @Column(nullable = false)
    private String name;                    // 수상명

    private String supervisionName;         // 수여 기관

}
