package com.WD.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the passeport database table.
 * 
 */
@Entity
@NamedQuery(name="Passeport.findAll", query="SELECT p FROM Passeport p")
public class Passeport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cin;

	private String codedupays;
	
	private String nom;
	
	private String prenom;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datedenaissance;

	private String numerodupasseport;

	private String sexe;

	private String typedepasseport;

	//bi-directional many-to-one association to Object
	@ManyToOne
	@JoinColumn(name="ido")
	private Object object;

	public Passeport() {
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCodedupays() {
		return this.codedupays;
	}

	public void setCodedupays(String codedupays) {
		this.codedupays = codedupays;
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

	public Date getDatedenaissance() {
		return this.datedenaissance;
	}

	public void setDatedenaissance(Date datedenaissance) {
		this.datedenaissance = datedenaissance;
	}

	public String getNumerodupasseport() {
		return this.numerodupasseport;
	}

	public void setNumerodupasseport(String numerodupasseport) {
		this.numerodupasseport = numerodupasseport;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTypedepasseport() {
		return this.typedepasseport;
	}

	public void setTypedepasseport(String typedepasseport) {
		this.typedepasseport = typedepasseport;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	

}