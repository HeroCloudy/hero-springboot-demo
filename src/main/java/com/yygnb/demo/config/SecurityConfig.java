package com.yygnb.demo.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @Title: com.yygnb.demo.config.SecurityConfig
 * @Description: <h1></h1>
 * @Date: 2022/9/6 17:59
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/9/6 17:59   dscloudy    Create File.
 */
@Configuration
public class SecurityConfig {

    private final String adminContextPath;

    public SecurityConfig(AdminServerProperties adminServerProperties) {
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler =
                new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(adminContextPath + "/");
        return http.authorizeHttpRequests(auth -> auth.antMatchers(
                                        adminContextPath + "/assets/**",
                                        adminContextPath + "/login",
                                        adminContextPath + "/instances",
                                        adminContextPath + "/actuator/**"
                                ).permitAll()
                                .antMatchers(adminContextPath + "/**").authenticated()
                                .anyRequest().permitAll()
                ).formLogin(form -> form.loginPage(adminContextPath + "/login")
                        .successHandler(successHandler)
                ).logout(logout -> logout.logoutUrl(adminContextPath + "/logout"))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
