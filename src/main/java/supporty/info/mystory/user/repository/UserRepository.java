package supporty.info.mystory.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.user.entity.User;

import java.util.Optional;

/**
 * packageName    : supporty.info.mystory.user.repository
 * fileName       : UserRepository
 * author         : TaeJeongPark
 * date           : 2023-12-01
 * description    : 사용자 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-01        TaeJeongPark       최초 생성
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findAccessTokenById(Long id);    // 최종 로그인일시 조회

}
