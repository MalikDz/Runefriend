package org.runefriend.client.uinterface.view;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import org.runefriend.client.uinterface.images.Images;
import org.runefriend.client.uinterface.utility.UIConstants;

/**
 * 
 * @author MalikDz
 *
 */

public class MainPanelView extends JPanel {

	/**
	 * 
	 * our fields and constants
	 * 
	 */
	private LoadingPanel loadingPanel;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * that panel will contain the loading and game view
	 * 
	 */

	public MainPanelView() {
		setLayout(new BorderLayout());
		setPreferredSize(UIConstants.MAIN_VIEW_DIMENSION);
		add(loadingPanel = new LoadingPanel());
	}

	/**
	 * 
	 * this function remove the loading panel from the main panel
	 * 
	 */

	public void removeLoadingPanel() {
		remove(loadingPanel);
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	@SuppressWarnings("serial")
	public class LoadingPanel extends JPanel {
		public LoadingPanel() {
			setLayout(null);
			setPreferredSize(UIConstants.MAIN_VIEW_DIMENSION);
			ImageIcon loadingGif = new ImageIcon(Images.LOADING_GIF.getImage());
			JLabel loadingGifLabel = new JLabel(loadingGif);
			int x = (int) ((getPreferredSize().getWidth() - loadingGif.getIconWidth()) / 2);
			int y = (int) ((getPreferredSize().getHeight() - loadingGif.getIconHeight()) / 2 + 30);
			loadingGifLabel.setBounds(x, y, loadingGif.getIconWidth(), loadingGif.getIconHeight());
			add(loadingGifLabel);
		}

		/**
		 * 
		 * this funciton is responsible for drawing our loading view
		 * 
		 */

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image logo = Images.TEAM_LOGO.getImage();
			g.drawImage(Images.BACKGROUND.getImage(), 0, 0, getWidth(), getHeight(), null);
			int x = (getWidth() - logo.getWidth(null)) / 2;
			int y = (getHeight() - logo.getHeight(null)) / 2 - 140;
			g.drawImage(logo, x, y, null);
		}
	}
}