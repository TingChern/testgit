package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Emp {
//	public static void main(String[] args) {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//
//		Session session = factory.getCurrentSession();
//		Transaction tran = session.beginTransaction();
//
//		Emp emp = new Emp();
//		emp.setEmpid(1234);// 因id為流水號，
//		emp.setEmpname("Ting");
//		emp.setSalary(1000000);
//		emp.setSex("F");
//		emp.setPhoto(null);
//		emp.setDeptid(10);
//
//		session.save(emp);
//
//		try {
//			tran.commit();
//		} finally {
//			HibernateUtil.closeSessionFactory();
//		}
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	private String empname;
	private int salary;
	private String sex;
	private byte[] photo;
	private int deptid;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

}
