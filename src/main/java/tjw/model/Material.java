package tjw.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table (name = "material")
public class Material {
	@Id
	@GeneratedValue
	@Column (name = "id_material")
	private Long idMaterial;
	
	@ManyToOne (targetEntity = Turma.class)
	@JoinColumn (name="id_turma")
	private Turma turma;
	
	@OneToOne (targetEntity = Arquivo.class)
	@JoinColumn (name = "id_arquivo")
	private Arquivo arquivo;

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
}
