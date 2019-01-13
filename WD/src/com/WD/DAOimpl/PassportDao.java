package com.WD.DAOimpl;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.WD.DaoInterface.InterfaceDao;
import com.WD.entities.Cartecin;
import com.WD.entities.Passeport;

public class PassportDao  implements InterfaceDao {

	public PassportDao() {
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


	public void supprimer(Passeport o) {
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
	public List<Passeport> listerTous() {
		List<Passeport> clients =
		         entityManager.createQuery( 
		      "select c from Passeport c").getResultList();
				 return clients;
	}

	@Override
	public List<Passeport> listerParNom(String nom) {
	List<Passeport> clients =entityManager.createQuery( "select c from Passeport c where c.nom like :pnom")
				.setParameter("pnom","%"+nom+"%").getResultList();
	return clients;	
	}
	public List<Passeport> listerParPreNom(String nom) {
		List<Passeport> clients =entityManager.createQuery( "select c from Passeport c where c.prenom like :pnom")
					.setParameter("pnom","%"+nom+"%").getResultList();
		return clients;	
		}
	public List<Passeport> listerParCin(String nom) {
		List<Passeport> clients =entityManager.createQuery( "select c from Passeport c where c.cin like :pnom")
					.setParameter("pnom","%"+nom+"%").getResultList();
		return clients;	
		}
	public List<Passeport> listerParNumPasseport(String nom) {
		List<Passeport> clients =entityManager.createQuery( "select c from Passeport c where c.numerodupasseport like :pnom")
					.setParameter("pnom","%"+nom+"%").getResultList();
		return clients;	
		}


}
