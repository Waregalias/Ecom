package oreilly;

import java.util.List;

import service.LivrePOJO;
import storage.Dao;

public interface DaoJPARemote extends Dao<LivrePOJO> {
	public LivrePOJO select(int id);
	public List<LivrePOJO> selectAll();
	public void edit(LivrePOJO obj);
	public void delete(LivrePOJO obj);
	public void insert (LivrePOJO obj);

}