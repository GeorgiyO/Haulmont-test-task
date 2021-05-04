package nekogochan.config;

import nekogochan.database.TestDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TestDB testDB() {
        return new TestDB();
    }

}
