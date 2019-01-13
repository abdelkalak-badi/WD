package com.WD.DAOimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.WD.DaoInterface.InterfaceDao;
import com.WD.entities.Center;
import com.WD.entities.Personne;

public class PersonneDao  implements InterfaceDao{

	public PersonneDao() {
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


	public void supprimer(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object consulter(Object o, Object id) {
		// TODO Auto-generated method stub
		return entityManager.find(o.getClass(), id);
	}

	@Override
	public List<Personne> listerTous() {
		// TODO Auto-generated method stub
		List<Personne> c =
		         entityManager.createQuery("select c from Personne c").getResultList();
		return c;
	}

	@Override
	public List<Personne> listerParNom(String nom) {
	List<Personne> clients =entityManager.createQuery( 
			"select c from Personne c where c.cin like :pnom")
	.setParameter("pnom","%"+nom+"%").getResultList();

	 return clients;	
	}
	public Personne FinList() {
		List<Personne> list=new ArrayList<Personne>();
		list=this.listerTous();
		if (list.size()>0) {
			return list.get(list.size()-1);
		} else {
			return null;
		}
		
	}

}
