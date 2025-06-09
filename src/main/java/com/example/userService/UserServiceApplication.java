package com.example.userService;

import com.example.userService.model.AppUser;
import com.example.userService.service.userCommandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(UserServiceApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "9100"));
        app.run(args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner initDate(userCommandService usercommandService) {
        return args -> {
            AppUser user1 = usercommandService.createActiveUser("Danial", "Lozano");
            AppUser user2 = usercommandService.createActiveUser("Erik", "vila");
            AppUser user3 = usercommandService.createActiveUser("Pablo", "Arjona");


        };
    }
}
