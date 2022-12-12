package tjw.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;

@Entity
@Table (name = "arquivo")
public class Arquivo {
	@Id
	@GeneratedValue
	@Column (name = "id_arquivo")
	private Long idArquivo;
	
	@Column (name = "descricao")
	private String descricao;
	
	@Column (name = "flgtipo")
	private char flgTipo;
	
	@Column (name = "url")
	private String url;
	
	@Column (name = "flg_ativ_mat")
	private char flgAtivMat;
	
	@OneToMany (targetEntity = AlunoTurmaXAtividade.class, mappedBy = "arquivo")
	private Collection<AlunoTurmaXAtividade> alunoTurmaXAtividade = new ArrayList<AlunoTurmaXAtividade>();
	
	@OneToOne (targetEntity = Material.class, mappedBy = "arquivo")
	private Material material;

	public Long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public char getFlgTipo() {
		return flgTipo;
	}

	public void setFlgTipo(char flgTipo) {
		this.flgTipo = flgTipo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public char getFlgAtivMat() {
		return flgAtivMat;
	}

	public void setFlgAtivMat(char flgAtivMat) {
		this.flgAtivMat = flgAtivMat;
	}

	public Collection<AlunoTurmaXAtividade> getAlunoTurmaXAtividade() {
		return alunoTurmaXAtividade;
	}

	public void setAlunoTurmaXAtividade(Collection<AlunoTurmaXAtividade> alunoTurmaXAtividade) {
		this.alunoTurmaXAtividade = alunoTurmaXAtividade;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
}
