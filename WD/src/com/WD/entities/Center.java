package com.WD.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the center database table.
 * 
 */
@Entity
@NamedQuery(name="Center.findAll", query="SELECT c FROM Center c")
public class Center implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int idcenter;

	@Column(name="mot_de_passe")
	private String motDePasse;

	private String noncenter;

	private String ville;

	//bi-directional many-to-one association to Reclamation
	@OneToMany(mappedBy="center")
	private List<Reclamation> reclamations;

	public Center() {
	}

	public int getIdcenter() {
		return this.idcenter;
	}

	public void setIdcenter(int idcenter) {
		this.idcenter = idcenter;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNoncenter() {
		return this.noncenter;
	}

	public void setNoncenter(String noncenter) {
		this.noncenter = noncenter;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public Reclamation addReclamation(Reclamation reclamation) {
		getReclamations().add(reclamation);
		reclamation.setCenter(this);

		return reclamation;
	}

	public Reclamation removeReclamation(Reclamation reclamation) {
		getReclamations().remove(reclamation);
		reclamation.setCenter(null);

		return reclamation;
	}

	@Override
	public String toString() {
		return noncenter+" | "+ville;
	}
	

}