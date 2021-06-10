package com.bezkoder.spring.security.postgresql.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.security.postgresql.models.Matiere;

import com.bezkoder.spring.security.postgresql.repository.MatiereRepository;
import com.bezkoder.spring.security.postgresql.repository.NiveauRepository;
import com.bezkoder.spring.security.postgresqlNotFoundException.RessourceNotFoundException;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/mat")
public class MatiereController {
	@Autowired
	private MatiereRepository matiereRepository ;
	@Autowired
	private NiveauRepository nr;
	
	//getAllMatiere
	@GetMapping("/matieres")
	public List<Matiere> getAllmatieres()
	{
		
		return matiereRepository.findAll();
	}
	

	//create matiere
	@PostMapping(value="/matieres/{id}")
	public Matiere creatematiere(@RequestBody Matiere matiere,@PathVariable (name="id") long id)
	{
		matiere.setNiveau(this.nr.findById(id).get());
		return matiereRepository.save(matiere);
	}
	//getmatiereById
	@GetMapping("/matieres/{id}")
	public ResponseEntity<Matiere> getMatById(@PathVariable long id)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		return ResponseEntity.ok(matiere);
	}
	//updateMatiere
	@PutMapping("matieres/{id}")
	public ResponseEntity<Matiere> UpdateMatiere(@PathVariable long id , @RequestBody Matiere matieredetails)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		matiere.setLibelle(matieredetails.getLibelle());
		Matiere UpdateMatiere=matiereRepository.save(matiere);
		return ResponseEntity.ok(UpdateMatiere);
		
	}

	//DeleteMatiere
	@DeleteMapping("matieres/{id}")
	ResponseEntity<Map<String,Boolean>> deletmatiere(@PathVariable long id)
	{
		Matiere matiere=matiereRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("matiere does not exist with this id:"+id));
		matiereRepository.delete(matiere);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}

	
}