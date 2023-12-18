package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.User;
import com.poly.ultils.JpaUtils;


public class UserDao {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	public User create(User entity) {
		try {
				em.getTransaction().begin();
				em.persist(entity);
				em.getTransaction().commit();
				return entity;
		} catch (Exception e) {
				em.getTransaction().rollback();
				throw new RuntimeException();
		}
	
	};

	public User update(User entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
	} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
	}
	};

	public User remove(String id) {
		User entity=this.findById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
	} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
	}
	};
	
	public User findById(String id) {
		User entity= em.find(User.class, id);
		return entity;
	};
	public List<User> findAll(){
		String jpql="select o from User o";
		TypedQuery<User> query=em.createQuery(jpql,User.class);
		List<User> list= query.getResultList();
		return list;
		
	};
	
}
