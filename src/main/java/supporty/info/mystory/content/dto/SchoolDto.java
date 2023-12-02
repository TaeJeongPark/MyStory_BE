package supporty.info.mystory.content.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : SchoolDto
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
public class SchoolDto {

    private String startMonth;                  // 입학일
    private String endMonth;                    // 졸업일
    private String schoolName;                  // 학교명
    private String departmentName;              // 학과명
    private String graduateStatus;              // 졸업 구분
    private String gpa;                         // 학점
    private String gpaMax;                      // 최대 점수

}
