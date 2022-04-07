package org.runefriend.client.core.external.scripting;

import org.runefriend.client.core.external.data.ScriptableEntityData;

/**
 * 
 * @author MalikDz
 * 
 */

@SuppressWarnings("unused")
public class ScriptHandler implements Runnable {

	/**
	 * 
	 * our fields
	 * 
	 */

	private ScriptState scriptState;
	private ScriptableEntityData scriptData;
	private String user, pass, scriptName;

	/**
	 * 
	 * create a script handler that will managa a script
	 * 
	 */

	public ScriptHandler(ScriptableEntityData scriptData, String user, String pass, String scriptName) {
		this.scriptData = scriptData;
		this.scriptName = scriptName;
		this.user = user;
		this.pass = pass;
	}

	/**
	 * 
	 * our run method that actually run the script that was selected
	 * 
	 */

	@Override
	public void run() {
		try {
			/*this.script = (Script) scriptData.getClazz().newInstance();
			final boolean cond = script instanceof PaintListener;
			final PaintListener paint = cond ? (PaintListener) script : null;
			script.setApiProvider(bot.getApiProvider(), user, pass, scriptName);
			bot.getExecutator().setHandler(this);
			scriptState = State.RUNNING;
			script.onStart();
			sendAccountDetail();
			int time = 0;
			bot.getBotCanvas().setPaintListener(paint);
			while (!scriptState.equals(State.STOPPED) && time >= 0) {
				time = scriptState.equals(State.PAUSED) ? 1000 : script.loop();
				Utilities.sleep(time >= 0 ? time : 0);
			}
			script.onStop();
			stop();*/
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 * Stop the script and set to null the paint
	 * 
	 */

	private void stop() {
		setScriptState(ScriptState.STOPPED);
	}

	/**
	 * 
	 * Set the script state to a new one
	 * 
	 */

	public void setScriptState(ScriptState state) {
		this.scriptState = state;
	}

	/**
	 * 
	 * @return the script informations
	 * 
	 */

	public ScriptableEntityData getScriptData() {
		return scriptData;
	}
}
