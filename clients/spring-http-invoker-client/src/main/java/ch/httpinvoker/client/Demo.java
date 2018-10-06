package ch.httpinvoker.client;

import ch.basebeans.service.SingerService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * ch.httpinvoker.client does not load any business configurations into it's ApplicationContext
 * Hence, it does not execute DbInitializer or load SingerServiceImpl
 * into ApplicationContext directly
 *
 * SingerServiceImpl is retrieved and loaded into ApplicationContext
 * from Server (via HTTP Invoker).
 */
public class Demo {

    @Test
    public void client() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(RmiClientConfig.class);

        SingerService singerService = ctx.getBean(SingerService.class);
        singerService.findAll().forEach(System.out::println);

        ctx.close();
    }
}
