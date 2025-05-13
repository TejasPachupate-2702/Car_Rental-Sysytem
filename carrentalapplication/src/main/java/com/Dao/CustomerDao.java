package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Customer;


public class CustomerDao {

	public static void addCustomerdetails(Customer c)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(c);
			et.commit();
	  }
	
	

	 public static void findAllCustomers()
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String jpql="Select c from Customer c";
			
			et.begin();
			Query query = em.createQuery(jpql);
			List li = query.getResultList();
			System.out.println(li);
			et.commit();
		  
	  }
	  public static void deleteCustomerById()
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String jpql="delete from Customer c where c.cus_id=?1";
			et.begin();
			Query query = em.createQuery(jpql);
			query.setParameter(1, 103);
		    query.executeUpdate();
			
			et.commit();
	  }
	  public static void AllocateCar(int cid,int cusid)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String jpql="Update Customer  set cid_id=?1 where cus_id=?2";
			et.begin();
			Query query = em.createNativeQuery(jpql);
			query.setParameter(1, cid);
			query.setParameter(2, cusid);
		    query.executeUpdate();
			
			et.commit();
	  }

	  
}
