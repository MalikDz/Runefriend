package org.runefriend.client.core.external.scripting;

/**
 * 
 * @author MalikDz
 *
 */

public class ScriptExecutator {

	/**
	 * 
	 * our fields
	 * 
	 */

	private ScriptHandler currentHandler;

	/**
	 * 
	 * Creates ou script executor
	 * 
	 */

	public ScriptExecutator(String scriptFolder) {
		//this.currentHandler = new ScriptHandler();
	}

	/**
	 * 
	 * Start a script if there none running
	 * 
	 */

	public void startScript(final String... paths) {
	}

	/**
	 * 
	 * Pause the current script
	 * 
	 */

	public void pauseScript() {
		currentHandler.setScriptState(ScriptState.PAUSED);
	}

	/**
	 * 
	 * Stop the current script
	 * 
	 */

	public void stopScript() {
		currentHandler.setScriptState(ScriptState.STOPPED);
	}

	/**
	 * 
	 * Set a script handler for the script running
	 * 
	 */

	public void setHandler(ScriptHandler handler) {
		currentHandler = handler;
	}
}
