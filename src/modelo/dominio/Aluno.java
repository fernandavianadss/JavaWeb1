package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_alunos")
@SequenceGenerator(name= "ALUNO_PK", sequenceName = "SEQ_ALUNO_PK", allocationSize = 1)
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALUNO_PK")
	private Integer matricula;
	
	@Column(length = 120, nullable = false)
	private String nome;
	
	@Column(length = 20, nullable = false)
	private String cpf;
	
	@Column(length = 15, name = "DATA_NASCIMENTO")
	private String dataNascimento;
	
	@Column(name= "serie")
	private Integer serie;
	
	@Column(length = 200, nullable = false)
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "id_turno_fk")
	private Turno turno;
	
	
	public Aluno() {
		super();
	}


	public Aluno(Integer matricula, String nome, String cpf, String dataNascimento, Integer serie, String endereco) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.serie = serie;
		this.endereco = endereco;
	}


	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
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


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	
	public Turno getTurno() {
		return turno;
	}
	
	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
}
