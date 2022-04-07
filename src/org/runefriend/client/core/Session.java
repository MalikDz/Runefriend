package org.runefriend.client.core;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;

import java.net.URL;
import java.net.URLConnection;

import org.runefriend.client.core.debug.SessionTester;
import org.runefriend.client.core.applet.RSAppletLoader;
import org.runefriend.client.uinterface.controller.ControllerManager;
import org.runefriend.client.uinterface.controller.impl.MenuToolbarController;

/**
 * 
 * @author MalikDz
 *
 */

public class Session {

	/**
	 * 
	 * our fields
	 * 
	 */

	private boolean isLoggedIn;
	private long sessionStartTime;
	private RSAppletLoader loader;

	/**
	 * 
	 * creates a new session
	 * 
	 */

	public Session() {
	}

	/**
	 * 
	 * starts officially the session by loading runescape
	 * 
	 */

	public void init() {
		new Thread(new SessionInitializer()).start();
	}

	/**
	 * 
	 * @return the loader of this current session
	 * 
	 */

	public RSAppletLoader getLoader() {
		return loader;
	}

	/**
	 * 
	 * @return true if there's an account login
	 *
	 */

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	/**
	 * 
	 * @return for how long the session has been opened
	 *
	 */

	public long getSessionOpenedTime() {
		return System.currentTimeMillis() - sessionStartTime;
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	public class SessionInitializer implements Runnable {

		/**
		 * 
		 * initiliaze our session
		 * 
		 */

		private void initSession() throws Exception {
			checkFolders();
			checkGamePack();
			loader = new RSAppletLoader();
			sessionStartTime = System.currentTimeMillis();
			MenuToolbarController menuCon = ControllerManager.<MenuToolbarController>get(MenuToolbarController.class);
			menuCon.updateMainPanelView(loader.getApplet());
			Thread testingThread = new Thread(new SessionTester(loader));
			testingThread.start();
		}

		/**
		 * 
		 * check if the client folders exist and creates them they dont
		 * 
		 */

		private void checkFolders() {
			createFolder(Constants.CLIENT_FOLDER_PATH);
			for (String s : Constants.SUB_FOLDERS_NAME)
				createFolder(Constants.CLIENT_FOLDER_PATH + "/" + s);
		}

		/**
		 * 
		 * check a folder that exist at this path and create it if not
		 * 
		 */

		private void createFolder(String fullPath) {
			final File folderTarget = new File(fullPath);
			if (!folderTarget.exists() || (folderTarget.exists() && folderTarget.isDirectory()))
				folderTarget.mkdir();
		}

		/**
		 * 
		 * check if the gamepack exist and download if it doesnt
		 * 
		 */

		private void checkGamePack() throws Exception {
			if (!new File(Constants.GAMEPACK_FULL_PATH).exists()) {
				final FileOutputStream output = new FileOutputStream(Constants.GAMEPACK_FULL_PATH);
				final URLConnection con = new URL(Constants.OSRS_GAMEPACK_LINK).openConnection();
				final InputStream in = con.getInputStream();
				final byte[] buffer = new byte[2048];
				for (int i; (i = in.read(buffer)) != -1;)
					output.write(buffer, 0, i);
				output.close();
				in.close();
			}
		}

		/**
		 * 
		 * this function call and catch the initSession
		 * 
		 */

		@Override
		public void run() {
			try {
				initSession();
			} catch (Exception e) {
			}
		}
	}
}
