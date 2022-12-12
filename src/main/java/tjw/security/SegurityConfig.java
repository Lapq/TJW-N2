package tjw.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import tjw.model.PerfisDeUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableWebSecurity
@EnableGlobalMethodSecurity (prePostEnabled = true)
public class SegurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//private static final String ALUNO = PerfisDeUsuario.ALUNO.getDesc();
	//private static final String PROFESSOR = PerfisDeUsuario.PROFESSOR.getDesc();
	
	@Override
    protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests()
		.antMatchers("/webjars/**", "/css/**", "/image/**", "/js/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/novaconta**", "/sucesso", "/auditar-novaconta**", "/cadastro", "/cadastrar", "/logout").permitAll()
		//.antMatchers("/**").permitAll() //retirar depois
		.anyRequest().authenticated()
		//.antMatchers("/alunos/cadastrar").hasAnyAuthority("PROFESSOR")
	.and() 
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/", true) 
		.failureUrl("/login-error") 
		.permitAll()
	.and()
		.logout()
		.logoutUrl("/logout")
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/"); 
    }   
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
     
}

