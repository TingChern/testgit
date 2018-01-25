package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.hibernate.HibernateUtil;

@Entity
@Table(name = "DEPT")
public class Dept {
//	public static void main(String[] args) {
//
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//
//		Session session = factory.getCurrentSession();
//		Transaction trx = session.beginTransaction();
//
//		Dept insert = new Dept();
//		insert.setDeptid(500);
//		insert.setDeptname("AAABBB");
//		session.save(insert);
//
//		try {
//			trx.commit();
//
//		} finally {
//			factory.close();
//			// HibernateUtil.closeSessionFactory();
//		}
//	}

	@Id
	@Column(name = "DEPTID")
	private int deptid;
	@Column(name = "DEPTNAME")
	private String deptname;

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
