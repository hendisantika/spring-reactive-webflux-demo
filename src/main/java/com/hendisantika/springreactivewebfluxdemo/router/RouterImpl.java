package com.hendisantika.springreactivewebfluxdemo.router;

import com.hendisantika.springreactivewebfluxdemo.handler.StudentHandler;
import com.hendisantika.springreactivewebfluxdemo.handler.StudentStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/09/21
 * Time: 06.22
 */
@Configuration
public class RouterImpl {

    @Autowired
    private StudentHandler handler;

    @Autowired
    private StudentStreamHandler streamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunctionA() {
        return RouterFunctions.route()
                .GET("/get/students", handler::getAllStudent)
                .GET("/get/students/stream", streamHandler::getAllStudents)
                .GET("/get/students/{student_id}", handler::findById)
                .POST("/add/student", handler::addStudent)
                .build();
    }
}
