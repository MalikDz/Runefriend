package org.runefriend.client.core.applet;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.HashMap;
import java.applet.AppletStub;
import java.applet.AppletContext;

/**
 * 
 * @author MalikDz
 * 
 */

public class RSAppletstub implements AppletStub {

	private URL rsAppletURL;
	private HashMap<String, String> parameters = new HashMap<String, String>();

	@Override
	public void appletResize(int width, int height) {}

	@Override
	public AppletContext getAppletContext() {
		return null;
	}

	@Override
	public URL getDocumentBase() {
		return rsAppletURL;
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public URL getCodeBase() {
		return rsAppletURL;
	}

	@Override
	public String getParameter(final String paramName) {
		return parameters.get(paramName);
	}

	public RSAppletstub(final String url) throws Exception {
		String strLigne;
		final InputStream stream = (rsAppletURL = new URL(url)).openStream();
		final InputStreamReader streamerObj = new InputStreamReader(stream);
		try (BufferedReader readerObject = new BufferedReader(streamerObj)) {
			while ((strLigne = readerObject.readLine()) != null)
				if (strLigne.contains("param name"))
					parameters.put(strLigne.split("\"")[1], strLigne.split("\"")[3].trim());
		}
	}
}
