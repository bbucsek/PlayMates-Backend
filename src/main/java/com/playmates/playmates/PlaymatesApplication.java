package com.playmates.playmates;

import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.repository.MechanicsRepository;
import com.playmates.playmates.service.ApiSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PlaymatesApplication {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ApiSearchService apiSearchService;

    @Autowired
    MechanicsRepository mechanicsRepository;

    public static void main(String[] args) {
        SpringApplication.run(PlaymatesApplication.class, args);
    }


}
