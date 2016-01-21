package a.m.a;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("UnusedDeclaration")
@RestController
public final class GreetingController {

    Logger logger = Logger.getLogger(GreetingController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")// method=GET for specific
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        logger.info("Calling greetings with params : " + name);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
