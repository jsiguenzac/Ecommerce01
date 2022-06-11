package com.cibertec.CL2_Ecommerce_JoelSiguenza.web;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    
	//AUTENTICACION
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{        
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
    }
    
    //AUTORIZACION
    @Override
    protected void configure(HttpSecurity http) throws Exception{        
        http.authorizeHttpRequests()
            .antMatchers("/editar/**", "/eliminar", "/agregar/**")
            .hasRole("ADMIN")
            .antMatchers("/")
            .hasAnyRole("USER", "ADMIN")
                .and()
            .formLogin()
            .loginPage("/login")
                .and()
            .exceptionHandling().accessDeniedPage("/errores/403");    
        
    }
    
}
