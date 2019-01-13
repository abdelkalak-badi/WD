package com.WD.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cartecin database table.
 * 
 */
@Entity
@NamedQuery(name="Cartecin.findAll", query="SELECT c FROM Cartecin c")
public class Cartecin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String numcin;

	private String adresse;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateness;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Object
	@ManyToOne
	@JoinColumn(name="ido")
	private Object object;

	public Cartecin() {
	}

	public String getNumcin() {
		return this.numcin;
	}

	public void setNumcin(String numcin) {
		this.numcin = numcin;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateness() {
		return this.dateness;
	}

	public void setDateness(Date dateness) {
		this.dateness = dateness;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "Cartecin [numcin=" + numcin + ", adresse=" + adresse + ", dateness=" + dateness + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}

}