package com.mmt.model.dao;

import java.io.IOException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.mmt.model.bean.HotelBooking;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelBookingDaoImplMMT implements HotelBookingDaoMMT {
	Configuration cfg=new Configuration();

	//Insert function to add hotel details
	@Override
	public int insertHotelBooking(HotelBooking hb) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		try{
			tx=session.beginTransaction();
			session.save(hb);
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

	//search function to search hotel
	@Override
	public ArrayList<HotelBooking> searchHotelBooking(String userId) throws SQLException, ClassNotFoundException, IOException {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		ArrayList<HotelBooking> hb =new ArrayList<HotelBooking>();
		try{
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from HotelBooking where userId=:id");
		query.setString("id", userId);
		List<HotelBooking> hotelBookingList=query.list();
		
		for(HotelBooking hotelBooking:hotelBookingList){
			hb.add(hotelBooking);
		}
		tx.commit();
	
	}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		
	}
		return hb;
	}
	
	//function to cancle the hotel booking
	@Override
	public int cancelHotelBooking(String hotelBookingId) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			HotelBooking hotelBooking=(HotelBooking)session.get(HotelBooking.class,hotelBookingId);
			session.delete(hotelBooking);
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

	// function to display the hotel list
	@Override
	public ArrayList<HotelBooking> display() throws SQLException, ClassNotFoundException, IOException {
		
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		ArrayList<HotelBooking> hb =new ArrayList<HotelBooking>();
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from HotelBooking");
			List<HotelBooking> hotelBookingList=query.list();
			
			for(HotelBooking hotelBooking:hotelBookingList){
				hb.add(hotelBooking);
			}
		}
		catch(Exception ex){
			tx.rollback();
		}
		finally{
			session.close();
	}
		return hb;

}
}