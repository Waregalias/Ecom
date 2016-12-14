package storage;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class DaoJPA<T> implements Dao<T>  {

	@PersistenceContext(name="ecom")
	private EntityManager em;
	public DaoJPA() {
		System.out.println("=============== OUTPUT Source::JPA ===============");
		em = Persistence.createEntityManagerFactory("Ecom").createEntityManager();
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
	public void edit(T obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();

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