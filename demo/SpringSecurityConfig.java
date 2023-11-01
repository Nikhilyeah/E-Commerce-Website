package com.example.demo;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults; 


@Configuration
public class SpringSecurityConfig {
	
	public final DataSource dataSource ; // Inject your DataSource
	
	
	
	public SpringSecurityConfig(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}



	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin@123"));
		return encoder;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests( authorizeRequests ->
					authorizeRequests
					.requestMatchers(new AntPathRequestMatcher("/admin/**"))
					.hasRole("ADMIN")
					.requestMatchers(new AntPathRequestMatcher("/user/**"))
					.hasRole("USER")
					.requestMatchers(new AntPathRequestMatcher("/**"))
					.permitAll()
				)
				 .formLogin(withDefaults());
		return http.build();
	}
	
	 @Bean
	    public UserDetailsService userDetailsService() {
	        JdbcDaoImpl jdbcDao = new JdbcDaoImpl();
	        jdbcDao.setDataSource(dataSource);
	        
	        // Query to load user details (username, password, enabled)
	        jdbcDao.setUsersByUsernameQuery("SELECT username, password, enabled FROM user_table WHERE username = ?");
	        
	        // Query to load user authorities (username, authority)
	        jdbcDao.setAuthoritiesByUsernameQuery("SELECT ud.username, ua.authority "
	                + "FROM user_table AS ud, authorities AS ua "
	                + "WHERE ud.username = ? AND ud.authority_id = ua.id");

	        return jdbcDao;
	    }
}
