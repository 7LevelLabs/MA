package ua.ll7.slot7.ma.service;

import ua.ll7.slot7.ma.dao.IGDao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alex Velichko
 *         10.06.14 : 12:37
 */
public abstract class AService<T extends Serializable> implements IGService<T> {

	protected IGDao<T> dao;

	private Class<T> clazz;

	public final void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	//CRUD
	public void create(final T data) {
		dao.create(data);
	}

	public List<T> getAll() {
		return dao.getAll();
	}

	public T findById(final long id) {
		return dao.findById(id);
	}

	public void update(final T data) {
		dao.update(data);
	}

	public void delete(final T data) {
		dao.delete(data);
	}

	//BL
	public boolean exist(final long id) {
		return findById(id)!=null;
	}

	public long count() {
		return getAll().size();
	}

}
