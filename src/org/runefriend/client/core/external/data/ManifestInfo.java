package org.runefriend.client.core.external.data;

/**
 * 
 * @author MalikDz
 *
 */

public class ManifestInfo {

	/**
	 * 
	 * our fields
	 * 
	 */

	private String author, version, scriptName, description;

	/**
	 * 
	 * creates a object that contains a manifest values
	 *
	 */

	public ManifestInfo(String vers, String author, String desc, String script) {
		this.version = vers;
		this.author = author;
		this.description = desc;
		this.scriptName = script;
	}

	/**
	 * 
	 * @return a description of what the plugin or script is supposed to do
	 *
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return the script of the plugin version
	 *
	 */

	public String getVersion() {
		return version;
	}

	/**
	 * 
	 * @return the script of the plugin author
	 *
	 */

	public String getAuthor() {
		return author;
	}

	/**
	 * 
	 * @return the script of the plugin name
	 *
	 */

	public String getName() {
		return scriptName;
	}
}
