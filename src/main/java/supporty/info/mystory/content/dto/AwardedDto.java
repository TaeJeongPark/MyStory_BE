package supporty.info.mystory.content.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : AwardedDto
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : 수상 내역 Dto
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
public class AwardedDto {

    private String month;               // 수상일
    private String name;                // 수상명
    private String supervisionName;     // 수여 기관

}
