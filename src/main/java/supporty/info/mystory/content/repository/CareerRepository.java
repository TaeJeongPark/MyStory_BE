package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.Career;

import java.util.List;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : CareerRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 경력사항 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface CareerRepository extends JpaRepository<Career, Long> {

    List<Career> findByStoryListId(Long storyListId);

}
