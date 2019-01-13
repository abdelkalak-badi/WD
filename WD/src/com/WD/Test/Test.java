package com.WD.Test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.WD.DAOimpl.AutreDao;
import com.WD.DAOimpl.CarteCinDao;
import com.WD.DAOimpl.CentreDao;
import com.WD.DAOimpl.ObjectDao;
import com.WD.DAOimpl.PersonneDao;
import com.WD.DAOimpl.ReclamationDao;
import com.WD.entities.Autre;
import com.WD.entities.Cartecin;
import com.WD.entities.Center;
import com.WD.entities.Object;
import com.WD.entities.Reclamation;
import com.WD.tab.tabCIN;
//import com.WD.entities.Center;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cartecin cartecin=new Cartecin();
		Object object=new Object();
		ObjectDao dao=new ObjectDao();
		object=(Object) dao.consulter(object, 25);
		CarteCinDao carteCinDao=new CarteCinDao();
		List<Cartecin> lists=object.getCartecins();
		for (Cartecin c:lists){
			System.out.println(c);
		}
	}

}
