package ch.httpinvoker.client;

import ch.basebeans.service.SingerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;


@Configuration
public class RmiClientConfig {

    @Bean
    public SingerService singerService() {
        HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
        factory.setServiceInterface(SingerService.class);
        factory.setServiceUrl("http://localhost:9080/spring-http-invoker/invoker/httpInvoker/singerService");
        factory.afterPropertiesSet();
        return (SingerService) factory.getObject();
    }
}
