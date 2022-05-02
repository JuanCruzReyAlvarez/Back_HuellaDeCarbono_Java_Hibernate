package dds.tp.carbono.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] ALLOWED_URIS = new String[] {
        "/",
        "/api/auth/**",
        "/ui/**",
        "/login",
        "/resources/**",
        "/*.js",
        "/*.css",
        "/*.ttf",
        "/*.woff",
        "/*.ico",
        "/assets/images/**"
    };

    private static final String[] ALLOWED_POST_URIS = new String[] {
        "/api/auth/**",
    };

    // @Autowired
    // UserDetailsServiceImpl userDetailsService;
    
    // @Autowired
    // private AuthEntryPointJwt unauthorizedHandler;

    // @Override
    // public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    //     authenticationManagerBuilder.userDetailsService(userDetailsService)
    //             .passwordEncoder(passwordEncoder());
    // }

    // @Bean
    // public AuthTokenFilter authenticationJwtTokenFilter() {
    //     return new AuthTokenFilter();
    // }

    // @Bean
    // @Override
    // public AuthenticationManager authenticationManagerBean() throws Exception {
    //     return super.authenticationManagerBean();
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
            // .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, ALLOWED_URIS).permitAll()
            .antMatchers(HttpMethod.POST, ALLOWED_POST_URIS).permitAll()
            .anyRequest().authenticated();

        // http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        
        CorsConfiguration configuration = new CorsConfiguration();
        
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }
}