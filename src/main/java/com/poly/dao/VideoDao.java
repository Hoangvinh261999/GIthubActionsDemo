package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.poly.entity.Video;  // Thay đổi từ User sang Video
import com.poly.ultils.JpaUtils;

public class VideoDao {  
    private EntityManager em = JpaUtils.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        em.close();
        super.finalize();
    }

    public Video create(Video entity) {  
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public Video update(Video entity) {  
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
        	e.printStackTrace();
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public Video remove(String id) {  
        Video entity = this.findById(id);
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    public Video findById(String id) {  
        Video entity = em.find(Video.class, id);  
        return entity;
    }
    public String findPoster(String id) {  
        Video entity = em.find(Video.class, id);  
        return entity.getPoster();
    }
    public Long findUserIdByVideoId(Long videoId) {
        String jpql = "SELECT userId FROM YourEntity WHERE videoId = :videoId";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("videoId", videoId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public List<Video> findAll() {  // Thay đổi từ User sang Video
        String jpql = "select o from Video o";  
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);  
        List<Video> list = query.getResultList();
        return list;
    }
}
