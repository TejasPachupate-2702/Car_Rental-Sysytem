package com.Dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Engine;



public class EngineDao {

	  public static void addEnginedetails(Engine e)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(e);
			et.commit();
	  }

	  
	  
	  public static void deleteEngineById(int id)
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
//			String sql="delete from Car c where c.id=?1";
			et.begin();
			Engine e = em.find(Engine.class,id);
			em.remove(e);
			et.commit();
	  }
	  
	  
	  
	  public static void findAllEngine()
	  {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			String jpql="Select e from Engine e";
			
			et.begin();
			Query query = em.createQuery(jpql);
			List li = query.getResultList();
			System.out.println(li);
			et.commit();
		  
	  }
	  
}
