package com.cjm.spf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/editar/**", "/agregar/**", "/eliminar", "/registrar", "/crear", "/buscar", "/ver",
						"/expediente", "/crearExpediente")
					.hasRole("ADMIN")
				.antMatchers("/buscar_usuaria", "/expediente_psicologico/**", "/expPsic", "/seguimiento_psic/**" ,"/buscar_usuaria", "/agendar_psic", "/canalizar_usuaria_ts/**")
					.hasRole("PSIC")
				.antMatchers("/buscar", "/exp_ludico/**", "/canalizar_ludico/**", "/buscar_registro", "/canalizar_exp_ludico", "/registro_ludico",
						"/bitacora", "/buscar_ninio")
					.hasRole("LUD")
				.antMatchers("/formato/")
					.hasRole("JUD")
				.antMatchers("/registro_emp/**", "/registro_empoderamiento", "/usuaria_empoderamiento")
					.hasRole("EMP")
				.antMatchers("/")
					.hasAnyRole("USER", "ADMIN", "JUD", "PSIC", "LUD", "EMP")
				.and().formLogin().loginPage("/login").and().exceptionHandling()
				.accessDeniedPage("/errores/403");
	}
}
