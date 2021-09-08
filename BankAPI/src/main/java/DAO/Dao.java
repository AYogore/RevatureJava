package DAO;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	T get(int id);
	
	String getAll();
	
	String getAll(int...i);
	
	void save(T t) throws SQLException;
	
	void update(T t, String[] params);
	
	void delete(T t);

}
