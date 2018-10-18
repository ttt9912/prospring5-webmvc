package ch16.controller;

import ch.basebeans.entity.Singer;
import ch.basebeans.service.SingerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
 * @Controller: defines class as a Spring MVC Controller
 *
 * @RequestMapping: all urls with prefix /singers will be
 * dispatched to this controller
 *
 * Model: passed in by Spring MVC
 */
@Slf4j
@RequestMapping("/singers")
@Controller
public class SingerController {

    @Autowired
    private SingerService singerService;

    private MessageSource messageSource;


    /*
     * the View resolver configured in DispatcherServlet config (WebConfig)
     * will return the file /META-INF/views/singers/list.jspx
     * Spring MVC will pick up the file as view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        final List<Singer> singers = singerService.findAll();
        uiModel.addAttribute("singers", singers);

        return "/singers/list";
    }
}
