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
import com.mmt.model.bean.Promotion;


public class PromotionDaoImplMMT implements PromotionDaoMMT {

	Configuration cfg=new Configuration();
	//insert function to add the promo details
	@Override
	public int insertPromotion(Promotion p) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		try{
			tx=session.beginTransaction();
			session.save(p);
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
	//delet function to delete the promo
	@Override
	public int deletePromotion(String promotionId) throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Promotion promotion=(Promotion)session.get(Promotion.class,promotionId);
			session.delete(promotion);
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
		//update function to update the promo details
	@Override
	public int updatePromotion(String promotionId, Promotion newp)
			throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Promotion oldPromotion=(Promotion)session.get(Promotion.class,promotionId);
			session.update(newp);
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
	public ArrayList<Promotion> displayPromotion() throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		ArrayList<Promotion> proList = new ArrayList<Promotion>();
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from Promotion");
			List<Promotion> promotionList=query.list();
			
			for(Promotion promotion:promotionList){
				proList.add(promotion);
			}
			tx.commit();
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
	public Promotion searchPromotion(String promotionId) throws SQLException, ClassNotFoundException, IOException {

		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		Promotion promotion=null;
		try{
			tx=session.beginTransaction();
			promotion=(Promotion)session.get(Promotion.class,promotionId);
			tx.commit();
		}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		}
		return promotion;
	}

	@Override
	public ArrayList<Promotion> displayPromotion(String promotionType)
			throws SQLException, ClassNotFoundException, IOException {
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		
		ArrayList<Promotion> proList = new ArrayList<Promotion>();
		try{
			tx=session.beginTransaction();
		
		Query query=session.createQuery("from Promotion where promotionType=:type");
		query.setString("type", promotionType);
		List<Promotion> promotionList=query.list();
		
		for(Promotion promotion:promotionList){
			proList.add(promotion);
		}
		tx.commit();
	
	}
	catch(Exception ex){
		tx.rollback();
	}
	finally{
		session.close();
		
	}
		return proList;
	}

}
