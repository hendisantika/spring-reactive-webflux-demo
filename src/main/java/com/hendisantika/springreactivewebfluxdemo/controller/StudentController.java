package com.hendisantika.springreactivewebfluxdemo.controller;

import com.hendisantika.springreactivewebfluxdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-webflux-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/09/21
 * Time: 06.23
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

}
