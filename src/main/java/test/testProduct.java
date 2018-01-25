package test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Product;
import model.dao.ProductDAOHibernate;
import model.hibernate.HibernateUtil;

public class testProduct {

	public static void main(String[] args) {
		// select
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			ProductDAOHibernate ProductDAO = new ProductDAOHibernate(session);
			List<Product> result = ProductDAO.select();
			System.out.println("=======test_select========");

			System.out.println("select success:");

			for (Product product : result) {
				System.out.println(product);
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// HibernateUtil.closeSessionFactory();
		}
		// select_by_id

		Session session2 = factory.getCurrentSession();
		try {
			session2.beginTransaction();
			ProductDAOHibernate ProductDAO = new ProductDAOHibernate(session2);
			Product result = ProductDAO.select(16);
			System.out.println("=======select_by_id========");
			if (result != null) {
				// System.out.println("select by id success");
				System.out.println(result);
				session2.getTransaction().commit();

			} else {
				session2.getTransaction().rollback();
			}

		} catch (ObjectNotFoundException e) {
			session2.getTransaction().rollback();
			System.out.println("id does not exisist!");
		} catch (Exception e) {
			System.out.println("select by id failed");
			session2.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			// HibernateUtil.closeSessionFactory();
		}
		// insert

		Session session3 = factory.getCurrentSession();
		try {
			session3.beginTransaction();
			ProductDAOHibernate ProductDAO = new ProductDAOHibernate(session3);

			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
			Product bean = new Product(14, "test", 50.0, sFormat.parse("2017-01-17"), 123);
			Product result = ProductDAO.insert(bean);

			if (result != null) {
				System.out.println("==========insert===========");
				System.out.println("insert success:" + result);
			} else {
				System.out.println("==========insert===========");
				System.out.println("insert falied:" + result);
			}
			session3.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session3.getTransaction().rollback();
		} finally {
			// HibernateUtil.closeSessionFactory();
		}
		// update
		Session session4 = factory.getCurrentSession();
		try {
			session4.beginTransaction();
			ProductDAOHibernate ProductDAO = new ProductDAOHibernate(session4);

			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
			Product result = ProductDAO.update(14, "test", 60.0, sFormat.parse("2017-01-17"), 123);

			if (result != null) {
				System.out.println("==========update===========");
				System.out.println("update success:" + result);
			} else {
				System.out.println("==========update===========");
				System.out.println("update falied:" + result);
			}
			session4.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session4.getTransaction().rollback();
		} finally {
			// HibernateUtil.closeSessionFactory();
		}
		// delete
		Session session5 = factory.getCurrentSession();
		try {
			session5.beginTransaction();
			ProductDAOHibernate ProductDAO = new ProductDAOHibernate(session5);
			int status = ProductDAO.delete(13);
			System.out.println("=======delete_by_id========");
			if (status == 1) {
				List<Product> result = ProductDAO.select();
				System.out.println("success:");
				for (Product product : result) {
					System.out.println(product);
				}
			} else {
				System.out.println("falied");
			}
			session5.getTransaction().commit();

		} catch (Exception e) {
			session5.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
