package supporty.info.mystory.content.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import supporty.info.mystory.content.dto.ContentListResponseDto;
import supporty.info.mystory.content.entity.StoryList;

import java.util.List;

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

    @Query(value = "SELECT s.title, s.reg_time as regTime, s.update_time as updateTime, s.story_list_id as id FROM story_list s WHERE s.user_id = :userId ORDER BY s.update_time DESC, s.story_list_id DESC", nativeQuery = true)
    List<ContentListResponseDto> findByUserId(@Param("userId") Long userId, Pageable pageable);

}
