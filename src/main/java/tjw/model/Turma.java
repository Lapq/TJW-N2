package tjw.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table (name = "turma")
public class Turma {
	@Id
	@GeneratedValue
	@Column (name = "id_turma")
	private Long idTurma;
	
	@Column (name = "nome")
	private String nome;
	
	@ManyToOne (targetEntity = Usuario.class)
	@JoinColumn (name = "id_professor")
	private Usuario professor;
	
	@OneToMany (targetEntity = AlunoXTurma.class, mappedBy = "turma")
	private Collection <AlunoXTurma> alunoXTurma = new ArrayList<AlunoXTurma>();
	
	@OneToMany (targetEntity = Aula.class, mappedBy = "turma")
	private Collection <Aula> aula = new ArrayList<Aula>();
	
	@OneToMany (targetEntity = Material.class, mappedBy = "turma")
	private Collection <Material> material = new ArrayList<Material>();

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public Collection<AlunoXTurma> getAlunoXTurma() {
		return alunoXTurma;
	}

	public void setAlunoXTurma(Collection<AlunoXTurma> alunoXTurma) {
		this.alunoXTurma = alunoXTurma;
	}

	public Collection<Aula> getAula() {
		return aula;
	}

	public void setAula(Collection<Aula> aula) {
		this.aula = aula;
	}

	public Collection<Material> getMaterial() {
		return material;
	}

	public void setMaterial(Collection<Material> material) {
		this.material = material;
	}
}
