package ch16.web.init;

/*
 * tells spring to enable DelegatingFilterProxy, so
 * springSecurityFilterChain will be used before any
 * other registered Filter
 */
public class SecurityWebApplicationInitializer
        //extends AbstractSecurityWebApplicationInitializer // todo
{
}
