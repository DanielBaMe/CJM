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
				.antMatchers("/editar/**", "/guardar", "/crearExpediente", "/registrar", "/crear_relaciones_familiares", "/ver/**",
						"/crear_red_apoyo", "/crearExpediente", "/perfil_usuaria/**", "/registro_expediente/**", "/crearNarracion", "/crearEfectos", "/nueva_salud",
						"/crear_filiacion", "/datos_agresor", "/domicilio_agresor", "/perfil_agresor", "/filiacion_agresor", "/factor_riesgo", "/servicios_brindados")
					.hasRole("ADMIN")
				.antMatchers("/buscar_usuaria", "/expediente_psicologico/**", "/expPsic", "/seguimiento_psic/**" ,"/buscar_usuaria", "/agendar_psic",
						"/canalizar_usuaria_ts/**", "/ver_psic/**", "/registro_infantil_psic/**", "/conteo_mes_actual", "/nuevo_seguimiento")
					.hasRole("PSIC")
				.antMatchers("/buscar_ludico", "/expediente_ludico/**", "/canalizar_ludico/**", "/buscar_registro", "/canalizar_exp_ludico", "/registro_ludico",
						"/bitacora_ludico", "/buscar_ninio", "/perfil_ludico/**", "/bitacora_ludico/**")
					.hasRole("LUD")
				.antMatchers("/formato/")
					.hasRole("JUD")
				.antMatchers("/registro_emp/**", "/registro_empoderamiento", "/usuaria_empoderamiento", "/informe_empoderamiento", "/seguimiento_emp/**",
						"/seguimiento_empoderamiento", "/perfil_emp/**")
					.hasRole("EMP")
				.antMatchers("/", "/buscar", "/*.css")
					.hasAnyRole("ADMIN", "JUD", "PSIC", "LUD", "EMP")
				.and().formLogin().loginPage("/login").and().exceptionHandling()
				.accessDeniedPage("/errores/403");
	}
}
