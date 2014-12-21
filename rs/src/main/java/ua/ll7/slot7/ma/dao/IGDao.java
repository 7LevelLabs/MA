package ua.ll7.slot7.ma.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 15:15
 */

/**
 * Generic DAO
 */
public interface IGDao<T extends Serializable> {

	public void create(final T data);

	public List<T> getAll();

	public T findById(final long id);

	public void update(final T data);

	public void delete(final T data);
}
