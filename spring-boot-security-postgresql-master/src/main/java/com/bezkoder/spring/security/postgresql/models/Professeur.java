package com.bezkoder.spring.security.postgresql.models;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name="professeurs")
public class Professeur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@Column(name="diplome")
	private String Diplome;
	@Column(name="specialite")
	private String Specialite;
	@Column(name="niv_etud")
	private String Niv_etude;
	@Column(name="gender")
	private Gender gender;
	@OneToMany(mappedBy = "professeur",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Seance> seance = new ArrayList<>();
	/*@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="prof")
	private Seance seance;*/
	/*@JsonIgnore
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "mat_id", referencedColumnName = "id")
	 private Matiere matiere;*/
	public Professeur() {}
	/*public Professeur(String nom, String prenom, Date date_naiss, String email, int tel, String diplome,
			String specialite, String niv_etude, Gender gender) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date_naiss;
		Email = email;
		this.tel = tel;
		Diplome = diplome;
		Specialite = specialite;
		Niv_etude = niv_etude;
		this.gender = gender;
	}*/
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
	public String getDiplome() {
		return Diplome;
	}
	public void setDiplome(String diplome) {
		Diplome = diplome;
	}
	public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}
	public String getNiv_etude() {
		return Niv_etude;
	}
	public void setNiv_etude(String niv_etude) {
		Niv_etude = niv_etude;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public List<Seance> getSeance() {
		return seance;
	}
	public void setSeance(List<Seance> seance) {
		this.seance = seance;
	}

	
	
}
