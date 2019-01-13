package com.WD.DAOimpl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.WD.DaoInterface.InterfaceDao;
import com.WD.entities.Personne;
import com.WD.entities.Reclamation;

public class ReclamationDao implements InterfaceDao {

	public ReclamationDao() {
		// TODO Auto-generated constructor stub
	}
	public void ajouter(Object o) {}

	public void ajouter(Reclamation r) {
		// TODO Auto-generated method stub
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 EntityTransaction tx = entityManager.getTransaction();
		 	tx.begin();
		 	entityManager.persist(r);
		 	tx.commit();
		 	System.out.println("ffffffffffffffffffffffffffffffffffffff");
	}

	@Override
	public void modifier(Object o) {
		// TODO Auto-generated method stub

	}


	public void supprimer(Reclamation o) {
		// TODO Auto-generated method stub
		EntityTransaction tx = entityManager.getTransaction();
	    tx.begin();
	    o=entityManager.merge(o); // important
	    entityManager.remove(o);
	    tx.commit();  
	}

	@Override
	public Object consulter(Object o, Object id) {
		// TODO Auto-generated method stub
		return entityManager.find(o.getClass(), id);
	}

	@Override
	public List<Reclamation> listerTous() {
		// TODO Auto-generated method stub
		List<Reclamation> c =
		         entityManager.createQuery("select c from Reclamation c").getResultList();
		return c;
	}

	@Override
	public List<Object> listerParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
