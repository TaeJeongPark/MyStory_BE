package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.StoryList;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : StoryListRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 스토리 목록 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface StoryListRepository extends JpaRepository<StoryList, Long> {



}
