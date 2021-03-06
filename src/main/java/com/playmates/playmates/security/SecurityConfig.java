package com.playmates.playmates.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    public SecurityConfig(JwtTokenServices jwtTokenServices) {
        this.jwtTokenServices = jwtTokenServices;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin").permitAll() // allowed by anyone
                .antMatchers("/auth/registration").permitAll() // allowed by anyone
                .antMatchers(HttpMethod.GET,"/auth/logout").authenticated() // allowed by anyone
                .antMatchers(HttpMethod.GET, "/games/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.POST, "/games/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.PUT, "/games/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.POST, "/events/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.GET, "/events/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.DELETE, "/events/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.PUT, "/events/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.GET, "/profile/**").authenticated() // allowed only when signed in
                .anyRequest().denyAll() // anything else is denied
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}