package supporty.info.mystory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)   // Spring Security 설정을 제외함
public class MyStoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStoryApplication.class, args);
    }

}
