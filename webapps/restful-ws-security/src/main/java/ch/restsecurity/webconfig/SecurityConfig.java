package ch.restsecurity.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * Configure, who can access the application and what they
 * are allowed to do (using in-memory authentication here)
 *
 * @EnableWebMvc: todo
 *
 * WebSecurityConfigurerAdapter: todo
 */
@Configuration
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
