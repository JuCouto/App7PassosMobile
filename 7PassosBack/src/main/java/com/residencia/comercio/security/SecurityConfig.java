package com.residencia.comercio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.residencia.comercio.repositories.UsuarioRepository;
import com.residencia.comercio.services.TokenService;
import com.residencia.comercio.services.UserDetailsServiceImplService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImplService userDetailsServiceImplService;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/autenticacao", 
					"/autenticacao/registro", 
					"/autenticacao/recuperar-senha",
					"/autenticacao/cadastro",
					"/swagger-ui/**",
					"/v3/api-docs/**"
			).permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(
					new TokenAuthenticationFilter(tokenService, usuarioRepository),
					UsernamePasswordAuthenticationFilter.class
			);
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsServiceImplService)
    		.passwordEncoder(new BCryptPasswordEncoder());
    }
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new BCryptPasswordEncoder();
	}
}
