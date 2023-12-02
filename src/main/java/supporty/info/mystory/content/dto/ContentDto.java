package supporty.info.mystory.content.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : supporty.info.mystory.content.dto
 * fileName       : ContentDto
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 스토리 목록 저장 요청 DTO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ContentDto {

    private Long id;                            // 가입자 ID

    private String title;                       // 제목

    private byte[] img;                         // 사진
    private String imgType;                     // 사진 타입
    private String imgUrl;                      // 사진 URL
    private String desireJob;                   // 희망 직무
    private String name;                        // 이름
    private String birthday;                    // 생년월일
    private String email;                       // 이메일
    private String phone;                       // 휴대폰 번호
    private String address;                     // 주소
    private String military;                    // 병역
    private String introduction;                // 한 줄 소개

    private String growth;                      // 성장과정
    private String reason;                      // 지원동기
    private String meritFault;                  // 장단점
    private String aspiration;                  // 포부

    private String languages;                   // 언어
    private String frameworkLibrary;            // 프레임워크/라이브러리
    private String server;                      // 서버
    private String toolDevops;                  // 도구/DevOps
    private String environment;                 // 환경
    private String etc;                         // 기타

    private List<EducationDto> educations = new ArrayList<>();      // 교육 정보

    private List<ActivityDto> activities = new ArrayList<>();       // 활동 정보

    private List<AwardedDto> awards = new ArrayList<>();            // 수상 정보

    private List<CareerDto> careers = new ArrayList<>();            // 경력 정보

    private List<SchoolDto> schools = new ArrayList<>();            // 학교 정보

    private List<CertificateDto> certificates = new ArrayList<>();  // 자격증 정보

}
