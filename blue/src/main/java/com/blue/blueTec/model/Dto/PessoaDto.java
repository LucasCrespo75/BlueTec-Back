package com.blue.blueTec.model.Dto;

import com.blue.blueTec.model.Pessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor

public class PessoaDto {		
	
		//private Long id_pessoa;
		
		private String email;
		
		private String nome;
		
		private String telefone;
		
		
		public PessoaDto(Pessoa pessoa) {
		//	this.id_pessoa = pessoa.getId_pessoa();
			this.email = pessoa.getEmail();
			this.nome = pessoa.getNome();
			this.telefone = pessoa.getTelefone();
		}

		

}
