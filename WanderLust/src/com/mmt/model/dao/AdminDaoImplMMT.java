package com.mmt.model.dao;

import java.io.IOException;
import java.sql.SQLException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.mmt.model.bean.Admin;


public class AdminDaoImplMMT implements AdminDao{
	Configuration cfg=new Configuration();
	
	//insert function for the admin board
	
	@Override
	public int insert(Admin admin) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		int row=0;
		try{
			tx=session.beginTransaction();
			session.save(admin);
			tx.commit();
			System.out.println("Record Inserted");
			row=1;
			session.close();
			return row;
			}
		catch(Exception ex){
			tx.rollback();
		}
		session.close();
		return row;
	}

		// search function for admin
	@Override
	public Admin search(String aid) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		Admin admin=null;
		try{
			tx=session.beginTransaction();
			admin=(Admin)session.get(Admin.class,aid);
			tx.commit();
		}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		}
		return admin;
	}
	//delete function to delete Admin
	@Override
	public int delete(String aid) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		
		try{
			tx=session.beginTransaction();
			Admin admin=(Admin)session.get(Admin.class,aid);
			session.delete(admin);
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

	//update function to update the admin details
		
	@Override
	public int update(String aid, Admin admin) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Admin oldAdmin=(Admin)session.get(Admin.class,aid);
			session.update(admin);
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
}
