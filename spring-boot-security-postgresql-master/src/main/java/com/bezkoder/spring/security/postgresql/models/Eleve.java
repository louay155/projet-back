package com.bezkoder.spring.security.postgresql.models;


import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="eleves")
public class Eleve {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="date_naiss")
	private Date date_naiss;
	@Column(name="Email")
	private String Email;
	@Column(name="tel")
	private int tel;
	@Column(name="nom_pere")
	private String nom_pere;
	@Column(name="nom_mere")
	private String nom_mere;
	@Column(name="cin_par")
	private String cin_par;
	@Column(name="tel_pere")
	private int tel_pere;
	@Column(name="tel_mere")
	private int tel_mere;
	@Column(name="nom_etab")
	private String nom_etab;
	@Column(name="niv_scolaire")
	private String niv_scolaire;
	@Column(name="gender")
	private Gender gender;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="seance_id")
	private Seance seance;
	
	/*@OneToMany(mappedBy = "eleve",cascade = CascadeType.ALL)
	private List<Seance> seance = new ArrayList<>();*/
	public Eleve() {}
	
	public Eleve(String nom, String prenom, Date date_naiss, String email, int tel, String nom_pere, String nom_mere,
			String cin_par, int tel_pere, int tel_mere, String nom_etab, String niv_scolaire, Gender gender) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date_naiss;
		Email = email;
		this.tel = tel;
		this.nom_pere = nom_pere;
		this.nom_mere = nom_mere;
		this.cin_par = cin_par;
		this.tel_pere = tel_pere;
		this.tel_mere = tel_mere;
		this.nom_etab = nom_etab;
		this.niv_scolaire = niv_scolaire;
		this.gender = gender;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(Date date_naiss) {
		this.date_naiss = date_naiss;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getNom_pere() {
		return nom_pere;
	}
	public void setNom_pere(String nom_pere) {
		this.nom_pere = nom_pere;
	}
	public String getNom_mere() {
		return nom_mere;
	}
	public void setNom_mere(String nom_mere) {
		this.nom_mere = nom_mere;
	}
	public String getCin_par() {
		return cin_par;
	}
	public void setCin_par(String cin_par) {
		this.cin_par = cin_par;
	}
	public int getTel_pere() {
		return tel_pere;
	}
	public void setTel_pere(int tel_pere) {
		this.tel_pere = tel_pere;
	}
	public int getTel_mere() {
		return tel_mere;
	}
	public void setTel_mere(int tel_mere) {
		this.tel_mere = tel_mere;
	}
	public String getNom_etab() {
		return nom_etab;
	}
	public void setNom_etab(String nom_etab) {
		this.nom_etab = nom_etab;
	}
	public String getNiv_scolaire() {
		return niv_scolaire;
	}
	public void setNiv_scolaire(String niv_scolaire) {
		this.niv_scolaire = niv_scolaire;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}



	
	
	
	
	

}
