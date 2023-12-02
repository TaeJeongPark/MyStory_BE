package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.ActivityExperience;

import java.util.List;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : ActivityExperienceRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 활동경험 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface ActivityExperienceRepository extends JpaRepository<ActivityExperience, Long> {

    List<ActivityExperience> findByStoryListId(Long storyListId);

}
