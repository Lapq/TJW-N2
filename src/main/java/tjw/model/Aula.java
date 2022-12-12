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
@Table (name = "aula")
public class Aula {
	@Id
	@GeneratedValue
	@Column (name = "id_aula")
	private Long idAula;
	
	@ManyToOne (targetEntity = Turma.class)
	@JoinColumn (name = "id_turma")
	private Turma turma;
	
	@Column (name = "titulo")
	private String titulo;
	
	@Column (name = "descricao")
	private String descricao;
	
	@Temporal (TemporalType.DATE)
	@ManyToOne (targetEntity = Calendario.class)
	@JoinColumn (name = "data")
	private Calendario data;
	
	@OneToMany (targetEntity = Atividade.class, mappedBy = "aula")
	private Collection<Atividade> atividade = new ArrayList<Atividade>();

	public Long getIdAula() {
		return idAula;
	}

	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Calendario getData() {
		return data;
	}

	public void setData(Calendario data) {
		this.data = data;
	}

	public Collection<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(Collection<Atividade> atividade) {
		this.atividade = atividade;
	}
}
