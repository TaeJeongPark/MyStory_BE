package supporty.info.mystory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * packageName    : supporty.info.mystory.config
 * fileName       : AuditConfig
 * author         : TaeJeongPark
 * date           : 2023-12-03
 * description    : JPA Auditing 활성화
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-08        TaeJeongPark       최초 생성
 */
@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

}
