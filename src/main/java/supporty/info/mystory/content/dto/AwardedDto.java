package supporty.info.mystory.content.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import supporty.info.mystory.content.entity.Awarded;
import supporty.info.mystory.content.entity.Education;

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

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity 변환
    public Awarded dtoToEntity(AwardedDto awardedDto) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(this, Awarded.class);

    }

    // Entity -> DTO 변환
    public static AwardedDto entityToDto(Awarded awarded) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(awarded, AwardedDto.class);

    }

}
