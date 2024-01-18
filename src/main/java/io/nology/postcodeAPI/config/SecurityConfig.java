package io.nology.postcodeAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
   @Bean
   SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
      // Disable CSRF protection to allow creating a postcode
      http
         .csrf(CsrfConfigurer::disable)
         .authorizeHttpRequests((requests) -> requests
            .anyRequest().authenticated()
         )
         .httpBasic(Customizer.withDefaults());
      return http.build();
   }

   @Bean
   public UserDetailsService userDetailsService() {
      UserDetails user =
         User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();

      return new InMemoryUserDetailsManager(user);
   }

}

