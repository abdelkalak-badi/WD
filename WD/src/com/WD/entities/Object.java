package com.WD.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the object database table.
 * 
 */
@Entity
@NamedQuery(name="Object.findAll", query="SELECT o FROM Object o")
public class Object implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int ido;

	private String typeobject;

	//bi-directional many-to-one association to Autre
	@OneToMany(mappedBy="object")
	private List<Autre> autres;

	//bi-directional many-to-one association to Cartecin
	@OneToMany(mappedBy="object")
	private List<Cartecin> cartecins;

	//bi-directional many-to-one association to Passeport
	@OneToMany(mappedBy="object")
	private List<Passeport> passeports;

	//bi-directional many-to-one association to Reclamation
	@OneToMany(mappedBy="object")
	private List<Reclamation> reclamations;

	public Object() {
	}

	public int getIdo() {
		return this.ido;
	}

	public void setIdo(int ido) {
		this.ido = ido;
	}

	public String getTypeobject() {
		return this.typeobject;
	}

	public void setTypeobject(String typeobject) {
		this.typeobject = typeobject;
	}

	public List<Autre> getAutres() {
		return this.autres;
	}

	public void setAutres(List<Autre> autres) {
		this.autres = autres;
	}

	public Autre addAutre(Autre autre) {
		getAutres().add(autre);
		autre.setObject(this);

		return autre;
	}

	public Autre removeAutre(Autre autre) {
		getAutres().remove(autre);
		autre.setObject(null);

		return autre;
	}

	public List<Cartecin> getCartecins() {
		return this.cartecins;
	}

	public void setCartecins(List<Cartecin> cartecins) {
		this.cartecins = cartecins;
	}

	public Cartecin addCartecin(Cartecin cartecin) {
		getCartecins().add(cartecin);
		cartecin.setObject(this);

		return cartecin;
	}

	public Cartecin removeCartecin(Cartecin cartecin) {
		getCartecins().remove(cartecin);
		cartecin.setObject(null);

		return cartecin;
	}

	public List<Passeport> getPasseports() {
		return this.passeports;
	}

	public void setPasseports(List<Passeport> passeports) {
		this.passeports = passeports;
	}

	public Passeport addPasseport(Passeport passeport) {
		getPasseports().add(passeport);
		passeport.setObject(this);

		return passeport;
	}

	public Passeport removePasseport(Passeport passeport) {
		getPasseports().remove(passeport);
		passeport.setObject(null);

		return passeport;
	}

	public List<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public Reclamation addReclamation(Reclamation reclamation) {
		getReclamations().add(reclamation);
		reclamation.setObject(this);

		return reclamation;
	}

	public Reclamation removeReclamation(Reclamation reclamation) {
		getReclamations().remove(reclamation);
		reclamation.setObject(null);

		return reclamation;
	}

	@Override
	public String toString() {
		return typeobject;
	}

}