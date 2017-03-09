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



import com.mmt.model.bean.Wallet;


public class WalletDaoImplMMT implements WalletDaoMMT {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	Session session=factory.openSession();
	Transaction tx=null;
	@Override
	public Wallet displayWallet(String userId) throws SQLException, ClassNotFoundException, IOException {
		
		
		//cfg.configure("hibernate.cfg.xml");
		//factory=cfg.buildSessionFactory();
		//session=factory.openSession();
		
		Wallet wallet=null;
		try{
			tx=session.beginTransaction();
			wallet=(Wallet)session.get(Wallet.class,userId);
			tx.commit();
		}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		}
		return wallet;
		
	}

	@Override
	public int updateWallet(String userId, Wallet newWallet) throws SQLException, ClassNotFoundException, IOException {
//		cfg.configure("hibernate.cfg.xml");
//		factory=cfg.buildSessionFactory();
//		session=factory.openSession();
		//Transaction tx=null;
		int rows=0;
		try{
			tx=session.beginTransaction();
			Wallet oldWallet=(Wallet)session.get(Wallet.class,userId);
			session.update(newWallet);
			tx.commit();
			//session.close();
			rows=1;
	}
	catch(Exception ex){
		tx.rollback();
		
	}
		session.close();
		return rows;
		
	}

	@Override
	public ArrayList<Wallet> displayWalletAll() throws SQLException, ClassNotFoundException, IOException {
		
//		cfg.configure("hibernate.cfg.xml");
//		factory=cfg.buildSessionFactory();
//		session=factory.openSession();
		//Transaction tx=null;
		ArrayList<Wallet> proList = new ArrayList<Wallet>();
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from Wallet");
			List<Wallet> walletList=query.list();
			
			for(Wallet wallet:walletList){
				proList.add(wallet);
			}
		}
		catch(Exception ex){
			tx.rollback();
		}
		finally{
			session.close();
			
		}
		
		return proList;
	}

	@Override
	public int insertWallet(Wallet wallet) throws SQLException, ClassNotFoundException, IOException {
//		cfg.configure("hibernate.cfg.xml");
//		factory=cfg.buildSessionFactory();
//		session=factory.openSession();
		//Transaction tx=null;
		int rows=0;
		try{
			tx=session.beginTransaction();
			session.save(wallet);
			tx.commit();
			System.out.println("Record Inserted");
			
			//session.close();
			rows=1;
			}
		catch(Exception ex){
			tx.rollback();
		}
		session.close();
		return rows;
	}

	@Override
	public int deleteWallet(Wallet wallet) throws SQLException, ClassNotFoundException, IOException {
//		cfg.configure("hibernate.cfg.xml");
//		factory=cfg.buildSessionFactory();
//		session=factory.openSession();
		//Transaction tx=null;
		int rows=0;
		try{
			tx=session.beginTransaction();
			session.delete(wallet);
			tx.commit();
			//session.close();
			rows=1;
	}
	catch(Exception ex){
		tx.rollback();
		
	}
		session.close();
		return rows;
	}
}
