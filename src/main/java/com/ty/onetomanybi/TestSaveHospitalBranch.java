package com.ty.onetomanybi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = new Hospital();
		hospital.setName("KS Hospital");
		hospital.setGstNumber("KSH12345");
		hospital.setWebsite("ks.com");

		Branch branch1 = new Branch();
		branch1.setName("KS Marathahalli");
		branch1.setAddress("10th cross,Marathahalli Bridge,Marathahalli,Bangalore");
		branch1.setPhone(12121245);
		branch1.setHospital(hospital);

		Branch branch2 = new Branch();
		branch2.setName("KS Anna Nagar");
		branch2.setAddress("2nd Cross Anna nagar,Chennai");
		branch2.setPhone(313144455);
		branch2.setHospital(hospital);

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityTransaction.commit();

	}

}
