package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Items;
import com.app.pojos.Pricing;
import com.app.utils.HbUtil;

@Repository
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SessionFactory sf;

	private Session session;

	public void open() {
		session = HbUtil.getSessionFactory().openSession();
	}

	public void close() {
		session.close();
	}

	
	
	@Override
	public List<String> fetchType()
	{
		
		String sql = "SELECT DISTINCT item.type FROM Items item";
		return  session.createQuery(sql).list();
		
	}
	
	
	
	@Override
	public List<Items> fetchCategoryByTypeCateg(String type, String category) {
		Criteria cr = session.createCriteria(Items.class);
		cr.add(Restrictions.eq("type", type));
		cr.add(Restrictions.eq("Category", category));
		return cr.list();

	}

	
	
	@Override
	public List<String> fetchCategoryByType(String type)
	{
		String hql="Select DISTINCT item.Category FROM Items item where type=?";
		Query q=session.createQuery(hql);
		q.setString(0, type);
		return q.list();
		
	}
	
	
	
	@Override
	public Items findItemById(int id)
	{
		Items obj = (Items) session.get(Items.class,id);
		obj.getPricingList().size();
		
		return obj;
	}

	
	@Override
	public Pricing fetchItemsPriceById(int id)
	{
		
		Pricing obj = (Pricing) session.get(Pricing.class,id);
		
		
		return obj;
		
	}
	
	
	
	
	
	
	
	
	
	
		

}
