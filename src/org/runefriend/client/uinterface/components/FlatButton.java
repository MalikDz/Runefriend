package org.runefriend.client.uinterface.components;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BasicStroke;
import javax.swing.JButton;

/**
 * 
 * @author MalikDz
 *
 */

public class FlatButton extends JButton {

	/**
	 * 
	 * our fields
	 * 
	 */

	private boolean hovered;
	public Color filingColor, borderColor;
	private static final long serialVersionUID = 1L;
	private static final Color DEFAULT_BORDER_COLOR = Color.decode("#000000");
	private static final Color DEFAULT_FILLING_COLOR = Color.decode("#1abc9c");
	private static final Color DEFAULT_FOREGROUND_COLOR = Color.decode("#000000");
	private static final Font DEFAULT_FONT = new Font("Gill Sans MT", Font.BOLD, 14);

	/**
	 * 
	 * creates a flat button using the default colors and font
	 * 
	 */

	public FlatButton(String text) {
		this(text, DEFAULT_FOREGROUND_COLOR, DEFAULT_FILLING_COLOR, DEFAULT_BORDER_COLOR, DEFAULT_FONT);
	}

	/**
	 * 
	 * creates a flat button using our custom colors and font
	 * 
	 */

	public FlatButton(String text, Color foregroundColor, Color filingColor, Color borderColor, Font textFont) {
		super(text);
		addMouseListener(new HoverHandler());
		this.filingColor = filingColor;
		this.borderColor = borderColor;
		setForeground(foregroundColor);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setFont(textFont);
		repaint();
	}

	/**
	 * 
	 * draw our custom button
	 * 
	 */

	@Override
	public void paintComponent(Graphics graphics) {

		Graphics2D g = (Graphics2D) graphics;
		g.setColor(hovered ? filingColor.darker() : filingColor);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(borderColor);
		g.setStroke(new BasicStroke(3));
		g.drawRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);
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
			FlatButton.this.hovered = true;
		}

		/**
		 * 
		 * changes the button image to the default one back
		 * 
		 */

		@Override
		public void mouseExited(MouseEvent e) {
			FlatButton.this.hovered = false;
		}
	}
}
