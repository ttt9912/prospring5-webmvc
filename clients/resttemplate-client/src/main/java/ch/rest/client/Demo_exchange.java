package ch.rest.client;

import ch.basebeans.entity.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/*
 * RestTemplate.exchange() allows more configuration by hand than get(), put() post() delete():
 * - HttpMethod RequestEntity, ResponseEntity, etc. can be set manually
 * - Returns a ResponseEntity - get status code etc.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestClientConfig.class})
public class Demo_exchange {

    @Autowired
    private RestTemplate restTemplate;

    // -----------------------------------------------------------------------------
    // exchange() - all http methods
    // -----------------------------------------------------------------------------

    @Test
    public void exchange() {
        ResponseEntity<Singer> responseEntity = restTemplate.exchange(
                "http://localhost:9082/restful-ws/singer/{id}",
                HttpMethod.GET,
                null,
                Singer.class,
                1);

        HttpStatus statusCode = responseEntity.getStatusCode();
        Singer body = responseEntity.getBody();
        HttpHeaders headers = responseEntity.getHeaders();

        System.out.println("statusCode: " + statusCode);
        System.out.println("headers: " + headers);
        System.out.println("body: " + body);
    }
}
