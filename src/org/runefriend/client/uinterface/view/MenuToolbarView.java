package org.runefriend.client.uinterface.view;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import javax.swing.BorderFactory;
import java.util.stream.IntStream;
import org.runefriend.client.uinterface.utility.UICreator;
import org.runefriend.client.uinterface.utility.UIConstants;
import org.runefriend.client.uinterface.controller.impl.MenuToolbarController;

/**
 * 
 * @author MalikDz
 *
 */

public class MenuToolbarView extends BaseView<MenuToolbarController, JMenuBar> {

	/**
	 * 
	 * our fields and constants
	 * 
	 */

	private JMenuBar menubar;

	/**
	 * 
	 * initialise all our menu components with the constructor
	 * 
	 */

	public MenuToolbarView(MenuToolbarController menuController) {
		super(menuController);
		menubar = new JMenuBar();
		menubar.setBorder(BorderFactory.createEmptyBorder());
		JLabel frameTitleLabel = new JLabel(UIConstants.CLIENT_TITLE, UIConstants.RESIZED_LOGO, 0);
		frameTitleLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 12));
		frameTitleLabel.setPreferredSize(new Dimension(120, 30));

		menubar.add(frameTitleLabel);
		menubar.add(Box.createHorizontalGlue());
		final MenuButtonsHandler handler = new MenuButtonsHandler();
		IntStream.range(0, 7).forEach(x -> menubar.add(UICreator.createButton(x, 4, handler, menubar)));
	}

	/**
	 * 
	 * @return the menubar instance to be able to use it for UI changement
	 * 
	 */

	@Override
	public JMenuBar component() {
		return menubar;
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	public class MenuButtonsHandler extends MouseAdapter {

		/**
		 * 
		 * relay an order to the menu controller
		 * 
		 */

		@Override
		public void mouseClicked(MouseEvent event) {
			switch (((JLabel) event.getComponent()).getName()) {
			case "pauseButton":
				break;
			case "stopButton":
				break;
			case "accountButton":
				break;
			case "minimizeButton":
				controller().minimize();
				break;
			case "maximizeButton":
				controller().maximize();
				break;
			case "closeButton":
				controller().endClient();
				break;
			case "playButton":
				controller().showScriptTab();
				break;
			case "settingsButton":
				controller().showSettingsTab();
				break;	
			}
		}
	}
}
