package spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.model.Userlogin;


@Repository
public class UserloginDaoImp implements UserloginDao{
	Session  session;
	@Autowired
	   private SessionFactory sessionFactory;
	
	
	@Override
	   public List<Userlogin> list() {
	      try {
			  session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
			    session = sessionFactory.openSession();
			}
		
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Userlogin> cq = cb.createQuery(Userlogin.class);
	      Root<Userlogin> root = cq.from(Userlogin.class);
	      cq.select(root);
	      Query<Userlogin> query = session.createQuery(cq);
	      return query.getResultList();
	   }
	
	@Override
	public String save(Userlogin userlogin) {
		String em = null;
		try {
			sessionFactory.getCurrentSession().save(userlogin);
			em=userlogin.getEmail();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			em=e.getMessage().toString();
		}
	      return em;
	}

	@Override
	public Userlogin get(long userid) {
		 return sessionFactory.getCurrentSession().get(Userlogin.class, userid);
	}

	@Override
	public void update(long userid, Userlogin userlogin) {
		Session session = sessionFactory.getCurrentSession();
	      Userlogin book2 = session.byId(Userlogin.class).load(userid);
	      book2.setEmail(userlogin.getEmail());
	      book2.setPassword(userlogin.getPassword());
	      session.flush();
		
	}

	@Override
	public void delete(long userid) {
		Session session = sessionFactory.getCurrentSession();
	      Userlogin book = session.byId(Userlogin.class).load(userid);
	      session.delete(book);
	}

	@Override
	public Userlogin checkuser(String email) {
		try {
			  session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
			    session = sessionFactory.openSession();
			}
		
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Userlogin> cq = cb.createQuery(Userlogin.class);
	      Root<Userlogin> root = cq.from(Userlogin.class);
	      cq.select(root).where(cb.equal(root.get("email"), email));
	      Query<Userlogin> query = session.createQuery(cq);
	      return query.uniqueResult();
	
	}

}
