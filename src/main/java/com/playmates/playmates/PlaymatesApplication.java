package com.playmates.playmates;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.repository.AppUserRepository;
import com.playmates.playmates.security.JwtTokenServices;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class PlaymatesApplication {

    @Autowired
    AppUserRepository appUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(PlaymatesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {

        return args -> {
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

            AppUser admin = AppUser.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .build();

            appUserRepository.saveAndFlush(admin);
        };
    }

}
