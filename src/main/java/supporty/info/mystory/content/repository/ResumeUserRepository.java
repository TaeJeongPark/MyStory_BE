package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.ResumeUser;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : ResumeUserRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 이력자 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface ResumeUserRepository extends JpaRepository<ResumeUser, Long> {



}
