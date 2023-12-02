package supporty.info.mystory.content.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : EducationDto
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : 교육 정보 Dto
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
public class EducationDto {

    private String startMonth;          // 교육 시작일
    private String endMonth;            // 교육 종료일
    private String name;                // 교육명
    private String supervisionName;     // 주관기관

}
