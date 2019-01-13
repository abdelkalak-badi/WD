package com.WD.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reclamation database table.
 * 
 */
@Entity
@NamedQuery(name="Reclamation.findAll", query="SELECT r FROM Reclamation r")
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int idreclamation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datereclamation;

	private String typereclamation;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="cin")
	private Personne personne;

	//bi-directional many-to-one association to Object
	@ManyToOne
	@JoinColumn(name="ido")
	private Object object;

	//bi-directional many-to-one association to Center
	@ManyToOne
	@JoinColumn(name="idCenter")
	private Center center;

	public Reclamation() {
	}

	public int getIdreclamation() {
		return this.idreclamation;
	}

	public void setIdreclamation(int idreclamation) {
		this.idreclamation = idreclamation;
	}

	public Date getDatereclamation() {
		return this.datereclamation;
	}

	public void setDatereclamation(Date datereclamation) {
		this.datereclamation = datereclamation;
	}

	public String getTypereclamation() {
		return this.typereclamation;
	}

	public void setTypereclamation(String typereclamation) {
		this.typereclamation = typereclamation;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Center getCenter() {
		return this.center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Reclamation [idreclamation=" + idreclamation + ", datereclamation=" + datereclamation
				+ ", typereclamation=" + typereclamation + ", personne=" + personne + ", object=" + object + ", center="
				+ center + "]";
	}

}