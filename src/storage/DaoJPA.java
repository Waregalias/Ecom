package storage;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import service.LivrePOJO;

@Stateless
@LocalBean
public class DaoJPA<T> implements Dao<T>, Serializable  {

	@PersistenceContext(name="ecom")
	private EntityManager em;
	public DaoJPA() {
		System.out.println("=============== OUTPUT Source::JPA ===============");
	}
	
	@Override
	public T select(int id) {
		return (T) em.createNamedQuery("produit.Select").setParameter("cle",id).getSingleResult();
	}

	@Override
	public List<T> selectAll() {
		return em.createNamedQuery("produit.All").getResultList();
	}
	
	@Override
	public T categorie(int id) {
		return (T) em.createNamedQuery("categorie.Select").setParameter("cle",id).getSingleResult();
	}
	
	@Override
	public List<T> categorieAll() {
		return em.createNamedQuery("categorie.All").getResultList();
	}

	@Override
	public void edit(T obj) {
		em.merge(obj);
	}

	@Override
	public void delete(T obj) {
		em.remove(obj);

	}

	@Override
	public void insert(T obj) {
		em.persist(obj);
	}

}