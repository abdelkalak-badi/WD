package com.WD.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the autre database table.
 * 
 */
@Entity
@NamedQuery(name="Autre.findAll", query="SELECT a FROM Autre a")
public class Autre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String nom;

	//bi-directional many-to-one association to Object
	@ManyToOne
	@JoinColumn(name="ido")
	private Object object;

	public Autre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "Autre [id=" + id + ", description=" + description + ", nom=" + nom + ", object=" + object + "]";
	}

}