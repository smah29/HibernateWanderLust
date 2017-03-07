package com.mmt.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmt.model.bean.FlightBooking;
import com.mmt.model.bean.HotelBooking;

public class FlightBookingImpMMT implements FlightBookingDaoMMT {
	Configuration cfg=new Configuration();
	//display the details of flightbooking
	@Override
	public ArrayList<FlightBooking> displayFlightBooking() throws ClassNotFoundException, SQLException, IOException {
		{
			
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory=cfg.buildSessionFactory();
			Session session=factory.openSession();
			Transaction tx=null;
			ArrayList<FlightBooking> FB = new ArrayList<FlightBooking>();
			try{
				tx=session.beginTransaction();
				Query query=session.createQuery("from FlightBooking");
				List<FlightBooking> flightBookingList=query.list();
				
				for(FlightBooking flightBooking:flightBookingList){
					FB.add(flightBooking);
				}
			}
			catch(Exception ex){
				tx.rollback();
			}
			finally{
				session.close();
		}
			return FB;
		}
	}

	@Override
	public ArrayList<FlightBooking> searchFlightBooking(String userId)
			throws ClassNotFoundException, SQLException, IOException {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		ArrayList<FlightBooking> fb =new ArrayList<FlightBooking>();
		try{
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from FlightBooking where userId=:id");
		query.setString("id", userId);
		List<FlightBooking> flightBookingList=query.list();
		
		for(FlightBooking flightBooking:flightBookingList){
			fb.add(flightBooking);
		}
		tx.commit();
	
	}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		
	}
		return fb;
	}
	// insert function for the flight booking 
	@Override
	public int insertFlightBooking(FlightBooking fb) throws ClassNotFoundException, SQLException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		try{
			tx=session.beginTransaction();
			session.save(fb);
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

	// delete function for the flight booking
	@Override
	public int deleteFlightBooking(String flightBookingId) throws ClassNotFoundException, SQLException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			FlightBooking flightBooking=(FlightBooking)session.get(FlightBooking.class,flightBookingId);
			session.delete(flightBooking);
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

	@Override
	public ArrayList<FlightBooking> displayFlightBooking1() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
