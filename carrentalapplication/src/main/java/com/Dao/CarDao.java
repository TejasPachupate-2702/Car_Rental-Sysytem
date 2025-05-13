package com.Dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Car;
import com.entity.Engine;


public class CarDao {
	
	  public static void addCardetails(Car c) {
		  
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(c);
			
			et.commit();
	  }
	  public static void deleteCarById()
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String sql="delete from Car c where c.id=?1";
			et.begin();
			Query query = em.createQuery(sql);
			query.setParameter(1, 103);
		    query.executeUpdate();
			
			et.commit();
	  }
	  public static void findByDate()
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String sql="Select c from Car c where c.registerDate=?1";
			et.begin();
			Query query = em.createQuery(sql);
			query.setParameter(1,LocalDate.of(2025, 05, 9));
		   List li = query.getResultList();
		   System.out.println(li);
			et.commit();
	  }
	  
	  public static void updateRegisterDate(int id)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String sql="Update Car c set c.registerDate=?1 where c.id=?2";
			
			et.begin();
			Query query = em.createQuery(sql);
			query.setParameter(1, LocalDate.now());
			query.setParameter(2, id);
			query.executeUpdate();
			et.commit();
			
	  }
	  
	  public static void allocateEngine(int eid,int id)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String sql="Update Car set e_id=:eid where id=:c_id";
			
			et.begin();
			Query query = em.createNativeQuery(sql,Car.class);
			
			query.setParameter("eid", eid);
			query.setParameter("c_id", id);
			query.executeUpdate();
			et.commit();
			
	  }
	   public static void deallocateEngine(int id)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String jpql="Update Car c set c.e=?1 where c.id=?2";
			
			et.begin();
			Query query = em.createQuery(jpql);
			query.setParameter(1, null);
			query.setParameter(2, id);
			query.executeUpdate();
			et.commit();
			
	  }
	  public static void findAllCar()
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String jpql="Select c from Car c";
			
			et.begin();
			Query query = em.createQuery(jpql);
			List li = query.getResultList();
			System.out.println(li);
			et.commit();
		  
	  }
	 
	  
	  
}
