package com.mmt.model.dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.mmt.model.bean.Flight;

public class FlightDaoImplMMT implements FlightDaoMMT {
	Configuration cfg=new Configuration();
	
	//insert function for the flight details
	@Override
	public int insertFlight(Flight flight) throws ClassNotFoundException, SQLException, IOException {	
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		try{
			tx=session.beginTransaction();
			session.save(flight);
			tx.commit();
			System.out.println("Record Inserted");
			
			session.close();
			return 1;
			}
		catch(Exception ex){
			tx.rollback();
		}
		session.close();
		return 0;
	}

		//delete function to delete flight
	@Override
	public int deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Flight flight=(Flight)session.get(Flight.class,flightId);
			session.delete(flight);
			tx.commit();
			session.close();
			return 1;
	}
	catch(Exception ex){
		tx.rollback();
		session.close();
	}
		return 0;
	}

	//function to update flight
	@Override
	public int updateFlight(String flightId, Flight newflight) throws ClassNotFoundException, SQLException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Flight oldFlight=(Flight)session.get(Flight.class,flightId);
			session.update(newflight);
			tx.commit();
			session.close();
			return 1;
	}
	catch(Exception ex){
		tx.rollback();
		session.close();
	}
		return 0;
	}

	
		//search function to search flight
	@Override
	public Flight searchFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		Flight flight=null;
		try{
			tx=session.beginTransaction();
			flight=(Flight)session.get(Flight.class,flightId);
			tx.commit();
		}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		}
		return flight;
	}
	
	//display function to display all details of flight	
	
	@Override
	public ArrayList<Flight> displayFlight() throws ClassNotFoundException, SQLException, IOException {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		ArrayList<Flight> F =new ArrayList<Flight>();
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from Flight");
			List<Flight> flightList=query.list();
			
			for(Flight flight:flightList){
				F.add(flight);
			}
		}
		catch(Exception ex){
			tx.rollback();
		}
		finally{
			session.close();	
		}
		return F;
	}

	//search flight on the basis of source and destination
	
	@Override
	public ArrayList<Flight> searchFlight(String flightSource, String flightDestination)
			throws ClassNotFoundException, SQLException, IOException {
		
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		ArrayList<Flight> F =new ArrayList<Flight>();
		try{
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from Flight where flightSource=:source and flightDestination=:dest");
		query.setString("source", flightSource);
		query.setString("dest", flightDestination);
		List<Flight> flightList=query.list();
		
		for(Flight flight:flightList){
			F.add(flight);
		}
		tx.commit();
	
	}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		
	}
		return F;
	}
}
