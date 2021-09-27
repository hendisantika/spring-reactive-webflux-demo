package com.hendisantika.springreactivewebfluxdemo.handler;

import com.hendisantika.springreactivewebfluxdemo.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/09/21
 * Time: 06.03
 */
@Service
public class StudentHandler {
    public Mono<ServerResponse> getAllStudent(ServerRequest request) {
        Flux<Student> students = Flux.range(1, 20).doOnNext(i -> System.out.println("Student Record : " + i))
                .map(i -> new Student(i, "student " + i));

        return ServerResponse.ok().body(students, Student.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String pathVariable = request.pathVariable("student_id");
        Integer studentId = Integer.valueOf(pathVariable);
        Flux<Student> students = Flux.range(1, 20).doOnNext(i -> System.out.println("Student Record : " + i))
                .map(i -> new Student(i, "student " + i));
        Mono<Student> next = students.filter(std -> std.getId() == studentId).next();
        return ServerResponse.ok().body(next, Student.class);
    }
}
