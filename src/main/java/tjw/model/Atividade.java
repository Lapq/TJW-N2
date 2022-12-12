package tjw.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table (name = "atividade")
public class Atividade {
	@Id
	@GeneratedValue
	@Column (name = "id_atividade")
	private Long idAtividade;
	
	@ManyToOne (targetEntity = Aula.class)
	@JoinColumn (name = "id_aula")
	private Aula aula;
	
	@Temporal (TemporalType.DATE)
	@ManyToOne (targetEntity = Calendario.class)
	@JoinColumn (name = "agendada_para")
	private Calendario agendadoPara;
	
	@OneToMany (targetEntity = AlunoTurmaXAtividade.class, mappedBy = "atividade")
	private Collection<AlunoTurmaXAtividade> alunoTurmaXAtividade = new ArrayList<AlunoTurmaXAtividade>();

	public Long getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Calendario getAgendadoPara() {
		return agendadoPara;
	}

	public void setAgendadoPara(Calendario agendadoPara) {
		this.agendadoPara = agendadoPara;
	}

	public Collection<AlunoTurmaXAtividade> getAlunoTurmaXAtividade() {
		return alunoTurmaXAtividade;
	}

	public void setAlunoTurmaXAtividade(Collection<AlunoTurmaXAtividade> alunoTurmaXAtividade) {
		this.alunoTurmaXAtividade = alunoTurmaXAtividade;
	}
}
