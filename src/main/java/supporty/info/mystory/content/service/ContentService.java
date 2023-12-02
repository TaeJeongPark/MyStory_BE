package supporty.info.mystory.content.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import supporty.info.mystory.content.dto.ContentRequestDto;
import supporty.info.mystory.content.entity.*;
import supporty.info.mystory.content.repository.*;
import supporty.info.mystory.user.entity.User;
import supporty.info.mystory.user.repository.UserRepository;

/**
 * packageName    : supporty.info.mystory.content.service
 * fileName       : ContentService
 * author         : TaeJeongPark
 * date           : 2023-12-02
 * description    : Content Business Logic
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        TaeJeongPark       최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ContentService {

    private final UserRepository userRepository;                                // 사용자 Repository

    private final StoryListRepository storyListRepository;                      // 스토리 목록 Repository

    private final ResumeUserRepository resumeUserRepository;                    // 이력자 Repository

    private final CertificateRepository certificateRepository;                  // 자격증 Repository

    private final EducationRepository educationRepository;                      // 학력 Repository

    private final AwardedRepository awardedRepository;                          // 수상내역 Repository

    private final CareerRepository careerRepository;                            // 경력 Repository

    private final ActivityExperienceRepository activityExperienceRepository;    // 활동 경험 Repository

    private final SchoolHistoryRepository schoolHistoryRepository;              // 학교 이력 Repository

    private final SelfIntroductionRepository selfIntroductionRepository;        // 자기소개 Repository

    private final SkillRepository skillRepository;                              // 기술스택 Repository

    /**
     * 스토리 목록 저장
     * @param contentRequestDto
     * @return boolean
     */
    @Transactional
    public boolean saveContent(ContentRequestDto contentRequestDto) throws Exception {

        if(contentRequestDto == null) throw new Exception("Failed get contentRequestDto");

        log.info("contentRequestDto : " + contentRequestDto);


        // 사용자 조회
        User user = userRepository.findById(contentRequestDto.getId())
                .orElseThrow(() -> new Exception("Failed get user"));


        // 이력자 저장
        ResumeUser resumeUser = ResumeUser.builder()
                .img(contentRequestDto.getImg())
                .imgType(contentRequestDto.getImgType())
                .imgUrl(contentRequestDto.getImgUrl())
                .desireJob(contentRequestDto.getDesireJob())
                .name(contentRequestDto.getName())
                .birthday(contentRequestDto.getBirthday())
                .email(contentRequestDto.getEmail())
                .phone(contentRequestDto.getPhone())
                .address(contentRequestDto.getAddress())
                .military(contentRequestDto.getMilitary())
                .introduction(contentRequestDto.getIntroduction())
                .build();

        resumeUserRepository.save(resumeUser);


        // 기술스택 저장
        Skill skill = Skill.builder()
                .languages(contentRequestDto.getLanguages())
                .frameworkLibrary(contentRequestDto.getFrameworkLibrary())
                .server(contentRequestDto.getServer())
                .toolDevops(contentRequestDto.getToolDevops())
                .environment(contentRequestDto.getEnvironment())
                .etc(contentRequestDto.getEtc())
                .build();

        skillRepository.save(skill);


        // 자기소개 저장
        SelfIntroduction selfIntroduction = SelfIntroduction.builder()
                .growth(contentRequestDto.getGrowth())
                .reason(contentRequestDto.getReason())
                .meritFault(contentRequestDto.getMeritFault())
                .aspiration(contentRequestDto.getAspiration())
                .build();

        selfIntroductionRepository.save(selfIntroduction);


        // 스토리 목록 저장
        StoryList storyList = StoryList.builder()
                .title(contentRequestDto.getTitle())
                .user(user)
                .resumeUser(resumeUser)
                .skill(skill)
                .selfIntroduction(selfIntroduction)
                .build();

        storyListRepository.save(storyList);


        // 자격증 저장
        if(contentRequestDto.getCertificates() != null) {
            contentRequestDto.getCertificates().forEach(certificate -> {
                certificateRepository.save(Certificate.builder()
                                .month(certificate.getMonth())
                                .name(certificate.getName())
                                .storyList(storyList)
                                .build());
            });
        }


        // 교육 저장
        if(contentRequestDto.getEducations() != null) {
            contentRequestDto.getEducations().forEach(education -> {
                educationRepository.save(Education.builder()
                                .startMonth(education.getStartMonth())
                                .endMonth(education.getEndMonth())
                                .name(education.getName())
                                .supervisionName(education.getSupervisionName())
                                .storyList(storyList)
                                .build());
            });
        }


        // 수상 저장
        if(contentRequestDto.getAwards() != null) {
            contentRequestDto.getAwards().forEach(awarded -> {
                awardedRepository.save(Awarded.builder()
                                .month(awarded.getMonth())
                                .name(awarded.getName())
                                .supervisionName(awarded.getSupervisionName())
                                .storyList(storyList)
                                .build());
            });
        }


        // 경력 저장
        if(contentRequestDto.getCareers() != null) {
            contentRequestDto.getCareers().forEach(career -> {
                careerRepository.save(Career.builder()
                                .startMonth(career.getStartMonth())
                                .endMonth(career.getEndMonth())
                                .duty(career.getDuty())
                                .companyName(career.getCompanyName())
                                .storyList(storyList)
                                .build());
            });
        }


        // 활동 경험 저장
        if(contentRequestDto.getActivities() != null) {
            contentRequestDto.getActivities().forEach(activity -> {
                activityExperienceRepository.save(ActivityExperience.builder()
                                .startMonth(activity.getStartMonth())
                                .endMonth(activity.getEndMonth())
                                .content(activity.getContent())
                                .storyList(storyList)
                                .build());
            });
        }


        // 학력 저장
        if(contentRequestDto.getSchools() != null) {
            contentRequestDto.getSchools().forEach(school -> {
                schoolHistoryRepository.save(SchoolHistory.builder()
                                .startMonth(school.getStartMonth())
                                .endMonth(school.getEndMonth())
                                .schoolName(school.getSchoolName())
                                .departmentName(school.getDepartmentName())
                                .graduateStatus(school.getGraduateStatus())
                                .gpa(school.getGpa())
                                .gpaMax(school.getGpaMax())
                                .storyList(storyList)
                                .build());
            });
        }


        return true;

    }

}
