package supporty.info.mystory.content.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import supporty.info.mystory.content.entity.ResumeUser;
import supporty.info.mystory.content.entity.SelfIntroduction;
import supporty.info.mystory.content.entity.Skill;
import supporty.info.mystory.content.entity.StoryList;
import supporty.info.mystory.user.entity.User;
import supporty.info.mystory.user.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : supporty.info.mystory.content.repository
 * fileName       : StoryListRepositoryTest
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : 스토리 목록 Repository Test
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-03        TaeJeongPark       최초 생성
 */
@SpringBootTest
class StoryListRepositoryTest {

    @Autowired
    private UserRepository userRepository;                                // 사용자 Repository

    @Autowired
    private StoryListRepository storyListRepository;                      // 스토리 목록 Repository

    @Autowired
    private ResumeUserRepository resumeUserRepository;                    // 이력자 Repository

    @Autowired
    private SelfIntroductionRepository selfIntroductionRepository;        // 자기소개 Repository

    @Autowired
    private SkillRepository skillRepository;                              // 기술스택 Repository

    @Test
    @DisplayName("스토리 목록 추가 테스트")
    public void createStoryListTest() throws Exception {
        for(int i = 0; i < 100; i++) {
            // 사용자 조회
            User user = userRepository.findById(3205286804L)
                    .orElseThrow(() -> new Exception("Failed get user"));


            // 이력자 저장
            ResumeUser resumeUser = ResumeUser.builder()
                    .imgType("jpg")
                    .imgUrl("url" + i)
                    .desireJob("개발자" + i)
                    .name("홍길동" + i)
                    .birthday("1999-11-28")
                    .email("test" + i + "@test.com")
                    .phone("010-1234-5678")
                    .address("서울시 강남구")
                    .military("만기전역")
                    .introduction("안녕하세요" + i)
                    .build();

            resumeUserRepository.save(resumeUser);


            // 기술스택 저장
            Skill skill = Skill.builder()
                    .languages("Java, C, C++, C#, Python, JavaScript, HTML, CSS, SQL")
                    .frameworkLibrary("Spring, Spring Boot, JPA, MyBatis, jQuery, Bootstrap, Vue.js, React.js")
                    .server("Apache Tomcat, Nginx")
                    .toolDevops("Git, GitHub, GitLab, Jira, Jenkins, Docker, Kubernetes, AWS, GCP, Azure")
                    .environment("Windows, Linux, Mac OS")
                    .etc("Oracle, MySQL, MariaDB, MongoDB, Redis, RabbitMQ, Kafka, Nginx, Apache, AWS, GCP, Azure " + i)
                    .build();

            skillRepository.save(skill);


            // 자기소개 저장
            SelfIntroduction selfIntroduction = SelfIntroduction.builder()
                    .growth("성장과정" + i)
                    .reason("지원동기" + i)
                    .meritFault("장단점" + i)
                    .aspiration("포부" + i)
                    .build();

            selfIntroductionRepository.save(selfIntroduction);


            // 스토리 목록 저장
            StoryList storyList = StoryList.builder()
                    .title("제목" + i)
                    .user(user)
                    .resumeUser(resumeUser)
                    .skill(skill)
                    .selfIntroduction(selfIntroduction)
                    .build();

            storyListRepository.save(storyList);
        }
    }

}