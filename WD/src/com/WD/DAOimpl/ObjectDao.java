package com.WD.DAOimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.WD.DaoInterface.InterfaceDao;
import com.WD.entities.Center;
import com.WD.entities.Personne;

public class ObjectDao implements InterfaceDao {

	public ObjectDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouter(Object o) {
		// TODO Auto-generated method stub
		 EntityTransaction tx = entityManager.getTransaction();
		 	tx.begin();
		 	entityManager.persist(o);
		 	tx.commit();
	}

	@Override
	public void modifier(Object o) {
		// TODO Auto-generated method stub
		
	}


	public void supprimer(com.WD.entities.Object c) {
		// TODO Auto-generated method stub
		EntityTransaction tx = entityManager.getTransaction();
	    tx.begin();
	    c=entityManager.merge(c); // important
	    entityManager.remove(c);
	    tx.commit(); 
	}

	@Override
	public Object consulter(Object o, Object id) {
		// TODO Auto-generated method stub
		return entityManager.find(o.getClass(), id);
	}

	@Override
	public List<com.WD.entities.Object> listerTous() {
		// TODO Auto-generated method stub
		List<com.WD.entities.Object> o =
		         entityManager.createQuery("select c from Object c").getResultList();
		return o;
	}

	@Override
	public List<Object> listerParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	public com.WD.entities.Object FinList() {
		List<com.WD.entities.Object> list=new ArrayList<com.WD.entities.Object>();
		list=this.listerTous();
		if (list.size()>0) {
			return list.get(list.size()-1);
		} else {
			return null;
		}
		
	}
	
}
