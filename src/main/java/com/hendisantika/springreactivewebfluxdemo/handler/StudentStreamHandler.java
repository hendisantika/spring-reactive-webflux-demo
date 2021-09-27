package com.hendisantika.springreactivewebfluxdemo.handler;

import com.hendisantika.springreactivewebfluxdemo.model.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/09/21
 * Time: 06.21
 */
@Service
public class StudentStreamHandler {

    public Mono<ServerResponse> getAllStudents(ServerRequest request) {
        Flux<Student> students = Flux.range(1, 20)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Student Record : " + i))
                .map(i -> new Student(i, "student " + i));

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(students, Student.class);
    }
}
