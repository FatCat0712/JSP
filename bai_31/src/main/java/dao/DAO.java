package dao;

import java.util.ArrayList;

public interface DAO <T>{
	public ArrayList<T> selectAll();
	public T selectById(String object);
	public boolean insert(T object);
	public boolean insertAll(ArrayList<T> object);
	public boolean delete(T object);
	public boolean update(T object);
	public boolean deleteAll(ArrayList<T> object);
	
}
