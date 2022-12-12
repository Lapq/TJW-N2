package tjw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_geral_perfil")
public enum PerfisDeUsuario {
	PROFESSOR(1L, "PROFESSOR"), ALUNO(2L, "ALUNO");
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "descricao")
	private String desc;
	
	private PerfisDeUsuario (Long id, String desc) {
		this.id = id;
		this.desc = desc;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getDesc() {
		return this.desc;
	}
}
