package com.WD.DAOimpl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.WD.DaoInterface.InterfaceDao;
import com.WD.entities.Cartecin;

public class CarteCinDao  implements InterfaceDao{

	public CarteCinDao() {
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

	
	public void supprimer(Cartecin o) {
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
	public List<Cartecin> listerTous() {
		List<Cartecin> clients =
		         entityManager.createQuery( 
		      "select c from Cartecin c").getResultList();
				 return clients;
	}

	@Override
	public List<Cartecin> listerParNom(String nom) {
	List<Cartecin> clients =entityManager.createQuery( "select c from Cartecin c where c.nom like :pnom")
				.setParameter("pnom","%"+nom+"%").getResultList();
	return clients;	
	}
	public List<Cartecin> listerParPreNom(String nom) {
		List<Cartecin> clients =entityManager.createQuery( "select c from Cartecin c where c.prenom like :pnom")
					.setParameter("pnom","%"+nom+"%").getResultList();
		return clients;	
		}
	public List<Cartecin> listerParCin(String nom) {
		List<Cartecin> clients =entityManager.createQuery( "select c from Cartecin c where c.numcin like :pnom")
					.setParameter("pnom","%"+nom+"%").getResultList();
		return clients;	
		}
	public List<Cartecin> listerParIDO(com.WD.entities.Object nom) {
		List<Cartecin> clients =entityManager.createQuery( "select c from Cartecin c where c.object.ido like :pnom")
					.setParameter("pnom","%"+nom.getIdo()+"%").getResultList();
		return clients;	
		}

}
