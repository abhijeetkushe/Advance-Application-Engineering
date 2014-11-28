/**
 * 
 */
package org.stable.sdk.DAO.common;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.stable.sdk.model.common.IStableModel;

/**
 * @author amuthanarulraj
 * 
 */
public class AbstractHibernateDao<T extends IStableModel, PK extends Serializable>
		extends HibernateDaoSupport implements IDao<T, PK> {

	private Class<T> type;

	public AbstractHibernateDao(Class<T> type) {
		this.type = type;
	}

	public void create(T o) {
		getHibernateTemplate().save(o);
	}
	
	
	@SuppressWarnings("unchecked")
	public T read(PK id) {
		return (T) getHibernateTemplate().get(type, id);
	}

	public void update(T o) {
		getHibernateTemplate().update(o);
	}

	public void delete(T o) {
		getHibernateTemplate().delete(o);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<T> loadAll() {
		return (ArrayList<T>) getHibernateTemplate().loadAll(type);
	}

}
