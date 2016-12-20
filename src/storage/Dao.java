package storage;

import java.util.List;

public interface Dao<T> {
	public T select(int id);
	public T categorie(int id);
	public List<T> selectAll();
	public List<T> categorieAll();
	public void edit(T obj);
	public void delete(T obj);
	public void insert (T obj);
}
