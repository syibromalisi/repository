package com.ecomindo.onboarding.poc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecomindo.onboarding.poc.dto.OptionsDTO;
import com.ecomindo.onboarding.poc.model.BooksModel;

public interface BooksDao extends JpaRepository<BooksModel, Long> {
	List<BooksModel> findByAuthor(String author);

	List<BooksModel> findByTitle(String title);

	@Query("Select new com.ecomindo.onboarding.poc.dto.OptionsDTO(concat(p.title, ' - ', p.author) as label, p.id as value) from BooksModel p")
	List<OptionsDTO> findDDLTitle();
}
