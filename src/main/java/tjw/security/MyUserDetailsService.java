package tjw.security;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tjw.model.Usuario;
import tjw.model.Perfil;
import tjw.service.UsuarioServiceImpl;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioServiceImpl service;
	
	@Override @Transactional (readOnly = true)
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		Usuario usuario = service.buscarAtivosPorUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario " + username + " não encontrado."));
		return new User(
				usuario.getUsername(),
				usuario.getPassword(),
				AuthorityUtils.createAuthorityList(getAuthorities(usuario.getPerfis()))
				);
	}
	
	private String[] getAuthorities(List<Perfil> perfis) {
		String[] authorities = new String[perfis.size()];
		for (int i = 0; i < perfis.size(); i++ ) {
			authorities[i] = perfis.get(i).getDesc();
		}
		return authorities;
	}
	
}
