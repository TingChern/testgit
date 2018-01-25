package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Product;

public class ProductDAOHibernate {

	private Session session = null;

	public ProductDAOHibernate(Session session) {
		this.session = session;
	}

	private Session getSession() {
		return session;
	}

	public Product select(int id) {

		return this.getSession().get(Product.class, id);
	}

	public List<Product> select() {
		Query<Product> query = this.getSession().createQuery("from Product", Product.class);
		return query.list();
	}

	public Product insert(Product bean) {
		Product temp = this.getSession().get(Product.class, bean.getId());
		if (temp == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	public Product update(int id, String name, double price, java.util.Date make, int expire) {
		Product result = (Product) this.getSession().get(Product.class, id);
		if (result != null) {
			result.setName(name);
			result.setPrice(price);
			result.setMake(make);
			result.setExpire(expire);
		}
		return result;
	}

	public int delete(int id) {
		Product bean = (Product) this.getSession().get(Product.class, id);
		if (bean != null) {
			this.getSession().delete(bean);
			return 1;
		}
		return 0;
	}
}
