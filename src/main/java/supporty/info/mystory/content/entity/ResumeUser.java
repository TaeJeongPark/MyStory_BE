package supporty.info.mystory.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : supporty.info.mystory.content.entity
 * fileName       : ResumeUser
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : 이력 정보 Entity
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_user_id")
    private Long id;                        // 관리번호

    @Lob
    private byte[] img;                     // 사진

    private String imgType;                 // 사진 타입

    private String imgUrl;                  // 사진 URL

    private String desireJob;               // 희망 직무

    private String name;                    // 이름

    private String birthday;                // 생년월일

    private String email;                   // 이메일

    private String phone;                   // 휴대폰 번호

    private String address;                 // 주소

    private String military;                // 병역

    private String introduction;            // 한 줄 소개

    @OneToOne(mappedBy = "resumeUser", fetch = FetchType.LAZY)
    private StoryList storyList;            // 스토리 목록

}
