package com.blue.blueTec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blue.blueTec.model.Dto.PessoaDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity
@Getter 
@Setter
@NoArgsConstructor
@Table(name="PESSOAS")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa")
	private Long id_pessoa;
	
	@Column(name="email")
	private String email;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="telefone")
	private String telefone;
	
	public PessoaDto oDto() {
		return new PessoaDto(this);
		
	}
	
	public Pessoa(PessoaDto dto) {
		this.email = dto.getEmail();
		this.nome = dto.getNome();
		this.telefone = dto.getTelefone();
	}


}
