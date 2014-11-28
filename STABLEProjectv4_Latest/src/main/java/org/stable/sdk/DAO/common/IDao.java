/**
 * 
 */
package org.stable.sdk.DAO.common;

import java.io.Serializable;
import java.util.ArrayList;

import org.stable.sdk.model.common.IStableModel;

/**
 * @author amuthanarulraj
 * 
 */
public interface IDao<T extends IStableModel, PK extends Serializable> {

	/**
	 * Persist the newInstance object into database
	 */
	void create(T newInstance);

	/**
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	T read(PK id);

	/**
	 * Save changes made to a persistent object.
	 */
	void update(T transientObject);

	/**
	 * Remove an object from persistent storage in the database
	 */
	void delete(T persistentObject);

	/**
	 * <p>
	 * Retrieves all objects that was previously persisted
	 * </p>
	 * 
	 * @return ArrayList of all objects
	 */
	ArrayList<T> loadAll();

}
