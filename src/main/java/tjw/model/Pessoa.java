package tjw.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table (name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column (name = "id_pessoa")
	private Long idPessoa;
	
	@Column (name = "nome")
	private String nome;
	
	@Column (name = "cpf")
	private String cpf;
	
	@Temporal (TemporalType.DATE)
	@Column (name = "data_nascimento")
	private Date dataNascimento;
	
	@Lob
	@Column (name = "foto")
	private byte[] foto;
	
	@Column (name = "email")
	private String email;
	
	@OneToOne (targetEntity = Usuario.class, mappedBy = "pessoa")
	private Usuario usuario;
	
	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
