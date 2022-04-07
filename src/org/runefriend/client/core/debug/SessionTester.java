package org.runefriend.client.core.debug;

import org.runefriend.client.api.accessors.entity.INpc;
import org.runefriend.client.core.applet.RSAppletLoader;
import org.runefriend.client.api.accessors.client.IClient;

/**
 * 
 * @author MalikDz
 *
 */

public class SessionTester implements Runnable {
	/**
	 * 
	 * this field contain the client instance
	 * 
	 */
	IClient clientInstance;

	/**
	 * 
	 * this function call and catch the runDebugging
	 * 
	 */

	@Override
	public void run() {
		try {runDebuggingLoop();} catch (Exception e) {}
	}

	/**
	 * 
	 * were passing the loader instance to be able to get the client instance
	 * 
	 */

	public SessionTester(RSAppletLoader loader) {
		clientInstance = (IClient) loader.getClientInstance();
	}

	/**
	 * 
	 * this function will debug some stuff for us
	 * 
	 */
	private void runDebuggingLoop() throws Exception {
		while (true)
			executeDebuggingLogs();
	}

	/**
	 * 
	 * this function will debug some stuff for us
	 * 
	 */
	private void executeDebuggingLogs() throws Exception {
		Thread.sleep(100);
		System.out.println("\n\n\n");
		System.out.println("BaseX is : " + clientInstance.getBaseX());
		System.out.println("BaseY is : " + clientInstance.getBaseY());
		System.out.println("The current game state is : " + clientInstance.getGameState());
		if (clientInstance.getGameState() == 30)
			for (INpc x : clientInstance.getNpcs())
				if (x != null && x.getNpcDefinition() != null)
					System.out.println(x.getNpcDefinition().getName());
	}
}