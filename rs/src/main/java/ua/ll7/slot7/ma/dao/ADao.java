package ua.ll7.slot7.ma.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alex Velichko
 *         09.06.14 : 17:39
 */
public abstract class ADao<T extends Serializable> {

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> clazz;

	public void create(final T data) {
		getCurrentSession().save(data);
	}

	public List<T> getAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public T findById(final long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public void update(final T data) {
		getCurrentSession().update(data);
	}

	public void delete(final T data) {
		getCurrentSession().delete(data);
	}

	// ===

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
