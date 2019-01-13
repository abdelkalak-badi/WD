package com.WD.entities;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DadeP extends Date{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getYear()+"-"+this.getMonth()+"-"+this.getDate();
	}
}
