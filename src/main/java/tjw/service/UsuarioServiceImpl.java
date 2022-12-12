package tjw.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tjw.model.Usuario;
import tjw.repository.Usuarios;

@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private Usuarios repository;
		
	@Transactional(readOnly = false)
	public void salvar (Usuario u) {
		repository.save(u);	
	}
	
	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}
	
	public Usuario buscarPorId(Long id) {
		return repository.getById(id);
		
	}
	
	public Optional<Usuario> buscarAtivosPorUsername (String username) {
		return repository.findActiveByUsername(username);
	}

	public void editar(Usuario u) {
		repository.save(u);
		
	}

	public void excluir(Usuario u) {
		repository.delete(u);
	}

}
