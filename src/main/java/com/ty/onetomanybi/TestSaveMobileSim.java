package com.ty.onetomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setName("Oppo F21");
		mobile.setCost(22990);
		
		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("4G");
		sim1.setImei("IMEI345455");
		
		Sim sim2 = new Sim();
		sim2.setProvider("VI");
		sim2.setType("3G");
		sim2.setImei("IMEI067455");
		
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		
		mobile.setSim(sims);
		sim1.setMobile(mobile);
		sim2.setMobile(mobile);
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();

	}

}
