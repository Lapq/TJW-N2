package tjw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Column;

@Entity
@Table (name = "alunoturmaxatividade")
public class AlunoTurmaXAtividade {

	@Id
	@GeneratedValue
	@Column (name = "id_alunoturmaxatividade")
	private Long idATXA;
	
	@ManyToOne (targetEntity = AlunoXTurma.class)
	@JoinColumn (name = "id_alunoxturma")
	private AlunoXTurma alunoXTurma;

	@OneToOne (targetEntity = Atividade.class)
	@JoinColumn (name = "id_atividade")
	private Atividade atividade;
	
	@ManyToOne (targetEntity = Arquivo.class)
	@JoinColumn (name = "id_arquivo")
	private Arquivo arquivo;
	
	@Temporal (TemporalType.DATE)
	@ManyToOne (targetEntity = Calendario.class)
	@JoinColumn (name = "entregue_em")
	private Calendario entregueEm;

	public Long getIdATXA() {
		return idATXA;
	}

	public void setIdATXA(Long idATXA) {
		this.idATXA = idATXA;
	}

	public AlunoXTurma getAlunoXTurma() {
		return alunoXTurma;
	}

	public void setAlunoXTurma(AlunoXTurma alunoXTurma) {
		this.alunoXTurma = alunoXTurma;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public Calendario getEntregueEm() {
		return entregueEm;
	}

	public void setEntregueEm(Calendario entregueEm) {
		this.entregueEm = entregueEm;
	}
}
