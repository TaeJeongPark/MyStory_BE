package supporty.info.mystory.user.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import supporty.info.mystory.user.entity.User;

import java.time.LocalDateTime;

/**
 *packageName    : supporty.info.mystory.user.dto
 * fileName       : UserDto
 * author         : TaeJeongPark
 * date           : 2023-12-01
 * description    : 사용자 DTO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-01        TaeJeongPark       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {

    Long userId;                    // 사용자코드
    String accessToken;             // 액세스 토큰
    LocalDateTime lastLoginAt;      // 최종 로그인일시

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity 변환
    public User dtoToEntity() {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper.map(this, User.class);

    }

    // Entity -> DTO 변환
    public static UserDto entityToDto(User users) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(users, UserDto.class);

    }

}
