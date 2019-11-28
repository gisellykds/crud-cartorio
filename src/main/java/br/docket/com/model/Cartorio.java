package br.docket.com.model;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="cartorio")
@SequenceGenerator(initialValue = 1, name = "cartorio_sequencia")
public class Cartorio {

	@JsonProperty("id_cartorio")
	@Column(unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartorio_sequencia")
	@Id
	private Long id;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
	@Column(name = "data_registro")
	private Date dateRegistro;
	
	@JsonProperty("nome_cartorio")
	@Column(name = "nome_cartorio", nullable = true)
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk",referencedColumnName = "id")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartorio_id_fk",referencedColumnName = "id")
	private List<Contato> contato;
	
	//constructor
	@Autowired
	public Cartorio(Long id, Date dateRegistro, String nome, Endereco endereco, List<Contato> contato) {
		this.id = id;
		this.dateRegistro = dateRegistro;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	public Cartorio() {
		
	}


	// gets and sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateRegistro() {
		return dateRegistro;
	}

	public void setDateRegistro(Date dateRegistro) {
		this.dateRegistro = dateRegistro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}
	
}
