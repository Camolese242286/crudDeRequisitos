package com.example.jdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jdev.model.Requisitos;

@Repository 
public interface RequsitosRepository extends JpaRepository<Requisitos, Long> {
	
	@Query(value="select u from usuario u where u.nome like %?1%")
   List<Requisitos> buscarPorNome(String nome);
}
