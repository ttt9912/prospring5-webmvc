package ch.restsecurity.client;

import ch.basebeans.entity.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/*
 * TODO: does not work yet!!!   /rest/* URLS are not secured!!
 *
 *
 * Credentials are injected into RestTemplate.
 * They are needed to access any urls under /rest/*
 * otherwise the Response is '401 Unauthorized'
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestSecuredClientConfig.class})
public class Demo {

    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void findById() {
        System.out.println("\n--- Singer by id=1 ---");

        Singer singer = restTemplate.getForObject(
                "http://localhost:9084/restful-ws-security/rest/singer/{id}", Singer.class, 1);

        System.out.println(singer);
    }
}
