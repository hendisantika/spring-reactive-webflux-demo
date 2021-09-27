package com.hendisantika.springreactivewebfluxdemo.router;

import com.hendisantika.springreactivewebfluxdemo.handler.StudentHandler;
import com.hendisantika.springreactivewebfluxdemo.handler.StudentStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

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
}
