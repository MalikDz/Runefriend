package org.runefriend.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import org.rusicade.client.ui.lookandfeel.MalikLookAndFeel;

import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import org.runefriend.client.core.Session;
import org.runefriend.client.injector.ClassModifier;
import org.runefriend.client.data.deserializer.OSHooksDeserializer;
import org.runefriend.client.uinterface.controller.ControllerManager;
import org.runefriend.client.uinterface.controller.impl.UserLoginController;

/**
 *
 * @author MalikDz
 *
 */

public class Application extends Authenticator implements Runnable {

	/**
	 * 
	 * this function initialise our managers
	 * 
	 */

	@Override
	public void run() {
		ControllerManager.init(new Session());
		ControllerManager.get(UserLoginController.class).show();
	}

	/**
	 * 
	 * this function is used to launch our client application
	 * 
	 *
	 */

	public static void main(String[] args) throws Exception {
		bootWithProxy();
		UIManager.setLookAndFeel(new MalikLookAndFeel());
		SwingUtilities.invokeLater(new Application());
	
	}


	/**
	 * 
	 * this function is used to test our bytecode injector functionnability
	 * 
	 */

	@SuppressWarnings("unused")
	private static void test() throws Exception {
		OSHooksDeserializer osDeserializer = new OSHooksDeserializer();
		ClassModifier injector = new ClassModifier();
		osDeserializer.deserialize();
		injector.linkJar("test/input/gamepack202.jar");
		injector.registerClassDataContainers(osDeserializer.getClassInfoContainers());
		injector.parseJar();
		injector.applyModifications();
		injector.writeJar("test/output/gamepack202.jar");
		System.out.println("Exited without error");
		System.exit(0);
	}

	/**
	 * 
	 * this function is used to the client using a proxy of our choice
	 * 
	 */

	private static void bootWithProxy() {
		final String username = System.getProperty("java.net.socks.username");
		Authenticator.setDefault(username != null && !username.equals("") ? new CustomAuthenticator() : null);
	}

	/**
	 * 
	 * creates an new auth that needed to pass the pass and user restriction
	 * 
	 */

	private static class CustomAuthenticator extends Authenticator {
		protected PasswordAuthentication getPasswordAuthentication() {
			String user = System.getProperty("java.net.socks.username");
			String pass = System.getProperty("java.net.socks.password");
			return new PasswordAuthentication(user, pass.toCharArray());
		}
	}
}
