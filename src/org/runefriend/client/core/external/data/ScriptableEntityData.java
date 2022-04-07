package org.runefriend.client.core.external.data;

/**
 * 
 * @author MalikDz
 *
 */

public class ScriptableEntityData {

	/**
	 * 
	 * our fields
	 * 
	 */

	private Class<?> clazz;
	private ManifestInfo info;

	/**
	 * 
	 * create a class containing script data
	 * 
	 */

	public ScriptableEntityData(ManifestInfo info, Class<?> clazz) {
		this.clazz = clazz;
		this.info = info;
	}

	/**
	 * 
	 * @return the script manifest
	 *
	 */

	public ManifestInfo getManifestInfo() {
		return info;
	}

	/**
	 * 
	 * return the script class
	 *
	 */

	public Class<?> getClazz() {
		return clazz;
	}
}
