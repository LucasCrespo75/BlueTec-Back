package com.blue.blueTec.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blue.blueTec.model.Pessoa;
import com.blue.blueTec.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repositorio;
	
	@Transactional
	public Pessoa save(Pessoa pessoa) {
		return repositorio.save(pessoa);
	}
	
	@Transactional
	public void delete(Pessoa pessoa) {
		 repositorio.delete(pessoa);;
	
	}
	
	public List<Pessoa> findAll(){
		return repositorio.findAll();
	}
	public Optional<Pessoa> findById(Long id){
		return repositorio.findById(id);
	}
}
