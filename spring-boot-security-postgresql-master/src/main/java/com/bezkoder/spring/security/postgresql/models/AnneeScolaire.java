package com.bezkoder.spring.security.postgresql.models;
import java.util.Date;
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
@Table(name="annescolaire")
public class AnneeScolaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="libelle")
	private Date libelle;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="as")
	private Set<Seance> seance= new HashSet<>();
	public AnneeScolaire() {}
	public AnneeScolaire(Date libelle) {
		super();
		this.libelle = libelle;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getLibelle() {
		return libelle;
	}
	public void setLibelle(Date libelle) {
		this.libelle = libelle;
	}
	

}
