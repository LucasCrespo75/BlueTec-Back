package com.blue.blueTec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blue.blueTec.config.SwaggerConfig;
import com.blue.blueTec.model.Pessoa;
import com.blue.blueTec.model.Dto.PessoaDto;
import com.blue.blueTec.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {SwaggerConfig.PESSOA_TAG})
@RestController
@RequestMapping({"/api/agendaBlu"})
public class PessoaController {
	
	private PessoaService servico;
	
	public PessoaController(PessoaService servico) {
		this.servico = servico;
	}
	
	@ApiOperation(value="Cadastrando uma pessoa")
	@PostMapping(value = "/pessoa-cadastro", produces = MediaType.APPLICATION_JSON_VALUE)
	public@ResponseBody ResponseEntity <Object> salvar (@RequestBody PessoaDto dto ){
		var pessoa = new Pessoa();
		BeanUtils.copyProperties(dto, pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(servico.save(pessoa));		
		
	}
	
	@ApiOperation(value="Fazendo update a partir do id")
	@PutMapping(value = "/repost/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public@ResponseBody ResponseEntity<Object> update(@PathVariable(value="id") Long id, @RequestBody PessoaDto dto){
		
		Optional<Pessoa> pessoaOp = servico.findById(id);
		if(!pessoaOp.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
		}
		
		var pessoa = new Pessoa();
		BeanUtils.copyProperties(dto, pessoa);
		pessoa.setId_pessoa(pessoaOp.get().getId_pessoa());
		return ResponseEntity.status(HttpStatus.OK).body(servico.save(pessoa));
	
	
	}
		
	
	@ApiOperation(value="Deletando do id")
	@DeleteMapping(value= "/deletar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public@ResponseBody ResponseEntity<Object> delete(@PathVariable(value="id") Long id){
		Optional<Pessoa> pessoa = servico.findById(id);
		if(!pessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
		}
		servico.delete(pessoa.get());
		return ResponseEntity.status(HttpStatus.OK).body("DELETADO COM SUCESSO!!");
	
		
		

				
	}
	
	//Listall
	//@SuppressWarnings("hiding")
	@ApiOperation(value="Listando todos as pessoas")
	@GetMapping(value = "/pessoa", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody /* Retorno do corpo da resposta*/
	public ResponseEntity<List<Pessoa>> listarTodos()  {
		return ResponseEntity.status(HttpStatus.OK).body(servico.findAll());
		
		 	}
	
	//Find
	@ApiOperation(value="Procurando pelo id)")
	@GetMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public@ResponseBody ResponseEntity<Object> findById(@PathVariable(value= "id") Long id ){
		Optional<Pessoa> pessoa = servico.findById(id);
		if(!pessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(pessoa.get());

		
	}
}



	
