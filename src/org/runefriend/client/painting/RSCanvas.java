package org.runefriend.client.painting;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 
 * @author MalikDz
 *
 */

public abstract class RSCanvas extends java.awt.Canvas {

	private static final long serialVersionUID = -2284879212465893870L;
	private final static BufferedImage GAME_IMAGE = new BufferedImage(765, 502, BufferedImage.TYPE_INT_RGB);
	private final static BufferedImage CLIENT_IMAGE = new BufferedImage(765, 502, BufferedImage.TYPE_INT_RGB);

	private void drawClientImage(Graphics g) {
		if (super.getGraphics() != null)
			super.getGraphics().drawImage(CLIENT_IMAGE, 0, 0, null);
	}

	public BufferedImage getGameBuffer() {
		return GAME_IMAGE;
	}

	@Override
	public Graphics getGraphics() {
		Graphics g = CLIENT_IMAGE.getGraphics();
		g.drawImage(GAME_IMAGE, 0, 0, null);
		drawClientImage(g);
		return GAME_IMAGE.getGraphics();
	}
}
