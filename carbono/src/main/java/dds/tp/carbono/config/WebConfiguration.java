package dds.tp.carbono.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan
public class WebConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/ui").setStatusCode(HttpStatus.SEE_OTHER);
        registry.addViewController("/login").setViewName("forward:/index.html");
        registry.addViewController("/ui/**").setViewName("forward:/index.html");
    }
}
