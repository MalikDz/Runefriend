package org.runefriend.client.uinterface.images;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 
 * @author MalikDz
 * 
 */

public enum Images {

	/**
	 * 
	 * our images constants below:
	 * 
	 */

	PLAY(getImage("play.png")), 
	USER(getImage("user.png")), 
	PASS(getImage("pass.png")), 
	STOP(getImage("stop.png")), 
	PAUSE(getImage("pause.png")), 
	CLOSE(getImage("close.png")), 
	HPLAY(getImage("hplay.png")), 
	HSTOP(getImage("hstop.png")), 
	HPAUSE(getImage("hpause.png")),
	HCLOSE(getImage("hclose.png")), 
	ACCOUNT(getImage("account.png")),
	HACCOUNT(getImage("haccount.png")),
	SETTINGS(getImage("settings.png")), 
	MINIMIZE(getImage("minimize.png")),
	MAXIMIZE(getImage("maximize.png")),
	TEAM_LOGO(getImage("teamIcon1.png")), 
	HMINIMIZE(getImage("hminimize.png")),
	HMAXIMIZE(getImage("hmaximize.png")),
	HSETTINGS(getImage("hsettings.png")),
	LOADING_GIF(getImage("loading1.gif")),
	LOGIN_TEXT(getImage("loginText4.png")),
	LOGIN_BUTTON(getImage("loginButton.png")),
	HLOGIN_BUTTON(getImage("hloginButton.png")),
	BACKGROUND(getImage("background.jpg"));

	/**
	 * 
	 * all our fields
	 * 
	 */

	private Image image;

	/**
	 * 
	 * creates our enumeration element
	 * 
	 */

	private Images(Image image) {
		
		this.image = image;
	}

	/**
	 * 
	 * @return the image in this enum element
	 * 
	 */

	public Image getImage() {
		
		return image;
	}

	/**
	 * 
	 * @return the image in this enum element
	 * 
	 */

	public Image scale(int width, int height) {

		return getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	/**
	 * 
	 * @return an loaded an image with the name passe on parameters
	 * 
	 */

	private static Image getImage(final String path) {

		return new ImageIcon(Images.class.getResource("/img/" + path)).getImage();
	}
}
