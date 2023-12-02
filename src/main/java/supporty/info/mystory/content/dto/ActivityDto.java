package supporty.info.mystory.content.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import supporty.info.mystory.content.entity.ActivityExperience;
import supporty.info.mystory.content.entity.Awarded;

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

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity 변환
    public ActivityExperience dtoToEntity(ActivityDto activityDto) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(this, ActivityExperience.class);

    }

    // Entity -> DTO 변환
    public static ActivityDto entityToDto(ActivityExperience activityExperience) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(activityExperience, ActivityDto.class);

    }

}
