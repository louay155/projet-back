package com.bezkoder.spring.security.postgresql.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="offre")
public class Offre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="nom_offre")
	private String nom_offre;
	@Column(name="prix")
	private float prix;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="offre")
	private Set<Matiere> matiere= new HashSet<>();
	public Offre() {}
	public Offre(String nom_offre, float prix) {
		super();
		this.nom_offre = nom_offre;
		this.prix = prix;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom_offre() {
		return nom_offre;
	}
	public void setNom_offre(String nom_offre) {
		this.nom_offre = nom_offre;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
