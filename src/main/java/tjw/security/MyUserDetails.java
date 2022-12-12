package tjw.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tjw.model.Usuario;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails{
	
	private String username;
	private String password;
	private boolean active;
	private List<String> permissoes;
	
	public MyUserDetails(Usuario user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authority = new ArrayList<SimpleGrantedAuthority>();
		
		if (permissoes != null) {
			for (String permissao : permissoes) {
				authority.add(new SimpleGrantedAuthority(permissao));
			}
		}
		
		return authority;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return active;
	}
}
