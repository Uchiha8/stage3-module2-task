package config;

import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.repository.implementation.AuthorRepositoryImpl;
import com.mjc.school.repository.implementation.NewsRepositoryImpl;
import com.mjc.school.repository.utils.DataSource;
import com.mjc.school.service.implementation.AuthorService;
import com.mjc.school.service.implementation.NewsService;
import com.mjc.school.service.mapper.NewsMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.mjc.school")
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }

    @Bean
    public AuthorRepositoryImpl authorRepository() {
        return new AuthorRepositoryImpl(dataSource());
    }

    @Bean
    public NewsRepositoryImpl newsRepository() {
        return new NewsRepositoryImpl(dataSource());
    }

    @Bean
    public NewsService newsService() {
        return new NewsService(newsRepository());
    }

    @Bean
    public AuthorService authorService() {
        return new AuthorService(authorRepository());
    }

    @Bean
    public NewsController newsController() {
        return new NewsController(newsService());
    }

    @Bean
    public AuthorController authorController() {
        return new AuthorController(authorService());
    }
}
