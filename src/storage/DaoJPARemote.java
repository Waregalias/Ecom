package storage;

import java.util.List;

import javax.ejb.Remote;

import service.LivrePOJO;
@Remote
public interface DaoJPARemote extends Dao<LivrePOJO> {
	public LivrePOJO select(int id);
	public List<LivrePOJO> selectAll();
	public void edit(LivrePOJO obj);
	public void delete(LivrePOJO obj);
	public void insert (LivrePOJO obj);

}