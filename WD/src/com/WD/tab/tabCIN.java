package com.WD.tab;

import com.WD.entities.Center;
import com.WD.entities.Object;
import com.WD.entities.Personne;

public class tabCIN {
public String cin;
public String nom;
public String prenom;
public Personne personne;
public Center center;



public tabCIN() {
	super();
}
public tabCIN(String cin, String nom, String prenom, Personne personne, Center center) {
	super();
	this.cin = cin;
	this.nom = nom;
	this.prenom = prenom;
	this.personne = personne;
	this.center = center;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
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
@Override
public String toString() {
	return "tabCIN [cin=" + cin 
			+ ", nom=" + nom 
			+ ", prenom=" + prenom 
			+ ", personne=[" + personne.getCin() +","+personne.getNom()+","+personne.getPrenom()
			+ "], center="+ center.getNoncenter()
			+ "]";
}



}
