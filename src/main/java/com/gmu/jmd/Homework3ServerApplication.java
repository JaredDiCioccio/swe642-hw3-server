/**
 * This Spring Boot application is used to store and find Surveys from a database.
 * <p>
 * This file is the main entrypoint and uses some annotations to configure Spring Boot.
 * We opt to use Spring Boot's embedded Tomcat server instead of standing up our own. This way we can build
 * a jar and run it as its own application.
 * <p>
 * There are 3 main components to this application.
 * 1. a Survey entity class that defines the structure of the data for our application.
 * 2. a SurveysRepository used to facilitate interactions with a MySQL database.
 * 3. a SurveysController which allows us to perform CRUD operations.
 */

package com.gmu.jmd;

import com.gmu.jmd.database.SurveysRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
public class Homework3ServerApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(Homework3ServerApplication.class);

    @Autowired
    private SurveysRepository surveysRepository;

    public static void main(String[] args) {
        logger.info("Hello main");
        for (String arg : args) {
            logger.info(arg);
        }
        SpringApplication.run(Homework3ServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("*************************************************");
        logger.info("*                                               *");
        logger.info("*                                               *");
        logger.info("********************* START *********************");
        logger.info("*                                               *");
        logger.info("*                                               *");
        logger.info("*************************************************");
        List<String> argsList = Arrays.asList(args);
        if (argsList.contains("--eraseDatabase")) {
            boolean doErase = false;
            if (argsList.contains("--unattended")) {
                doErase = true;
            } else {
                Scanner scan = new Scanner(System.in);
                System.out.println("Confirm deletion of database entries! N/y");
                String s = scan.next();
                if ("y".equalsIgnoreCase(s)) {
                    doErase = true;
                }
            }
            if (doErase) {
                logger.info("Erasing database!");
                logger.info("Entities available: " + Long.toString(surveysRepository.count()));
                surveysRepository.deleteAll();
                logger.info("Entities available: " + Long.toString(surveysRepository.count()));
            } else {
                logger.info("Not erasing database.");
            }
        }


    }


}
