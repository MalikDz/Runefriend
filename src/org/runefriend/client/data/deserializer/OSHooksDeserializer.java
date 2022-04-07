package org.runefriend.client.data.deserializer;

import java.net.URL;
import java.awt.Point;
import java.util.HashMap;
import java.net.URLConnection;
import java.io.ObjectInputStream;
import org.runefriend.client.data.serializable.InfoContainer;

/**
 * 
 * @author MalikDz
 *
 */

public class OSHooksDeserializer extends AbstractDeserializer {

	/**
	 * 
	 * all our field containing our hooks data
	 * 
	 */

	private int osrsClientRevision;
	private static final String HOOK_FILE_URL = "https://github.com/MalikDz/DataStuff/blob/master/data1.ser?raw=true";
	private HashMap<String, InfoContainer> infoContainers = new HashMap<String, InfoContainer>();

	/**
	 * 
	 * creates a new deserializer that will get data from our hook file
	 * 
	 */

	public OSHooksDeserializer() {
		super(HOOK_FILE_URL);
	}

	/**
	 * 
	 * @return the current revision of the osrs game
	 *
	 */

	public int getOsrsClientRevision() {
		return osrsClientRevision;
	}

	/**
	 * 
	 * @return all information container representing one class each
	 * 
	 */
	public HashMap<String, InfoContainer> getClassInfoContainers() {
		return infoContainers;
	}

	/**
	 * 
	 * print all the hooks in the console for debugging purpose
	 * 
	 */

	public void printHooks() {
		infoContainers.entrySet().forEach(e -> System.out.println(e.getValue().getRealName()));
	}

	/**
	 * 
	 * this method is used to deserialize the file and store the data needed
	 * 
	 */

	@Override
	public void deserialize() {
		try {
			Object data;
			URL url = new URL(getLocation());
			URLConnection urlCon = url.openConnection();
			ObjectInputStream in = new ObjectInputStream(urlCon.getInputStream());
			osrsClientRevision = in.readInt();
			while (!((data = in.readObject()) instanceof Point))
				infoContainers.put(((InfoContainer) data).getRealName(), ((InfoContainer) data));
		} catch (Exception e) {
		}
	}
}
