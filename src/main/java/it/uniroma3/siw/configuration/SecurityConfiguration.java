package it.uniroma3.siw.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import it.uniroma3.siw.service.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	private final DataSource dataSource;
	private final CustomOAuth2UserService customOAuth2UserService;
	
	public SecurityConfiguration(DataSource dataSource, CustomOAuth2UserService customOAuth2UserService) {
		this.dataSource=dataSource;
		this.customOAuth2UserService = customOAuth2UserService;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery("SELECT username, password, 1 as enabled FROM credentials WHERE username=?");
		manager.setAuthoritiesByUsernameQuery("SELECT username, ruolo FROM credentials WHERE username=?");
		return manager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain configure(final HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests(authorize -> {
			authorize.requestMatchers("/admin/**").hasAuthority("ADMIN");
			authorize.requestMatchers("/istruttore/**").hasAnyAuthority("ADMIN", "ISTRUTTORE");
			authorize.requestMatchers("/utente/**").hasAnyAuthority("ADMIN", "CLIENTE");
			authorize.anyRequest().permitAll();
		});
		httpSecurity.formLogin(form -> {
			form.loginPage("/login").permitAll();
			form.defaultSuccessUrl("/success", true);
			form.failureUrl("/login?error=true");
		});
		httpSecurity.oauth2Login(oauth2 -> {
			oauth2.loginPage("/login");
			oauth2.defaultSuccessUrl("/success", true);
			oauth2.userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService));
		});
		httpSecurity.logout(logout -> {
			logout.logoutUrl("/logout");
			logout.logoutSuccessUrl("/");
			logout.invalidateHttpSession(true);
			logout.deleteCookies("JSESSIONID");
			logout.clearAuthentication(true);
			logout.permitAll();
		});
		return httpSecurity.build();
	}
}
