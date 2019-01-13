package com.WD.tab;

import com.WD.entities.Center;
import com.WD.entities.Personne;

public class tabAutre {
	public String nom;
	public String description;
	public Personne personne;
	public Center center;
	
	public tabAutre() {
		super();
	}

	public tabAutre(String nom, String description, Personne personne, Center center) {
		super();
		this.nom = nom;
		this.description = description;
		this.personne = personne;
		this.center = center;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	
	
}
