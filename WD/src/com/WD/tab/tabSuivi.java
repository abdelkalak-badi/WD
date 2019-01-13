package com.WD.tab;

import java.util.Date;

public class tabSuivi {
	private String cinPersonne;

	private String nomPersonne;

	private String prenomPersonne;

	private String telePersonne;
	
	private String datereclamation;

	private String typereclamation;
	
	private String typeObject;

	private int IDObject;

	
	
	public tabSuivi() {
		super();
	}

	public tabSuivi(String cinPersonne, String nomPersonne, String prenomPersonne, String telePersonne,
			String datereclamation, String typereclamation, String typeObject, int iDObject) {
		super();
		this.cinPersonne = cinPersonne;
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.telePersonne = telePersonne;
		this.datereclamation = datereclamation;
		this.typereclamation = typereclamation;
		this.typeObject = typeObject;
		IDObject = iDObject;
	}

	public String getCinPersonne() {
		return cinPersonne;
	}

	public void setCinPersonne(String cinPersonne) {
		this.cinPersonne = cinPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public String getTelePersonne() {
		return telePersonne;
	}

	public void setTelePersonne(String telePersonne) {
		this.telePersonne = telePersonne;
	}

	public String getDatereclamation() {
		return datereclamation;
	}

	public void setDatereclamation(String datereclamation) {
		this.datereclamation = datereclamation;
	}

	public String getTypereclamation() {
		return typereclamation;
	}

	public void setTypereclamation(String typereclamation) {
		this.typereclamation = typereclamation;
	}

	public String getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(String typeObject) {
		this.typeObject = typeObject;
	}

	public int getIDObject() {
		return IDObject;
	}

	public void setIDObject(int iDObject) {
		IDObject = iDObject;
	}
	
	

}
