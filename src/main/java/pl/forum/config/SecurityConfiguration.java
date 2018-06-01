package pl.forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import pl.forum.handler.FailureLoginHandler;
import pl.forum.handler.SuccessLoginHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //TODO wszystkie springowe pola, inicjalizowane przez Autowired, zrobić final

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder encoder;
    private final SuccessLoginHandler successLoginHandler;
    private final FailureLoginHandler failureLoginHandler;

    @Autowired
    public SecurityConfiguration(UserDetailsService userDetailsService, BCryptPasswordEncoder encoder,
                                 SuccessLoginHandler successLoginHandler, FailureLoginHandler failureLoginHandler) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
        this.successLoginHandler = successLoginHandler;
        this.failureLoginHandler = failureLoginHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);


        http.authorizeRequests()
                .antMatchers("/main")
                    .hasAnyRole("USER")
                .antMatchers("/*").permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .successHandler(successLoginHandler)
                    .failureHandler(failureLoginHandler)
                    .permitAll()
                .and().exceptionHandling().accessDeniedPage("/error")
                .and().csrf().disable();

        /*http.authorizeRequests()
                .antMatchers("/main").hasAnyRole("ADMIN")
                .antMatchers("/*").permitAll()
                .and().formLogin()//.successHandler(successLoginHandler)
                    .loginPage("/login").permitAll()
                .and().exceptionHandling().accessDeniedPage("/error")
                .and().csrf().disable();*/

    }

}
