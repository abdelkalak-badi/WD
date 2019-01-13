package com.WD.DAOimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.WD.DaoInterface.InterfaceDao;
import com.WD.entities.Center;

public class CentreDao  implements InterfaceDao{

	public CentreDao() {
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
	public List<Center> listerTous() {
		// TODO Auto-generated method stub
		List<Center> c =
		         entityManager.createQuery("select c from Center c").getResultList();
		return c;
	}

	@Override
	public List<Center> listerParNom(String nom) {
		List<Center> clients =entityManager.createQuery( "select c from Center c where c.noncenter like :pnom")
				.setParameter("pnom",nom).getResultList();

						 return clients;	
		// TODO Auto-generated method stub
		 
	}

	@Override
	public Object consulter(Object o, Object id) {
		// TODO Auto-generated method stub
		return entityManager.find(o.getClass(), id);
	}
	public Center FinList() {
		List<Center> list=new ArrayList<Center>();
		list=this.listerTous();
		if (list.size()>0) {
			return list.get(list.size()-1);
		} else {
			return null;
		}
		
	}

}
