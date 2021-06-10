package com.bezkoder.spring.security.postgresql.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="categories")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categorie_id")
	private long id;
	@Column(name="libelle")
	private String libelle;
	/*@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="cat")
	private Niveau niveau;*/

	@OneToMany(mappedBy = "categories",cascade=CascadeType.ALL)
	private List<Niveau> niveaus = new ArrayList<>();
	
	
	
public Categorie() {}
public Categorie(String libelle) {
	super();
	this.libelle = libelle;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public List<Niveau> getNiveaus() {
	return niveaus;
}
public void setNiveaus(List<Niveau> niveaus) {
	this.niveaus = niveaus;
}





}
