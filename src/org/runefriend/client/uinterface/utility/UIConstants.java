package org.runefriend.client.uinterface.utility;

import java.awt.Image;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import org.runefriend.client.uinterface.images.Images;

/**
 * 
 * @author MalikDz
 *
 */

public class UIConstants {

	/**
	 * 
	 * these constants here are used for our frames titles
	 * 
	 */

	public static final String CLIENT_VERSION = "0.00";
	public static final String CLIENT_NAME = "Runefriend";
	public static final Dimension MAIN_VIEW_DIMENSION = new Dimension(766, 534);
	public static final ImageIcon RESIZED_LOGO = new ImageIcon(Images.TEAM_LOGO.scale(15, 15));
	public static final String CLIENT_TITLE = String.format("%s v%s", CLIENT_NAME, CLIENT_VERSION);

	/**
	 * 
	 * this constants are used to create our own custom buttons
	 * 
	 */

	public final static String[] BUTTON_NAME_IDENTIFIERS = { "playButton", "stopButton", "accountButton",
			"settingsButton", "minimizeButton", "maximizeButton", "closeButton" };

	public final static Dimension[] BUTTON_DIMENSIONS = { new Dimension(22, 30), new Dimension(25, 30),
			new Dimension(20, 30), new Dimension(22, 30), new Dimension(15, 20), new Dimension(27, 26),
			new Dimension(45, 17) };

	public final static Image[] DISPLAYED_ICONS = { Images.HPLAY.scale(25, 25), Images.HSTOP.scale(25, 25),
			Images.HACCOUNT.getImage(), Images.HSETTINGS.getImage(), Images.MINIMIZE.getImage(),
			Images.MAXIMIZE.getImage(), Images.CLOSE.getImage() };

	public final static Image[] HOVERED_ICONS = { Images.PLAY.scale(25, 25), Images.STOP.scale(25, 25),
			Images.ACCOUNT.getImage(), Images.SETTINGS.getImage(), Images.HMINIMIZE.getImage(),
			Images.HMAXIMIZE.getImage(), Images.HCLOSE.getImage() };
}
