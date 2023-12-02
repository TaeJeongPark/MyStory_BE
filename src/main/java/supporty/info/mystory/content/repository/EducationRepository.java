package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.Education;

import java.util.List;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : EducationRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 학력사항 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface EducationRepository extends JpaRepository<Education, Long> {

    List<Education> findByStoryListId(Long storyListId);

}
