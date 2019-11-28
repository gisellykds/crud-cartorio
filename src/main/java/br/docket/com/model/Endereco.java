package br.docket.com.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="endereco")
@SequenceGenerator(initialValue = 1, name = "endereco_sequencia")
public class Endereco {

	@JsonProperty("id_cartorio")
	@Column(unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequencia")
	@Id
	private Long id;
	
	@JsonProperty("cep_cartorio")
	@Column(nullable = true)
	@Pattern(regexp = "\\d{5}-\\d{3}")
	private String cep;
	
	@JsonProperty("rua_cartorio")
	@Column(name="rua_cartorio", nullable=true)	
	private String rua;
	
	@JsonProperty("numero_cartorio")
	@Column(name="numero_cartorio")	
	private String numero;
	
	@JsonProperty("bairro_cartorio")
	@Column(name="bairro_cartorio", nullable=true)	
	private String bairro;
	
	@JsonProperty("cidade_cartorio")
	@Column(name="cidade_cartorio", nullable=true)	
	private String cidade;
	
	@JsonProperty("estado_cartorio")
	@Column(name="estado_cartorio", nullable=true)
	private String estado;
	
	//constructor
	public Endereco(Long id, String cep, String rua, String numero, String bairro,
			String cidade, String estado) {
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco() {
		
	}
	
	// gets and sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
