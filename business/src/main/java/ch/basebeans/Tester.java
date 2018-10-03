package ch.basebeans;


import ch.basebeans.config.DataConfig;
import ch.basebeans.service.SingerService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tester {

    @Test
    public void test(){
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(DataConfig.class);

        SingerService bean = ctx.getBean(SingerService.class);
        bean.findAll().forEach(System.out::println);

        ctx.close();
    }
}
