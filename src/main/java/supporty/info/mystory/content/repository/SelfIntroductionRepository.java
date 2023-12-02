package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.SelfIntroduction;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : SelfIntroductionRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 자기소개 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface SelfIntroductionRepository extends JpaRepository<SelfIntroduction, Long> {



}
