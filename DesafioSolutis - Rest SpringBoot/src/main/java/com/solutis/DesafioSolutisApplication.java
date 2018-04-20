package com.solutis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.solutis.Repositories.CapsulaRepository;
import com.solutis.entidade.Capsula;

@SpringBootApplication
public class DesafioSolutisApplication {
	
	@Autowired
	private CapsulaRepository capsulaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioSolutisApplication.class, args);
	}
	
	public void run(String... args)throws Exception {
		capsulaRepository.save(new Capsula("Nescafé Dolce Gusto","Chocolate"));
		capsulaRepository.save(new Capsula("Nescafé Dolce Gusto","Baunilha"));
		capsulaRepository.save(new Capsula("Aroma Nesepresso","Chocolate"));
		capsulaRepository.save(new Capsula("Capsula reutilizável","Chocolate"));


	}
	
}
