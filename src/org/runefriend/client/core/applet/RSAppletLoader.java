package org.runefriend.client.core.applet;

import java.net.URL;
import java.util.Map;
import java.util.Random;

import org.objectweb.asm.tree.ClassNode;
import org.runefriend.client.core.Constants;
import org.runefriend.client.injector.CustomLoader;
import org.runefriend.client.injector.ClassModifier; 
import org.runefriend.client.data.deserializer.OSHooksDeserializer;

import java.applet.*;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URLClassLoader;

/**
 * 
 * @author MalikDz
 *
 */

public class RSAppletLoader {

	private Applet gameApplet;
	private URLClassLoader loader;
	private Object mainClassInstance;
	private static final Dimension OSRS_APPLET_DIMENSION = new Dimension(763, 514);

	/**
	 * 
	 * Loads the client class using the urlClassloader
	 *
	 */

	public RSAppletLoader() throws Exception {
		String world = Constants.WOLRDS_ID[new Random().nextInt(Constants.WOLRDS_ID.length)];
		AppletStub stub = new RSAppletstub(String.format(Constants.OSRS_WEBSITE_URL, world));
		loader = new CustomLoader(getModifiedClasses(), new URL[] { new URL(path()) });
		mainClassInstance = loader.loadClass("client").newInstance();
		gameApplet = (Applet) this.mainClassInstance;
		gameApplet.resize(OSRS_APPLET_DIMENSION);
		gameApplet.setStub(stub);
		gameApplet.init();
		gameApplet.start();
	}

	/**
	 * 
	 * @return this function returned the parsed classnodes map that we injected
	 * 
	 */

	public Map<String, ClassNode> getModifiedClasses() throws IOException {
		OSHooksDeserializer osDeserializer = new OSHooksDeserializer();
		ClassModifier injector = new ClassModifier();
		osDeserializer.deserialize();
		injector.linkJar(Constants.GAMEPACK_FULL_PATH);
		injector.registerClassDataContainers(osDeserializer.getClassInfoContainers());
		injector.parseJar();
		injector.applyModifications();
		return injector.getModifiedClasses();
	}

	/**
	 * 
	 * @return where the gamepack located in that computer
	 * 
	 */

	public String path() {
		return String.format("jar:file:%s!/", Constants.GAMEPACK_FULL_PATH);
	}

	public URLClassLoader getClassLoader() {
		return loader;
	}

	public Object getClientInstance() {
		return mainClassInstance;
	}

	public Applet getApplet() {
		return gameApplet;
	}
}
