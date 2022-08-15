package com.blue.blueTec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blue.blueTec.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	@Query(value ="SELECT * FROM PESSOAS p", nativeQuery = true)
	List<Pessoa> findAll();
	
	Optional<Pessoa> findById(@Param("id") Long id);
	
	@Query(value ="UPDATE PESSOAS SET email = email, nome= nome, telefone = telefone WHERE id = id ", nativeQuery = true)
	void update (@Param("email")String email, @Param("nome") String nome,@Param("telefone") String telefone);
		
	//@Modifying
	//@Query(value ="DELETE FROM PESSOAS WHERE id = ?1", nativeQuery = true)
	//void delete(@Param("id")Long id);


	
	
	
	
	

}
