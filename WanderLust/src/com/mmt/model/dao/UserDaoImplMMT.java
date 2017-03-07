package com.mmt.model.dao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.mmt.model.bean.User;


public class UserDaoImplMMT implements UserDaoMMT {
	Configuration cfg=new Configuration();
	@Override
	public int insert(User user) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		try{
			tx=session.beginTransaction();
			session.save(user);
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

	@Override
	public User search(String uid) throws SQLException, ClassNotFoundException, IOException {
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		User user=null;
		try{
			tx=session.beginTransaction();
			user=(User)session.get(User.class,uid);
			tx.commit();
		}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		}
		return user;
	}

	@Override
	public int delete(String uid) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			User user=(User)session.get(User.class,uid);
			session.delete(user);
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
	public int update(String uid, User user) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			User oldUser=(User)session.get(User.class,uid);
			session.update(user);
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
	public List<User> displayAll() throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		List<User> userList=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from User");
			userList=query.list();
		}
		catch(Exception ex){
			tx.rollback();
		}
		finally{
			session.close();
			
		}
		
		return userList;
	}
}
