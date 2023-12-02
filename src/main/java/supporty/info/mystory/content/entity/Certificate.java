package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : Certificate
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 자격증 Entity
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
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long id;                        // 관리번호

    private LocalDateTime certificateDate;  // 취득년월

    @Column(nullable = false)
    private String name;                    // 자격증명

}
