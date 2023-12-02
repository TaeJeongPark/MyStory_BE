package supporty.info.mystory.content.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import supporty.info.mystory.content.entity.Awarded;
import supporty.info.mystory.content.entity.Career;

import java.time.LocalDateTime;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : CareerDto
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : 경력 Dto
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
public class CareerDto {

    private String startMonth;                  // 경력 시작일
    private String endMonth;                    // 경력 종료일
    private String duty;                        // 직무
    private String companyName;                 // 회사명

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity 변환
    public Career dtoToEntity(CareerDto careerDto) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(this, Career.class);

    }

    // Entity -> DTO 변환
    public static CareerDto entityToDto(Career career) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(career, CareerDto.class);

    }

}
