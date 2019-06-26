package com.hendisantika.springreactivewebfluxdemo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-06-27
 * Time: 05:04
 */
@RestController
public class TemperatureController {

    private static Logger logger = LoggerFactory.getLogger(TemperatureController.class);

    @GetMapping(value = "/temperatures", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> getTemperature() {
        Random r = new Random();
        int low = 0;
        int high = 50;
        return Flux.fromStream(Stream.generate(() -> r.nextInt(high - low) + low)
                .map(s -> String.valueOf(s))
                .peek((msg) -> {
                    logger.info(msg);
                }))
                .map(s -> Integer.valueOf(s))
                .delayElements(Duration.ofSeconds(1));

    }
}