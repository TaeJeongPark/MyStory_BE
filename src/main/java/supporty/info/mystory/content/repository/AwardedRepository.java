package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.Awarded;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : AwardedRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 수상 내역 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface AwardedRepository extends JpaRepository<Awarded, Long> {



}
