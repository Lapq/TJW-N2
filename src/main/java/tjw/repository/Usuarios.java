package tjw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tjw.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository <Usuario, Long> {
	
	Optional<Usuario> findById(@Param("id") Long id);
	
	
	@Query("select u from Usuario u where u.username like :username")    
	Optional<Usuario> findByUsername(String username);
	
	@Query("select u from Usuario u where u.active = true and u.username like :username")
	Optional<Usuario> findActiveByUsername(String username);
}
