package com.WD.DaoInterface;

import java.util.List;

import javax.persistence.EntityManager;


import com.WD.Util.JpaUtil;
import com.WD.entities.Reclamation;

public interface InterfaceDao {
	EntityManager entityManager=JpaUtil.getEntityManager("projet_WD");
	 public   void ajouter(Object o);
	 public   void modifier(Object o);

	 public  Object consulter(Object o,Object id);
	 public List<?> listerTous() ;
	 public List<?> listerParNom(String nom) ;
	
	 

}
