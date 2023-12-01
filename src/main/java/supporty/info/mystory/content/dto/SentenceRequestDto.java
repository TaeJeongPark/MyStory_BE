package supporty.info.mystory.content.dto;

import lombok.*;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : SentenceRequestDto
 * author         : TaeJeongPark
 * date           : 2023-11-30
 * description    : 자소서 내용 첨삭 요청 DTO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-30        TaeJeongPark       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SentenceRequestDto {

    private String sentence;    // 자소서 내용

}
