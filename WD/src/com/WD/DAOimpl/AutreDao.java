package com.WD.DAOimpl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.WD.DaoInterface.InterfaceDao;
import com.WD.entities.Autre;

public class AutreDao  implements InterfaceDao{

	public AutreDao()  {
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
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(o);
	 	tx.commit();
		
	}


	public void supprimer(Autre o) {
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
	public List<Autre> listerTous() {
		List<Autre> clients =
		         entityManager.createQuery( 
		      "select c from Autre c ").getResultList();
				 return clients;
	}

	@Override
	public List<Autre> listerParNom(String nom) {
		List<Autre> clients =entityManager.createQuery( "select c from Autre c where c.nom like :pnom")
				.setParameter("pnom","%"+nom+"%").getResultList();

						 return clients;	 
	}

}
