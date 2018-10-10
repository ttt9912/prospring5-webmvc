package ch.restsecurity.webconfig;

import ch.basebeans.config.DataConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /*
     * Dispatcher Servlet base url
     * (remember: DispatcherServlet handles the rest calls)
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/rest/*"};
    }
}
