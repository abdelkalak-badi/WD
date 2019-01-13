package com.WD.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personne database table.
 * 
 */
@Entity
@NamedQuery(name="Personne.findAll", query="SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cin;

	private String nom;

	private String prenom;

	private String tele;

	//bi-directional many-to-one association to Reclamation
	@OneToMany(mappedBy="personne")
	private List<Reclamation> reclamations;

	public Personne() {
	}

	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
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

	public String getTele() {
		return this.tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public List<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public Reclamation addReclamation(Reclamation reclamation) {
		getReclamations().add(reclamation);
		reclamation.setPersonne(this);

		return reclamation;
	}

	public Reclamation removeReclamation(Reclamation reclamation) {
		getReclamations().remove(reclamation);
		reclamation.setPersonne(null);

		return reclamation;
	}

	@Override
	public String toString() {
		return "Cin : " + cin + " | Nom : " + nom + " | Prenom : " + prenom + " | N Telephone : " + tele ;
	}

}