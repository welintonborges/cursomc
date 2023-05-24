package com.example.testeando.config;

import com.example.testeando.services.DBService;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;
    @Bean
    public boolean instantiateDatabase(){
        dbService.instantiaTestDataBase();
        return true;
    }
}
