package supporty.info.mystory.user.entity;

import jakarta.persistence.*;
import lombok.*;
import supporty.info.mystory.common.utils.BaseTimeEntity;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.user.entity
 * fileName       : User
 * author         : TaeJeongPark
 * date           : 2023-12-01
 * description    : 사용자 Entity
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-01        TaeJeongPark       최초 생성
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "user_id")
    private Long id;                        // 사용자코드

    @Column(nullable = false)
    private String accessToken;             // 액세스 토큰

    @Column(nullable = false)
    private LocalDateTime lastLoginAt;      // 최종 로그인일시

}
