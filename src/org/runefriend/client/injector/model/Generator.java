package org.runefriend.client.injector.model;

import java.util.HashMap;
import org.objectweb.asm.Opcodes;
import org.runefriend.client.data.serializable.InfoContainer;

/**
 * 
 * @author MalikDz
 *
 */

public abstract class Generator<T> implements Opcodes {

	/**
	 * 
	 * a field that will contain the generated element
	 * 
	 */

	T element;

	/**
	 * 
	 * constant containing the api package path
	 * 
	 */

	public static final String API_PACKAGE_PATH = "org/runefriend/client/api/accessors/";
	/**
	 * 
	 * we might need our class data for some injections we will make
	 * 
	 */

	private HashMap<String, InfoContainer> classesDataContainer;

	/**
	 * 
	 * this constructor is for the generator that need class data
	 * 
	 */

	public Generator() {
	}

	/**
	 * 
	 * this constructor for the generator that dont need class data
	 * 
	 */

	public Generator(HashMap<String, InfoContainer> classesDataContainer) {
		this.classesDataContainer = classesDataContainer;
	}

	/**
	 * 
	 * return the real name of the obfuscated class
	 * 
	 */
	public String getRealName(String obfName) {
		return classesDataContainer.get(obfName).getRealName();
	}

	/**
	 * 
	 * an accesor method used to return that generated element
	 * 
	 */

	public T element() {
		return element;
	}
}
