package org.runefriend.client.uinterface.utility;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseListener;

import java.util.stream.IntStream;
import org.runefriend.client.uinterface.images.Images;
import org.runefriend.client.uinterface.components.ImageButton;

/**
 * 
 * @author MalikDz
 *
 */

public class UICreator {

	/**
	 * 
	 * this method is used for adding our title and logo to the client corner
	 * 
	 */

	public static ImageButton createButton(int id, int limit, MouseListener handler, JMenuBar menubar) {
		menubar.add(Box.createHorizontalStrut(id == limit ? 20 : 0));
		ImageButton result = new ImageButton(UIConstants.DISPLAYED_ICONS[id], UIConstants.HOVERED_ICONS[id]);
		result.setPreferredSize(UIConstants.BUTTON_DIMENSIONS[id]);
		result.setName(UIConstants.BUTTON_NAME_IDENTIFIERS[id]);
		result.addMouseListener(handler);
		return result;
	}

	/**
	 * 
	 * 
	 * @return a bar that has the same style as our current UI
	 *
	 */

	public static JMenuBar createFrameBar(MouseListener handler, Dimension barDimension, String title) {
		JMenuBar bar = new JMenuBar();
		bar.setBorder(BorderFactory.createEmptyBorder());
		JLabel frameTitleLabel = new JLabel(title, new ImageIcon(Images.TEAM_LOGO.scale(15, 15)), 0);
		frameTitleLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		frameTitleLabel.setPreferredSize(barDimension);
		bar.add(frameTitleLabel);
		bar.add(Box.createHorizontalGlue());
		IntStream.range(4, 7).forEach(x -> bar.add(createButton(x, 0, handler, bar)));
		return bar;
	}
}
