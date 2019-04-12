package com.app.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.utils.HbUtil;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sf;

	// private Session session;

	/*
	 * public void open() { session = HbUtil.getSessionFactory().openSession();
	 * }
	 * 
	 * public void close() { session.close(); }
	 */
	/*
	 * @Override public String registerCustomer(Customer c) {
	 * 
	 * Integer id=(Integer)sf.getCurrentSession().save(c); return
	 * "Customer reg successfully with ID "+id;
	 * 
	 * }
	 * 
	 */
	/*
	 * @Override public Customer getCustomer(String email) {
	 * 
	 * String hql="select c from Customer c where c.email = :email";
	 * 
	 * Customer customer= (Customer)sf.getCurrentSession().createQuery(hql)
	 * .setParameter("email", email) .uniqueResult();
	 * 
	 * return customer;
	 * 
	 * }
	 */

	public Integer insertNewCustomer(Customer c) {
		/*
		 * Transaction tx = session.beginTransaction(); session.save(c);
		 * tx.commit(); return c;
		 */

		return (Integer)sf.getCurrentSession().save(c);
	}

	public Customer fetchCustomerByEmailPass(String email, String password) {

		/*
		 * String hql= "select cust from Customer cust where email=:Email";
		 * Customer c=(Customer)
		 * session.createQuery(hql).setParameter("Email",email).uniqueResult();
		 * System.out.println(c); return c;
		 */

		Customer c = (Customer) sf.getCurrentSession()
				.createQuery("select c from Customer c where c.email=:a and c.password=:b").setParameter("a", email)
				.setParameter("b", password).uniqueResult();

		return c;
	}

}
