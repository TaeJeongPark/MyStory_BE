package supporty.info.mystory.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import supporty.info.mystory.content.entity.Certificate;

import java.util.List;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : CertificateRepository
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 자격증 Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    List<Certificate> findByStoryListId(Long storyListId);

}
