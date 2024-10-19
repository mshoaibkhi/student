package stdmgmt.services;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.context.annotation.Configuration;
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}
