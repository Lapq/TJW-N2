package tjw.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@Table (name = "calendario")
public class Calendario {
	@Id
	@Temporal (TemporalType.DATE)
	@Column (name = "data")
	private Date data;
	
	@OneToMany (targetEntity = Aula.class, mappedBy = "data")
	private Collection<Aula> aula = new ArrayList<Aula>();
	
	@OneToMany (targetEntity = Atividade.class, mappedBy = "agendadoPara")
	private Collection<Atividade> atividade = new ArrayList<Atividade>();
	
	@OneToMany (targetEntity = AlunoTurmaXAtividade.class, mappedBy = "entregueEm")
	private Collection<AlunoTurmaXAtividade> AlunoTurmaXAtividade = new ArrayList<AlunoTurmaXAtividade>();
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Collection<Aula> getAula() {
		return aula;
	}

	public void setAula(Collection<Aula> aula) {
		this.aula = aula;
	}

	public Collection<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(Collection<Atividade> atividade) {
		this.atividade = atividade;
	}

	public Collection<AlunoTurmaXAtividade> getAlunoTurmaXAtividade() {
		return AlunoTurmaXAtividade;
	}

	public void setAlunoTurmaXAtividade(Collection<AlunoTurmaXAtividade> alunoTurmaXAtividade) {
		AlunoTurmaXAtividade = alunoTurmaXAtividade;
	}
}
