package supporty.info.mystory.content.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import supporty.info.mystory.content.dto.*;
import supporty.info.mystory.content.entity.*;
import supporty.info.mystory.content.repository.*;
import supporty.info.mystory.user.entity.User;
import supporty.info.mystory.user.repository.UserRepository;

import java.util.List;

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
     * @param contentDto
     * @return boolean
     */
    @Transactional
    public boolean saveContent(ContentDto contentDto) throws Exception {

        if(contentDto == null) throw new Exception("Failed get contentDto");

        log.info("contentDto : " + contentDto);


        // 사용자 조회
        User user = userRepository.findById(contentDto.getId())
                .orElseThrow(() -> new Exception("Failed get user"));


        // 이력자 저장
        ResumeUser resumeUser = ResumeUser.builder()
                .img(contentDto.getImg())
                .imgType(contentDto.getImgType())
                .imgUrl(contentDto.getImgUrl())
                .desireJob(contentDto.getDesireJob())
                .name(contentDto.getName())
                .birthday(contentDto.getBirthday())
                .email(contentDto.getEmail())
                .phone(contentDto.getPhone())
                .address(contentDto.getAddress())
                .military(contentDto.getMilitary())
                .introduction(contentDto.getIntroduction())
                .build();

        resumeUserRepository.save(resumeUser);


        // 기술스택 저장
        Skill skill = Skill.builder()
                .languages(contentDto.getLanguages())
                .frameworkLibrary(contentDto.getFrameworkLibrary())
                .server(contentDto.getServer())
                .toolDevops(contentDto.getToolDevops())
                .environment(contentDto.getEnvironment())
                .etc(contentDto.getEtc())
                .build();

        skillRepository.save(skill);


        // 자기소개 저장
        SelfIntroduction selfIntroduction = SelfIntroduction.builder()
                .growth(contentDto.getGrowth())
                .reason(contentDto.getReason())
                .meritFault(contentDto.getMeritFault())
                .aspiration(contentDto.getAspiration())
                .build();

        selfIntroductionRepository.save(selfIntroduction);


        // 스토리 목록 저장
        StoryList storyList = StoryList.builder()
                .title(contentDto.getTitle())
                .user(user)
                .resumeUser(resumeUser)
                .skill(skill)
                .selfIntroduction(selfIntroduction)
                .build();

        storyListRepository.save(storyList);


        // 자격증 저장
        if(contentDto.getCertificates() != null) {
            contentDto.getCertificates().forEach(certificate -> {
                certificateRepository.save(Certificate.builder()
                                .month(certificate.getMonth())
                                .name(certificate.getName())
                                .storyList(storyList)
                                .build());
            });
        }


        // 교육 저장
        if(contentDto.getEducations() != null) {
            contentDto.getEducations().forEach(education -> {
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
        if(contentDto.getAwards() != null) {
            contentDto.getAwards().forEach(awarded -> {
                awardedRepository.save(Awarded.builder()
                                .month(awarded.getMonth())
                                .name(awarded.getName())
                                .supervisionName(awarded.getSupervisionName())
                                .storyList(storyList)
                                .build());
            });
        }


        // 경력 저장
        if(contentDto.getCareers() != null) {
            contentDto.getCareers().forEach(career -> {
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
        if(contentDto.getActivities() != null) {
            contentDto.getActivities().forEach(activity -> {
                activityExperienceRepository.save(ActivityExperience.builder()
                                .startMonth(activity.getStartMonth())
                                .endMonth(activity.getEndMonth())
                                .content(activity.getContent())
                                .storyList(storyList)
                                .build());
            });
        }


        // 학력 저장
        if(contentDto.getSchools() != null) {
            contentDto.getSchools().forEach(school -> {
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

    /**
     * 스토리 목록 조회
     * @param id
     * @param page
     * @param size
     * @return List<ContentListResponseDto>
     */
    @Transactional(readOnly = true)
    public List<ContentListResponseDto> getContentList(Long id, int page, int size) throws Exception {

        if(id == null) throw new Exception("Failed get id");

        Pageable pageable = PageRequest.of(page, size);
        List<ContentListResponseDto> storyList = storyListRepository.findByUserId(id, pageable);

        log.info("==========> " + storyList.get(0).getId());

        return storyList;

    }

    /**
     * 스토리 목록 상세 조회
     * @param id
     * @return ContentDto
     */
    @Transactional(readOnly = true)
    public ContentDto getContentDetail(Long id) throws Exception {

        if(id == null) throw new Exception("Failed get id");

        ContentDto contentDto = new ContentDto();

        // 스토리 목록 정보
        StoryList storyList = storyListRepository.findById(id)
                .orElseThrow(() -> new Exception("Failed get storyList"));

        contentDto.setId(storyList.getId());
        contentDto.setTitle(storyList.getTitle());

        // 이력자 정보
        ResumeUser resumeUser = resumeUserRepository.findById(storyList.getResumeUser().getId())
                .orElseThrow(() -> new Exception("Failed get resumeUser"));

        contentDto.setImgUrl(resumeUser.getImgUrl());
        contentDto.setDesireJob(resumeUser.getDesireJob());
        contentDto.setName(resumeUser.getName());
        contentDto.setBirthday(resumeUser.getBirthday());
        contentDto.setEmail(resumeUser.getEmail());
        contentDto.setPhone(resumeUser.getPhone());
        contentDto.setAddress(resumeUser.getAddress());
        contentDto.setMilitary(resumeUser.getMilitary());
        contentDto.setIntroduction(resumeUser.getIntroduction());

        // 기술스택 정보
        Skill skill = skillRepository.findById(storyList.getSkill().getId())
                .orElseThrow(() -> new Exception("Failed get skill"));

        contentDto.setLanguages(skill.getLanguages());
        contentDto.setFrameworkLibrary(skill.getFrameworkLibrary());
        contentDto.setServer(skill.getServer());
        contentDto.setToolDevops(skill.getToolDevops());
        contentDto.setEnvironment(skill.getEnvironment());
        contentDto.setEtc(skill.getEtc());

        // 자기소개 정보
        SelfIntroduction selfIntroduction = selfIntroductionRepository.findById(storyList.getSelfIntroduction().getId())
                .orElseThrow(() -> new Exception("Failed get selfIntroduction"));

        contentDto.setGrowth(selfIntroduction.getGrowth());
        contentDto.setReason(selfIntroduction.getReason());
        contentDto.setMeritFault(selfIntroduction.getMeritFault());
        contentDto.setAspiration(selfIntroduction.getAspiration());

        // 자격증 정보
        List<Certificate> certificateList = certificateRepository.findByStoryListId(storyList.getId());

        if(certificateList != null && certificateList.size() > 0) {
            certificateList.forEach(certificate -> {
                contentDto.getCertificates().add(
                        CertificateDto.entityToDto(Certificate.builder()
                        .month(certificate.getMonth())
                        .name(certificate.getName())
                        .build()));
            });
        }

        // 학력 정보
        List<Education> educationList = educationRepository.findByStoryListId(storyList.getId());

        if(educationList != null && educationList.size() > 0) {
            educationList.forEach(education -> {
                contentDto.getEducations().add(
                        EducationDto.entityToDto(Education.builder()
                        .startMonth(education.getStartMonth())
                        .endMonth(education.getEndMonth())
                        .name(education.getName())
                        .supervisionName(education.getSupervisionName())
                        .build()));
            });
        }

        // 수상 정보
        List<Awarded> awardedList = awardedRepository.findByStoryListId(storyList.getId());

        if(awardedList != null && awardedList.size() > 0) {
            awardedList.forEach(awarded -> {
                contentDto.getAwards().add(
                        AwardedDto.entityToDto(Awarded.builder()
                        .month(awarded.getMonth())
                        .name(awarded.getName())
                        .supervisionName(awarded.getSupervisionName())
                        .build()));
            });
        }

        // 경력 정보
        List<Career> careerList = careerRepository.findByStoryListId(storyList.getId());

        if(careerList != null && careerList.size() > 0) {
            careerList.forEach(career -> {
                contentDto.getCareers().add(
                        CareerDto.entityToDto(Career.builder()
                        .startMonth(career.getStartMonth())
                        .endMonth(career.getEndMonth())
                        .duty(career.getDuty())
                        .companyName(career.getCompanyName())
                        .build()));
            });
        }

        // 활동 경험 정보
        List<ActivityExperience> activityExperienceList = activityExperienceRepository.findByStoryListId(storyList.getId());

        if(activityExperienceList != null && activityExperienceList.size() > 0) {
            activityExperienceList.forEach(activityExperience -> {
                contentDto.getActivities().add(
                        ActivityDto.entityToDto(ActivityExperience.builder()
                        .startMonth(activityExperience.getStartMonth())
                        .endMonth(activityExperience.getEndMonth())
                        .content(activityExperience.getContent())
                        .build()));
            });
        }

        // 학교 이력 정보
        List<SchoolHistory> schoolHistoryList = schoolHistoryRepository.findByStoryListId(storyList.getId());

        if(schoolHistoryList != null && schoolHistoryList.size() > 0) {
            schoolHistoryList.forEach(schoolHistory -> {
                contentDto.getSchools().add(
                        SchoolDto.entityToDto(SchoolHistory.builder()
                        .startMonth(schoolHistory.getStartMonth())
                        .endMonth(schoolHistory.getEndMonth())
                        .schoolName(schoolHistory.getSchoolName())
                        .departmentName(schoolHistory.getDepartmentName())
                        .graduateStatus(schoolHistory.getGraduateStatus())
                        .gpa(schoolHistory.getGpa())
                        .gpaMax(schoolHistory.getGpaMax())
                        .build()));
            });
        }

        return contentDto;

    }

}
