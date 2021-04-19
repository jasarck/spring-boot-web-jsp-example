package hello;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Log4j2
@Controller
@RequestMapping(value= "/test")
public class TestController {

    @RequestMapping("/testjsp")
    public Object welcome(Map<String, Object> model) {
        log.info("Test Controller");
        model.put("message", "TEST");
        log.info("Test Contorller");
        System.out.println("SOPLN in Test Controller");
        return "test";
    }

    @RequestMapping("/testjs")
    public String test(Map<String, Object> model) {
        log.info("Test Controller");
        model.put("message", "TEST");
        log.info("Test Contorller");
        System.out.println("SOPLN in Test Controller");
        return "test";
    }
}
