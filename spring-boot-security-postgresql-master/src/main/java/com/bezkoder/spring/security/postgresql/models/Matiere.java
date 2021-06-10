package com.bezkoder.spring.security.postgresql.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="matieres")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="libelle")
	private String libelle;
	/*@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="matiere")
	private Seance seance;*/
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="matiere_offre",
	joinColumns= { @JoinColumn(name="mat_id")},
			inverseJoinColumns= {@JoinColumn(name="offre_id")})
	private Set<Offre> offre  = new HashSet<>();
	/*@JsonIgnore
	@OneToOne(mappedBy="matiere")
	private Professeur professeur;*/
	
	//mapping Matiere & niveau
	@JsonIgnore
	@OneToMany(mappedBy = "matiere",cascade = CascadeType.ALL)
	private List<Seance> seance = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name ="niv_id")
	@JsonIgnore
	private Niveau niveau;
	public Matiere() {}
	/*public Matiere(String libelle) {
		super();
		this.libelle = libelle;
	}*/
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
	
	
	public Set<Offre> getOffre() {
		return offre;
	}
	public void setOffre(Set<Offre> offre) {
		this.offre = offre;
	}
	
	
	public List<Seance> getSeance() {
		return seance;
	}
	public void setSeance(List<Seance> seance) {
		this.seance = seance;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
	
	

}
