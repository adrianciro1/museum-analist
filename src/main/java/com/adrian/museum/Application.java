package com.adrian.museum;

import com.adrian.museum.service.AnalistService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Main class for running application
 * Created by Adrian
 */
@Configuration
@ComponentScan(basePackages = {"com.adrian.museum"})
public class Application  {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        AnalistService analist = (AnalistService) context.getBean("analistService");
        analist.start(args);
    }
}
