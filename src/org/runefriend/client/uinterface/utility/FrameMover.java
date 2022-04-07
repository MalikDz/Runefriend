package org.runefriend.client.uinterface.utility;

import java.awt.Point;
import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author MalikDz
 *
 */

public class FrameMover extends MouseAdapter implements MouseMotionListener {

	private JFrame frame;
	private Point framePosition;
	private int changeX, changeY, posX, posY;

	public FrameMover(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		posX = e.getX();
		posY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		changeX = (e.getX() - posX);
		changeY = (e.getY() - posY);
		framePosition = (frame.getLocation());
		frame.setLocation(framePosition.x + changeX, framePosition.y + changeY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}