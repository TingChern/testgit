package model;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.hibernate.HibernateUtil;

@Entity
public class detail {
//	public static void main(String[] main) throws IOException {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();
//		Transaction tran = session.beginTransaction();
//
//		detail dtail = new detail();
//
//		String inFile = "C:\\Users\\Student\\Downloads\\image.jpg";
//		File f = new File(inFile);
//		FileInputStream fis = new FileInputStream(f);
//		int length = (int) f.length();
//
//		byte[] photo = new byte[length];
//		fis.read(photo);
//		fis.close();
//		dtail.setPhoto(photo);
//		dtail.setPhotoid(2);
//		session.save(dtail);
//		try {
//			tran.commit();
//		} finally {
//			HibernateUtil.closeSessionFactory();
//		}
//
//	}

	@Id
	private int photoid;
	private byte[] photo;

	public int getPhotoid() {
		return photoid;
	}

	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
