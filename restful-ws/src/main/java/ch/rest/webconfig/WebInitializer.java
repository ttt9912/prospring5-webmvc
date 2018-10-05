package ch.rest.webconfig;

import ch.basebeans.config.DataConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/*
 * Spring web apps follow the Front Controller design pattern: all requests
 * are received by a single controller (DispatcherServlet instance),
 * which dispatches them to the appropriate handlers (controller classes).
 *
 * AbstractAnnotationConfigDispatcherServletInitializer: replaces web.xml
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{DataConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
