package ch.rest.controller;

import ch.basebeans.entity.Singer;
import ch.basebeans.service.SingerService;
import ch.rest.serialization.Singers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
 * - @Controller: marks class as Spring MVC Controller
 *
 * - @RequestMapping(value = "/singer"): this controller handles all URLS
 *                                       under localhost:9092/singer
 *
 * - @ResponseBody: applied to all methods. Instructs that all return values from
 *                  the method should be written to the HTTP response directly, and not
 *                  matched to a view
 *
 * - @PathVariable: Springs type conversion system automatically converts String to Long
 *
 * - @RequestBody: automatically binds the content of the HTTP request body into the
 *                 Singer object. Conversion is done by HttpMessageConverter
 */
@Slf4j
@Controller
@RequestMapping(value = "/singer")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public Singers listData() {
        return new Singers(singerService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Singer findSingerById(@PathVariable Long id) {
        return singerService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Singer create(@RequestBody Singer singer) {
        log.info("creating new singer {}", singer);
        singerService.save(singer);
        log.info("new singer created successfully {}", singer);
        return singer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@PathVariable Long id, @RequestBody Singer singer) {
        log.info("updating singer {}", singer);
        singerService.save(singer);
        log.info("singer updated successfully {}", singer);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        log.info("deleting singer with id={}", id);
        Singer singer = singerService.findById(id);
        singerService.delete(singer);
        log.info("singer deleted successfully");
    }
}
