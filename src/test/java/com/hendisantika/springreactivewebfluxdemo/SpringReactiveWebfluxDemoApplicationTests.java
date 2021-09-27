package com.hendisantika.springreactivewebfluxdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

@SpringBootTest
public class SpringReactiveWebfluxDemoApplicationTests {
    @Test
    public void monoTest() {
        Mono<?> justInt = Mono.just(1)
                .then(Mono.error(new RuntimeException("Mono Exception")))
                .log();
        justInt.subscribe(System.out::println);
    }
}
