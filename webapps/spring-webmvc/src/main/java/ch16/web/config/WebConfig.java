package ch16.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 * DispatcherServlet configuration
 *
 * WebMvcConfigurer: defines callback methods enabled by @EnableWebMvc
 *
 * @EnableWebMvc: only allowed on one class
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ch16")
public class WebConfig implements WebMvcConfigurer {

    // used to serve static resources such as images, js, css
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/")
                .setCachePeriod(31556926);
    }

    // define automated controllers preconfigured with response status code
    // and/or a view to render the response body
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("singers/list");
    }

    // enables handler for static resources
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // view resolver matches symbolic view names to *.jspx
    // templates in /WEB-INF/views
    @Bean
    InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jspx");
        resolver.setRequestContextAttribute("requestContext");
        return resolver;
    }
}
