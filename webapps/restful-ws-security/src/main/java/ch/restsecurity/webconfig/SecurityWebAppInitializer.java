package ch.restsecurity.webconfig;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
 * AbstractSecurityWebApplicationInitializer: registers DelegatingFilterProxy to use
 * springSecurityFilterChain before any other registered Filter
 */
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
}
