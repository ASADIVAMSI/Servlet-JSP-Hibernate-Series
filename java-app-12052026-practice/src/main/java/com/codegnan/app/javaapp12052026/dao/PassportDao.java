package com.codegnan.app.javaapp12052026.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.codegnan.app.javaapp12052026.entity.Citizen;
import com.codegnan.app.javaapp12052026.entity.Passport;

import jakarta.persistence.Query;


public class PassportDao {
	public boolean save(Passport Passport) {
		boolean isPassportSaved = false;

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.persist(Passport);
			
			transaction.commit();
		
			isPassportSaved = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		session.close();
		
		return isPassportSaved;
	}
	
	
	public boolean updateDateOfBirth(int citizenId, String newDateOfBirth) {
		boolean isDateOfBirthUpdated = false;
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Citizen citizen = session.get(Citizen.class, citizenId);
		if (citizen != null) {
			citizen.setDateOfBirth(newDateOfBirth);
			
			session.merge(citizen);
		
			transaction.commit();
			isDateOfBirthUpdated = true;
		}		
		
		session.close();
		
		return isDateOfBirthUpdated;
	}
	
	public boolean remove(int citizenId) {
		boolean isEmployeeRemoved = false;
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Citizen citizen = session.get(Citizen.class, citizenId);
		if (citizen != null) {
			session.remove(citizen);
		
			transaction.commit();
			isEmployeeRemoved = true;
		}		
		
		session.close();
		
		return isEmployeeRemoved;
	}
	
	
	public List<Citizen> findCitizens(){
		List<Citizen> citizenList = new ArrayList<Citizen>();
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String hqlQuery = "FROM Citizen";
		Query query = session.createQuery(hqlQuery,Citizen.class);
		
		List<Citizen> listOfCitizens = query.getResultList();
		citizenList.addAll(listOfCitizens);
		
		transaction.commit();
		session.close();
		return citizenList;
	}
}