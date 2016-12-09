package storage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoJPA<T> implements Dao<T>  {

	@PersistenceContext(name="categorie")
	private EntityManager cat;
	public DaoJPA() {
		System.out.println("=============== OUTPUT Source::JPA ===============");
	}
	
	@Override
	public T select(int id) { 
		return (T) cat.createNamedQuery("select").setParameter("key",id).getSingleResult();
	}

	@Override
	public List<T> selectAll() {
		return cat.createNamedQuery("all").getResultList();
	}

	@Override
	public void edit(T obj) {
		//em.getTransaction().begin();
		cat.merge(obj);
		//em.getTransaction().commit();

	}

	@Override
	public void delete(T obj) {
		cat.remove(obj);

	}

	@Override
	public void insert(T obj) {
		cat.persist(obj);
	}

}