package org.runefriend.client.data.serializable;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * 
 * @author MalikDz
 *
 */

public class InfoContainer implements Serializable {

	/**
	 * 
	 * all of our constants
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * our fields
	 * 
	 */

	private String obfName;
	private String realName;
	private String packageName;
	private String superClassName;
	private List<FieldHook> fieldHooks = new ArrayList<FieldHook>();
	private List<MethodHook> methodHooks = new ArrayList<MethodHook>();

	/**
	 * 
	 * this class is a container for the hooks of a specific class node
	 * 
	 */

	public InfoContainer(final String realName, final String obfName, final String superClassName) {
		this.obfName = obfName;
		this.realName = realName;
		this.superClassName = superClassName;
	}

	/**
	 * 
	 * @return the package name that will be used when injecting
	 * 
	 */

	public String getPackageName() {
		return packageName;
	}

	/**
	 * 
	 * set the package name for this class so that we can use it when injecting
	 * 
	 */

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * 
	 * add a hook to the hook container
	 * 
	 */

	public void addFieldHook(final FieldHook hook) {
		this.fieldHooks.add(hook);
	}

	/**
	 * 
	 * add a hook to the hook container
	 * 
	 */

	public void addMethodHook(final MethodHook hook) {
		this.methodHooks.add(hook);
	}

	/**
	 * 
	 * add a hook to the hook container
	 * 
	 */

	public void addFieldHook(final FieldHook... hooks) {
		Arrays.stream(hooks).forEach(h -> addFieldHook(h));
	}

	/**
	 * 
	 * add a hook to the hook container
	 * 
	 */

	public void addMethodHook(final MethodHook... hooks) {
		Arrays.stream(hooks).forEach(h -> addMethodHook(h));
	}

	/**
	 * 
	 * @return the hook container list
	 * 
	 */

	public List<FieldHook> getFieldHooks() {
		return fieldHooks;
	}

	/**
	 * 
	 * @return the super class name of the container class
	 * 
	 */

	public String getSuperClass() {
		return superClassName;
	}

	/**
	 * 
	 * @return the real class name
	 * 
	 */

	public String getRealName() {
		return realName;
	}

	/**
	 * 
	 * @return the obfuscate name
	 * 
	 */

	public String getObfName() {
		return obfName;
	}

	/**
	 * 
	 * return a string representation of this class
	 * 
	 */

	public String toString() {
		return String.format("Real name : %s  identified as : %s", realName, obfName);
	}
}
