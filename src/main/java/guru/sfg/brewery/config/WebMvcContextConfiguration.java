package guru.sfg.brewery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcContextConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        /*registry.addResourceHandler("/static/img/**").addResourceLocations("/static/img/");
        registry.addResourceHandler("/static/css/**").addResourceLocations("/static/css/")
                .addResourceLocations("/static/dist/css/**").addResourceLocations("/static/dist/css/");
        registry.addResourceHandler("/static/js/**").addResourceLocations("/static/js/")
                .addResourceLocations("/static/dist/js/**").addResourceLocations("/static/dist/js/");
*/
        registry.addResourceHandler("/resources/**/*").addResourceLocations("classpath:/META-INF/resources/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.htm").setViewName("index");
    }

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        registry.addFormatter(dateFormatter());
    }

    public DateFormatter dateFormatter() {
        return new DateFormatter("dd-MM-yyyy");
    }
}
