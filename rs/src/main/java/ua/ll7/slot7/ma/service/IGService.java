package ua.ll7.slot7.ma.service;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:52
 */

import java.io.Serializable;
import java.util.List;

/**
 * Generic Service
 */
public interface IGService<T extends Serializable> {

	//CRUD
	public void create(final T data);

	public List<T> getAll();

	public T findById(final long id);

	public void update(final T data);

	public void delete(final T data);

	//BL
	public boolean exist(final long id);

	public long count();

}
