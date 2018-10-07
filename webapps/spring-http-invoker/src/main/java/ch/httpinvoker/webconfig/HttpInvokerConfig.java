package ch.httpinvoker.webconfig;

import ch.basebeans.entity.Singer;
import ch.basebeans.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import java.util.List;

@Configuration
public class HttpInvokerConfig {

    @Autowired
    SingerService singerService;

    /*
     * Expose SingerServiceImpl as SingerService implementation under:
     * http://localhost:9080/spring-http-invoker/invoker/httpInvoker/singerService
     */
    @Bean(name = "/httpInvoker/singerService")
    public HttpInvokerServiceExporter httpInvokerServiceExporter() {
        HttpInvokerServiceExporter invokerService = new HttpInvokerServiceExporter();
        invokerService.setService(singerService);
        invokerService.setServiceInterface(SingerService.class);
        return invokerService;
    }

    @Bean
    public List<Singer> runner() {
        singerService.findAll().forEach(System.out::println);
        return singerService.findAll();
    }
}
