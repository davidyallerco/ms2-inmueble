package pe.partnerdigital.inmueble.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Value("${service.security.secure-key-username}")//el valor aqui esta llamando desde el properties
    private String SECURE_KEY_USERNAME;//y se almacena en esta variable

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Value("${service.security.secure-key-username2}")
    private String SECURE_KEY_USERNAME2;

    @Value("${service.security.secure-key-password2}")
    private String SECURE_KEY_PASSWORD2;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder =  http.getSharedObject(
                AuthenticationManagerBuilder.class
        );
        //cargue en memoria los siguientes dos usuarios, puede ser defrente aqui, una mejor opcion es ayudados de la
        //configuraciones adicionales en application properties
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(SECURE_KEY_USERNAME)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser(SECURE_KEY_USERNAME2)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD2))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());
        //ahora vemos que cosa queremos proteger, todos los endpoint este protegidos /**
        return http.antMatcher("/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .csrf()
                .disable()
                .httpBasic()
              /*  .and()
                .exceptionHandling()
                .accessDeniedHandler((request, response, exception) -> {
                    response.sendRedirect("https://www.google.com");
                })*/
                .and()
                .build();
        //....como no estramos trabajando con sesiones como tal sino con ...es por ello que no necesitamos
        //...el csrf , es mas no necesitamso tambien el exceptionhandling que es mas para sesiones
    }
}
