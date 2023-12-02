package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.Skill;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : SkillRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 기술스택 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface SkillRepository extends JpaRepository<Skill, Long> {



}
