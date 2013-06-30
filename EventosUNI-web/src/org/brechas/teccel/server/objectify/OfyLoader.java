package org.brechas.teccel.server.objectify;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.LoadType;
import com.googlecode.objectify.impl.LoaderImpl;

/**
 * Extend the Loader command with our own logic
 * 
 * @author Jeff Schnitzer
 */
public class OfyLoader extends LoaderImpl<OfyLoader> {
	/** */
	public OfyLoader(Ofy base) {
		super(base);
	}

	/**
	 * Gets the Person associated with the email, or null if there is no
	 * association.
	 */
	public <T> LoadType<T> query(Class<T> clazz) {
		return ofy.load().type(clazz);
	}

	public <T> T get(Key<T> key) {
		return ofy.load().key(key).now();
	}

	public <T> T get(Class<T> clazz, long id) {
		return ofy.load().type(clazz).id(id).now();
	}

}