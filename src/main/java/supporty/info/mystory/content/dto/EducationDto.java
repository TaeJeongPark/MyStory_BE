package supporty.info.mystory.content.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import supporty.info.mystory.content.entity.Certificate;
import supporty.info.mystory.content.entity.Education;

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

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity 변환
    public Education dtoToEntity(EducationDto educationDto) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(this, Education.class);

    }

    // Entity -> DTO 변환
    public static EducationDto entityToDto(Education education) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(education, EducationDto.class);

    }

}
