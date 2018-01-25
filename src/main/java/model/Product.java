package model;

//import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

@Entity
public class Product {
//	public static void main(String[] args) {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();
//
//		Transaction tran = session.beginTransaction();
//		Product product = new Product();
//
//		product.setExpire(123);
//		product.setId(1);
//		try {
//			product.setMake(sFormat.parse("2017-01-16"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		product.setName("Coca Cola");
//		product.setPrice(20);
//
//		session.save(product);
//		try {
//			tran.commit();
//		} finally {
//			HibernateUtil.closeSessionFactory();
//		}
//
//	}

	@Id
	private int id;
	private String name;
	private double price;
	private java.util.Date make;
	private int expire;

	@Transient
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	public Product() {
	}

	public Product(int id, String name, double price, java.util.Date make, int expire) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setMake(make);
		this.setExpire(expire);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", make=" + make + ", expire=" + expire
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && (obj instanceof Product)) {
			Product temp = (Product) obj;
			if (this.id == temp.id) {
				return true;
			}
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public java.util.Date getMake() {
		return make;
	}

	public void setMake(java.util.Date make) {
		this.make = make;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

}
