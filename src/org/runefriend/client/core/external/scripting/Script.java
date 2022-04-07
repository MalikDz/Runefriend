package org.runefriend.client.core.external.scripting;

import org.runefriend.client.api.ApiContext;

/**
 * 
 * @author MalikDz
 *
 */

public abstract class Script {

	/**
	 * 
	 * our fields and scripts methods
	 * 
	 */

	public ApiContext api;

	public abstract int loop();

	public abstract void onStop();

	public abstract void onStart();

	public String user, pass, scriptName;

	public void setApiProvider(final ApiContext api) {
		setApiProvider(api, "", "", "");
	}

	public void setApiProvider(ApiContext api, String user, String pass, String script) {
		this.api = api;
		this.user = user;
		this.pass = pass;
		this.scriptName = script;
	}
}
