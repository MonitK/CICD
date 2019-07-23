package com.study.spring.mvc.recipes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.study.spring.mvc.recipes.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>
{
	//Spring data JPA query methods
	Optional<UnitOfMeasure> findByDescription(String description);
}
