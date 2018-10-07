package ch.rest.client;

import ch.basebeans.entity.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

/*
 * ch.rest.client does not load any business configurations into it's ApplicationContext
 * Hence, it does not execute DbInitializer
 *
 * Tests are executed within a spring application context
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestClientConfig.class})
public class Demo_get_put_post_delete {

    @Autowired
    private RestTemplate restTemplate;


    private static final String URL_UPDATE_SINGER = "http://localhost:9082/restful-ws/singer/{id}";
    private static final String URL_DELETE_SINGER = "http://localhost:9082/restful-ws/singer/{id}";


    // -----------------------------------------------------------------------------
    // GET
    // -----------------------------------------------------------------------------

    /*
     * RestTemplate.getForObject(): calls rest url with optional variables and deserializes
     * json response into a Singer instance (jackson is added to rest template in RestClientConfig)
     */
    @Test
    public void findById() {
        System.out.println("\n--- Singer by id=1 ---");

        Singer singer = restTemplate.getForObject(
                "http://localhost:9082/restful-ws/singer/{id}", Singer.class, 1);

        System.out.println(singer);
    }

    /*
     * Retrieve a List - there are two options:
     * - Use a wrapper type (e.g. Singers)
     * - Use RestTemplate.exchange()
     *
     * https://www.baeldung.com/spring-rest-template-list
     */
    @Test
    public void findAll_withWrapper() {
        System.out.println("\n--- all Singers ---");

        Singers singers = restTemplate.getForObject(
                "http://localhost:9082/restful-ws/singer/listdata", Singers.class);

        singers.getSingers().forEach(System.out::println);
    }


    // -----------------------------------------------------------------------------
    // PUT (= update)
    // -----------------------------------------------------------------------------

    @Test
    public void update() {
        System.out.println("\n--- update Singer ---");

        // get existing
        Singer singer = restTemplate.getForObject(
                "http://localhost:9082/restful-ws/singer/{id}", Singer.class, 1);
        System.out.println("existing: " + singer);

        // update
        singer.setFirstName("John Clayton");

        // put
        restTemplate.put(
                "http://localhost:9082/restful-ws/singer/{id}", singer, 1);

        // get updated
        Singer updated = restTemplate.getForObject(
                "http://localhost:9082/restful-ws/singer/{id}", Singer.class, 1);
        System.out.println("updated: " + updated);
    }


    // -----------------------------------------------------------------------------
    // POST (= create)
    // -----------------------------------------------------------------------------

    @Test
    public void create() {
        System.out.println("\n--- create Singer ---");

        final Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(LocalDate.of(1940, 8, 16));

        Singer singerNew = restTemplate.postForObject(
                "http://localhost:9082/restful-ws/singer/", singer, Singer.class);

        System.out.println("created: " + singerNew);

        printAllSingers();
    }


    // -----------------------------------------------------------------------------
    // DELETE
    // -----------------------------------------------------------------------------

    // works only once per id and runtime ;-)
    @Test
    public void delete() {
        System.out.println("\n--- delete Singer by id=2 ---");

        restTemplate.delete(URL_DELETE_SINGER, 2);

        printAllSingers();
    }


    private void printAllSingers() {
        System.out.println("\n--- all Singers ---");
        Singers singers = restTemplate.getForObject(
                "http://localhost:9082/restful-ws/singer/listdata", Singers.class);
        singers.getSingers().forEach(System.out::println);
    }
}
