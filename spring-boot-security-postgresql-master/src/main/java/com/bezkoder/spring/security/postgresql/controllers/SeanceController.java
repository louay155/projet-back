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

import com.bezkoder.spring.security.postgresql.models.Categorie;
import com.bezkoder.spring.security.postgresql.models.Seance;
import com.bezkoder.spring.security.postgresql.repository.MatiereRepository;
import com.bezkoder.spring.security.postgresql.repository.ProfesseurRepository;
import com.bezkoder.spring.security.postgresql.repository.SeanceRepository;
import com.bezkoder.spring.security.postgresqlNotFoundException.RessourceNotFoundException;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/seance")
public class SeanceController {
	@Autowired
	private SeanceRepository seancerepository;
	@Autowired
	private MatiereRepository MR;
	@Autowired
	private ProfesseurRepository PF;
	//getAllseance
	@GetMapping("/seances")
	public List<Seance> getallseance()
	
	{
		return seancerepository.findAll();
	}
	//create seance
	@PostMapping("/seances/{idP}/{idM}")
	public Seance createseance(@RequestBody Seance seance,@PathVariable(name ="idP") long idp,@PathVariable(name="idM") long idm)
	{
		seance.setMatiere(this.MR.findById(idm).get());
		seance.setProfesseur(this.PF.findById(idp).get());
		return seancerepository.save(seance);
	}
	//getseanceById
	@GetMapping("seances/{id}")
	public ResponseEntity<Seance> getscebyid(@PathVariable long id)
	{
		Seance seance = seancerepository.findById(id).
				orElseThrow(()->  new RessourceNotFoundException("seance does not exist with this id:"+id));
		return ResponseEntity.ok(seance);
	}
	//Updateseance
	//@PutMapping("/seances/{id}")
	/*public ResponseEntity<Seance> updateseance(@PathVariable long id , @RequestBody Seance seancedetails)
	{
		Seance seance= seancerepository.findById(id).
				orElseThrow(()->  new RessourceNotFoundException("seance does not exist with this id:"+id));
		seance.setDate_sce(seancedetails.getDate_sce());
		seance.setHeure_deb(seancedetails.getHeure_deb());
		seance.setHeure_fin(seancedetails.getHeure_fin());
		seance.setSalle(seancedetails.getSalle());
		
		seance.setProf(seancedetails.getProf());
		Seance Updateseance=seancerepository.save(seance);
		return ResponseEntity.ok(Updateseance);
	}*/
	@DeleteMapping("/seances/{id}")
	ResponseEntity<Map<String, Boolean>> deletecat(@PathVariable long id)
	{
		Seance seance= seancerepository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("seance does not exist with this id:"+id));
		
		seancerepository.delete(seance);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	/*@GetMapping("/getProf/{id}")
	public List<Professeur> getProf(@PathVariable(name = "id") long id){
		List<Seance> seance =  this.MR.findById(id).get().getSeance();
		List<Professeur> prof = new ArrayList();
		for(int i =0;i<seance.size();i++) {
			prof.add(seance.get(i).getProfesseur());
		}
		return prof;
	}*/
	
}
