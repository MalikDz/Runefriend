package org.runefriend.client.core.external.plugins;

import org.runefriend.client.api.ApiContext;

/**
 * 
 * @author MalikDz
 *
 */

public abstract class Plugin {

	/**
	 * 
	 * this fields contain our api classes instances
	 * 
	 */

	public ApiContext ctx;

	/**
	 * 
	 * this method will be called when the plugin buttin is pressed
	 * 
	 */

	public abstract int activate();

	/**
	 * 
	 * this function is used to give an api context to the plugin
	 * 
	 */

	public void setApiProvider(final ApiContext ctx) {
		this.ctx = ctx;
	}
}
