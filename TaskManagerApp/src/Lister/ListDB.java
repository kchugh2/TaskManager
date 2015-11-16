package Lister;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;




import model.Listcustomer;
import model.Status;
import model.Todolist;

public class ListDB {
	
	public static boolean createNewUser(String username, String pwd) {
		boolean isSuccess = false;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		Listcustomer user = new Listcustomer();
		user.setCustpassword(pwd);
		user.setCustname(username);

		trans.begin();

		try {
			em.persist(user);
			trans.commit();
			isSuccess = true;
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}

		return isSuccess;
	}
	public static boolean addToList(Todolist cartItem) {
		boolean isSuccess = false;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		
		trans.begin();

		try {
			em.persist(cartItem);
			trans.commit();
			isSuccess = true;
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}

		return isSuccess;
	}

	public static ArrayList<Listcustomer> PullAllOrders() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Listcustomer> fd = null;

		try {
			String sql = "select t from Listcustomer t ";
			TypedQuery<Listcustomer> results = em.createQuery(sql,
					Listcustomer.class);

			fd = results.getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return new ArrayList<Listcustomer>(fd);
	}

	public static Listcustomer getProfile(String username, String pwd) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Listcustomer usr = null;

		try {
			String sql = "select u from Listcustomer u where u.custname = :username and u.custpassword = :pwd";
			TypedQuery<Listcustomer> q = em
					.createQuery(sql, Listcustomer.class);
			q.setParameter("username", username);
			q.setParameter("pwd", pwd);

			usr = q.getSingleResult();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return usr;
	}

	public static ArrayList<Todolist> PullList(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Todolist> fd = null;

		try {
			String sql = "select t from Todolist t where t.taskuser = :username";
			TypedQuery<Todolist> results = em.createQuery(sql, Todolist.class);
			results.setParameter("username", username);
			fd = results.getResultList();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return new ArrayList<Todolist>(fd);
	}

	public static String getStatus(BigInteger bigInteger) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Status stat = null;

		try {
			String sql = "select u from Status u where u.statusid = :ID";
			TypedQuery<Status> q = em.createQuery(sql, Status.class);
			q.setParameter("ID", bigInteger);

			stat = q.getSingleResult();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

		return stat.getStatusdescription();
	}

	public static void taskComplete(long ID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		long id = ID;
		Todolist task = em.find(Todolist.class, id);
		Date day = new Date();
		try {
			em.getTransaction().begin();
			task.setCompdate(day);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

	}
	public static void statusUpdate(long ID, int stat) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		long id = ID;
		Todolist task = em.find(Todolist.class, id);
		
		try {
			em.getTransaction().begin();
			int i = stat;
			BigDecimal bd = new BigDecimal(String.valueOf(i));
			task.setStatusid(bd);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}

	}
}
