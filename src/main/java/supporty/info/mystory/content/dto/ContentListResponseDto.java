package supporty.info.mystory.content.dto;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : ContentListResponseDto
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : 스토리 목록 조회 응답 DTO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-03        TaeJeongPark       최초 생성
 */
public interface ContentListResponseDto {

    String getTitle();              // 제목
    String getRegTime();            // 등록일
    String getUpdateTime();         // 수정일
    String getId();                 // 스토리 ID

}
