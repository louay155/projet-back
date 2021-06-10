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
import com.bezkoder.spring.security.postgresql.models.Niveau;
import com.bezkoder.spring.security.postgresql.repository.CategorieRepository;
import com.bezkoder.spring.security.postgresql.repository.NiveauRepository;
import com.bezkoder.spring.security.postgresqlNotFoundException.RessourceNotFoundException;



;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/niv")
public class NiveauController {
	@Autowired
	private CategorieRepository CR;
	@Autowired
	//getallniveau
	private NiveauRepository niveauRepository;
	@GetMapping("niveaux")
	public List<Niveau> getallniv()
	{
		return niveauRepository.findAll();
	}
	//create niveau
	@PostMapping("niveaux/{id}")
	 public Niveau createNiv(@RequestBody Niveau niveau,@PathVariable(name="id") long id)
	 {
		niveau.setCategories(this.CR.findById(id).get());
		return niveauRepository.save(niveau);
	 }
	//getnibbyid
	@GetMapping("/niveaux/{id}")
	
	public ResponseEntity<Niveau> getnivByid(@PathVariable long id)
	{
		Niveau niveau = niveauRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("niveau does not exist with this id:"+id));
		return ResponseEntity.ok(niveau);
	}
	//getByName
	
	//update Niveau
	@PutMapping("/niveaux/{id}")
	public ResponseEntity<Niveau> updateniv (@PathVariable long id ,@RequestBody Niveau nivdetails)
	{
		Niveau niveau = niveauRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("niveau does not exist with this id:"+id));
		niveau.setLibelle(nivdetails.getLibelle());
		
		Niveau Updateniveau=niveauRepository.save(niveau);
		
		return ResponseEntity.ok(Updateniveau);
		
	}
	//DeleteNiveau
	@DeleteMapping("/niveaux/{id}")
	ResponseEntity<Map<String, Boolean>> deleteniveau(@PathVariable long id)
	{
		Niveau niveau = niveauRepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("niveau does not exist with this id:"+id));
		niveauRepository.delete(niveau);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getMatier/{id}")
	public List<Matiere> getMatierFromNiveau(@PathVariable(name = "id") long id){
		List<Matiere> matiere = niveauRepository.findById(id).get().getMatiere();
		return matiere;
	}
	
	
}
