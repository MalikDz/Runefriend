package org.runefriend.client.uinterface.components;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * 
 * @author MalikDz
 *
 */

public class ImageButton extends JLabel {

	/**
	 * 
	 * our fields
	 * 
	 */
	private ImageIcon defaultImage, hoverImage;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * creates an button that will display our image with hover effect
	 * 
	 */

	public ImageButton(Image defaultImage, Image hoverImage) {
		addMouseListener(new HoverHandler());
		this.hoverImage = new ImageIcon(hoverImage);
		this.setIcon(this.defaultImage = new ImageIcon(defaultImage));
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	private class HoverHandler extends MouseAdapter {

		/**
		 * 
		 * changes the button image when we hover on it
		 * 
		 */

		@Override
		public void mouseEntered(MouseEvent e) {
			ImageButton.this.setIcon(ImageButton.this.hoverImage);
		}

		/**
		 * 
		 * changes the button image to the default one back
		 * 
		 */

		@Override
		public void mouseExited(MouseEvent e) {
			ImageButton.this.setIcon(ImageButton.this.defaultImage);
		}
	}
}
