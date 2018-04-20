package com.solutis.Repositories;

import com.solutis.entidade.Capsula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public interface CapsulaRepository extends JpaRepository<Capsula, Long> {

	
	
}
