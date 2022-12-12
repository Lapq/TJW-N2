package tjw.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tjw.model.Turma;


@Repository
public interface Turmas extends JpaRepository <Turma, Long> {
	
	Optional<Turma> findById(@Param("id") Long id);
	
	
	@Query("select t "
			+ "from Turma t "
			+ "inner join Usuario u on t.professor = u.id "
			+ "where u.username like :username")    
	Optional<Turma> turmaPorProfessor(String username);
	
	@Query("SELECT t "
			+ "FROM AlunoXTurma axt "
			+ "LEFT JOIN Usuario u ON axt.aluno = u.id "
			+ "LEFT JOIN Turma t ON axt.turma = t.idTurma")
	Optional<Turma> turmasPorCursante(String username);

}
