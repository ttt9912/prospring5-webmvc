package ch16.web.init;

import ch.basebeans.config.DataConfig;
import ch16.web.config.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/*
 * AbstractAnnotationConfigDispatcherServletInitializer: extends
 * WebApplicationInitializer
 *
 * WebApplicationInitializer: enables code based config - replaces instead of web.xml
 * will be automatically detected by SpringServletContainerInitializer which
 * bootstraps automatically in Servlet 3.0 containers
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
     * root WebApplicationContext:
     * created using the provided config classes
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                DataConfig.class
                //, SecurityConfig.class todo
        };
    }

    /*
     * web application context
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /*
     * DispatcherServlet mapping
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
     * servlet Filters:
     * array of Filter implementations that will be applied to every request
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setEncoding("UTF-8");
        cef.setForceEncoding(true);
        return new Filter[]{new HiddenHttpMethodFilter(), cef};
    }
}
