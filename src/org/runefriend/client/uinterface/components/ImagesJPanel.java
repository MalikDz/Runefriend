package org.runefriend.client.uinterface.components;

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 * @author MalikDz
 *
 */

public class ImagesJPanel extends JPanel {

	/**
	 * 
	 * this image will be displayed in our panel as a background
	 * 
	 */

	private Image image;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * initialize the image variable with the one passed on param
	 * 
	 */

	public ImagesJPanel(Image image) {
		this.image = image;
	}

	/**
	 * 
	 * draw our custom background with using or image field
	 * 
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
