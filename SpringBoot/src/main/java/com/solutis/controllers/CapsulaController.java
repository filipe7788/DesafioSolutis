package com.solutis.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutis.entidade.Capsula;
import com.solutis.Repositories.CapsulaRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CapsulaController {

	@Autowired
	@Qualifier("capsulaRepository")
	private CapsulaRepository capsulaRepository; 
	
	@GetMapping("/capsulas")
	public List<Capsula> getCapsulas() {
		return capsulaRepository.findAll();
	}
	
	@GetMapping("/capsula/{id}")
	public Capsula getCapsula(@PathVariable Long Id) {
		return capsulaRepository.getOne(Id);
	}
	
	@DeleteMapping("/capsula/{id}")
	public boolean removeCapsula(@PathVariable Long Id) {
		capsulaRepository.deleteById(Id);
		return true;
	}
	
	@Transactional
	
	@PostMapping("/capsula")
	public Capsula novaCapsula(@RequestBody Capsula capsula) {
		return capsulaRepository.save(capsula);
	}
	
	@PutMapping("/capsula")
	public Capsula alterarCapsula(@RequestBody Capsula capsula) {
		return capsulaRepository.save(capsula);	
	}
	
}
