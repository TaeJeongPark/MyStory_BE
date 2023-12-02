package supporty.info.mystory.content.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : ActivityDto
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-03        TaeJeongPark       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ActivityDto {

    private String startMonth;          // 활동 시작일
    private String endMonth;            // 활동 종료일
    private String content;             // 활동 내용

}
