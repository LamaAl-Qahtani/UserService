package com.example.userService.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyconfigControler {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
