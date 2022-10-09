package you.you.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserLoginFailHandler userLoginFailHandler;

/*
    @Autowired
    private UserDetailsService userDetailsService;
*/

    /* 빈으로 등록하면 알아서 찾아준다는데 흠...*/
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }*/


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/img/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();*/
        http
                .authorizeRequests()
                .antMatchers("/login", "/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users").permitAll() /*회원가입 요청 허용*/
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/main") // 기본 로그인 페이지 변경
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/users/login")
                //.defaultSuccessUrl("/items")
                .failureHandler(userLoginFailHandler)
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and().csrf().disable()
        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

