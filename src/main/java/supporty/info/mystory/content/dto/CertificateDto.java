package supporty.info.mystory.content.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import supporty.info.mystory.content.entity.Certificate;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : CertificateDto
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
public class CertificateDto {

    private String month;           // 자격증 취득년월
    private String name;            // 자격증명

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity 변환
    public Certificate dtoToEntity(CertificateDto certificate) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(this, Certificate.class);

    }

    // Entity -> DTO 변환
    public static CertificateDto entityToDto(Certificate certificate) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(certificate, CertificateDto.class);

    }

}
