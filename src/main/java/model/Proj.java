package model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

@Entity
public class Proj {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		Proj proj = new Proj();

		proj.setProjid(300);
		proj.setProjname("Window Shopping");

		session.save(proj);
		try {
			tran.commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	@Id
	private int projid;
	private String projname;

	public int getProjid() {
		return projid;
	}

	public void setProjid(int projid) {
		this.projid = projid;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

}
