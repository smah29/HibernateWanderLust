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
import com.mmt.model.bean.Hotel;
import com.mmt.model.bean.HotelRoom;
public class HotelDaoImplMMT implements HotelDaoMMT {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	//Session session=factory.openSession();
	Transaction tx=null;
	//insert the hotel detail
	@Override
	public int insertHotel(Hotel h) throws SQLException, ClassNotFoundException, IOException {
		
		int rows = 0,rows2 = 0;
		//cfg.configure("hibernate.cfg.xml");
		//factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		try{
			tx=session.beginTransaction();
			session.save(h);
			tx.commit();
			rows=1;
			System.out.println("Record Inserted");
			//session.close();
			}
		catch(Exception ex){
			tx.rollback();
		}
		//session.close();
		ArrayList<HotelRoom> rl=h.getHotelRoom();
		for(HotelRoom room:rl)
		{			
		try{
				//session=factory.openSession();
				//tx=session.beginTransaction();
				session.save(room);
				tx.commit();
				rows2=1;
				//session.close();
			}
			catch(Exception ex){
				tx.rollback();
			}
		}
		session.close();
		if(rows>0 && rows2>0)
		{
			
			return rows;
		}
		else 
		{	
		return 0;
		}
		
	}

//delet the hotel details

	@Override
	public int deleteHotel(String hotelId) throws  SQLException, ClassNotFoundException, IOException {
		
		int rows=0,rows2=0;
		//cfg.configure("hibernate.cfg.xml");
		//factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		try{
			tx=session.beginTransaction();
			Hotel hotel=(Hotel)session.get(Hotel.class,hotelId);
			session.delete(hotel);
			tx.commit();
			//session.close();
			rows=1;
	}
	catch(Exception ex){
		tx.rollback();
	}
		//session.close();
		try{
			//session=factory.openSession();
			//tx=session.beginTransaction();
			Query query=session.createQuery("delete from HotelRoom where hotelChangedId=:id");
			query.setString("id", hotelId);
			rows2 = query.executeUpdate();
			tx.commit();
			//session.close();
			
	}
	catch(Exception ex){
		tx.rollback();
		//session.close();
	}
		session.close();
		if(rows>0 && rows2>0)
		{
			return rows;
		}
		else 
			{
			
			return 0;}
	}
	
	//update function to update hotel detials

	@Override
	public int updateHotel(String hotelId, Hotel newhotel) throws  SQLException, ClassNotFoundException, IOException {
		
		int rows=0,rows2 = 0;
		//cfg.configure("hibernate.cfg.xml");
		//factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		try{
			tx=session.beginTransaction();
			//Hotel oldHotel=(Hotel)session.get(Hotel.class,hotelId);
			session.update(newhotel);
			tx.commit();
			rows=1;
			//session.close();
			
	}
	catch(Exception ex){
		tx.rollback();
	}
		//session.close();
		ArrayList<HotelRoom> rl=newhotel.getHotelRoom();
		
		
		for(HotelRoom room:rl)
		{
			try{
				//session=factory.openSession();
				//tx=session.beginTransaction();
				Query query = session.createQuery("update hotelroom set hotelChangedId=:id, hotelRoomNo=:num, hotelRoomType=:type, hotelRoomPrice=:price,hotelRoomStatus=:status where hotelChangedId=:hotelId");
				query.setParameter("id",room.getHotelChangedId());
				query.setParameter("num",room.getHotelRoomNo());
				query.setParameter("type",room.getHotelRoomType());
				query.setParameter("price",room.getHotelRoomPrice());
				query.setParameter("status",room.getHotelRoomStatus());
				query.setParameter("hotelId",hotelId);
				tx.commit();
				rows2 = query.executeUpdate();
				//session.close();
			}
			catch(Exception ex){
				tx.rollback();
			}
		}
		session.close();
		if(rows>0 && rows2>0)
		{
			
			return rows;
		}
		else 
		{	
		return 0;
		}
		
	}

	// display function to display hotel list
	@Override
	public ArrayList<Hotel> displayHotel() throws  SQLException, ClassNotFoundException, IOException {
		ArrayList<Hotel> hotList=null;
		ArrayList<HotelRoom> hotRoomList=null;
		//cfg.configure("hibernate.cfg.xml");
		//factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Hotel");
			List<Hotel> hotelList=query.list();
			for(Hotel hotel1:hotelList){
				String hotelId=hotel1.getHotelId();
					Query query2=session.createQuery("from HotelRoom where hotelChangedId=:id");
					query2.setString("id", hotelId);
					List<HotelRoom> hotelRoomList=query2.list();
					
						for(HotelRoom hotelRoom:hotelRoomList){
							hotRoomList.add(hotelRoom);
						}
					hotel1.setHotelRoom(hotRoomList);
				hotList.add(hotel1);
			}
			tx.commit();	
		}
		catch(Exception ex){
			tx.rollback();
		}
		session.close();
		return hotList;
	}

	@Override
	public Hotel searchHotel(String hotelId) throws  SQLException, ClassNotFoundException, IOException {
		ArrayList<HotelRoom> hotRoomList=null;
		//cfg.configure("hibernate.cfg.xml");
		//factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		tx=session.beginTransaction();
		Hotel hotel=null;
		try{
			hotel=(Hotel)session.get(Hotel.class,hotelId);
				
					Query query2=session.createQuery("from HotelRoom where hotelChangedId=:id");
					query2.setString("id", hotelId);
					List<HotelRoom> hotelRoomList=query2.list();
						for(HotelRoom hotelRoom:hotelRoomList){
							hotRoomList.add(hotelRoom);
						}
				hotel.setHotelRoom(hotRoomList);	
				tx.commit();
			
		}
		catch(Exception ex){
			tx.rollback();
		}
		session.close();
		return hotel;
	}



	@Override
	public ArrayList<Hotel> searchHotel1(String hotelLocation) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Hotel> hotList=null;
		ArrayList<HotelRoom> hotRoomList=null;
		//cfg.configure("hibernate.cfg.xml");
		//factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		tx=session.beginTransaction();
		try{
			Query query=session.createQuery("from Hotel where hotelLocation=:place");
			query.setString("place", hotelLocation);
			List<Hotel> hotelList=query.list();
			for(Hotel hotel1:hotelList){
				String hotelId=hotel1.getHotelId();
					Query query2=session.createQuery("from HotelRoom where hotelChangedId=:id");
					query2.setString("id", hotelId);
					List<HotelRoom> hotelRoomList=query2.list();
					
						for(HotelRoom hotelRoom:hotelRoomList){
							hotRoomList.add(hotelRoom);
						}
					hotel1.setHotelRoom(hotRoomList);
				hotList.add(hotel1);
			}
			tx.commit();	
		}
		catch(Exception ex){
			tx.rollback();
		}
		session.close();
		return hotList;
	}
}
