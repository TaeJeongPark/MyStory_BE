package supporty.info.mystory.user.entity;

import jakarta.persistence.*;
import lombok.*;
import supporty.info.mystory.common.utils.BaseDateEntity;
import supporty.info.mystory.content.entity.StoryList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class User extends BaseDateEntity {

    @Id
    @Column(name = "user_id")
    private Long id;                        // 사용자코드

    @Column(nullable = false)
    private String accessToken;             // 액세스 토큰

    @Column(nullable = false)
    private LocalDateTime lastLoginAt;      // 최종 로그인일시

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<StoryList> storyList = new ArrayList<>();            // 스토리 목록

}
