package fr.univ_smb.isc.m1.chess_royale.adapters.web.security;

import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.AppAuthProvider;
import fr.univ_smb.isc.m1.chess_royale.application.ChessRoyaleUserService;
import fr.univ_smb.isc.m1.chess_royale.infrastructure.persistence.ChessRoyaleUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    private final ChessRoyaleUserRepository userRepo;
    private final ChessRoyaleUserService userService;

    public SecurityConfig(ChessRoyaleUserRepository userRepo,
                          ChessRoyaleUserService userService)
    {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.authenticationProvider());

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/hello/admin").hasAuthority("ADMIN")
                .antMatchers("/hello/**").authenticated()
                .antMatchers("/register").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                //.loginPage("/login-form")
                .loginPage("/")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/hello/user", true)
                .failureUrl("/failure");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider getProvider(ChessRoyaleUserService userDetailsService) {
        var provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }
}
