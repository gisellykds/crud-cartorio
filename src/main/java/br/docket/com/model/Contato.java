package br.docket.com.model;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="contato")
@SequenceGenerator(initialValue = 1, name = "contato_sequencia")
public class Contato {
	@JsonProperty("id_contato")
	@Column(unique = true, nullable = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_sequencia")
	@Id
	private Long id;
	
	@JsonProperty("num_contato")
	@Column(name = "num_contato", nullable = true)
	private String num;

	@Autowired
	public Contato(Long id, String num) {
		this.id = id;
		this.num = num;
	}

	public Contato() {
		
	}
	
	// gets and sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	
}
