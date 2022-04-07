package org.runefriend.client.uinterface.controller.impl;

import java.awt.Frame;
import java.applet.Applet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.runefriend.client.core.Session;
import org.runefriend.client.uinterface.view.ClientView;
import org.runefriend.client.uinterface.view.MainPanelView;
import org.runefriend.client.uinterface.view.MenuToolbarView;
import org.runefriend.client.uinterface.controller.BaseController;
import org.runefriend.client.uinterface.controller.ControllerManager;
import org.runefriend.client.uinterface.controller.impl.ExplorerController.FocusedTab;

/**
 * 
 * @author MalikDz
 *
 */

public class MenuToolbarController extends BaseController<MenuToolbarView, Session> {

	/**
	 * 
	 * our fields and constants
	 * 
	 */

	private boolean maximized;
	private static final String[] CLOSE_OPTIONS = { "Yes, please", "No, thanks" };
	private static final String CLOSE_QUESTION = "Would you like to close the client ?";

	/**
	 * 
	 * creates a controller for our toolbar
	 * 
	 */

	public MenuToolbarController(Session session) {
		super(session);
	}

	/**
	 * 
	 * anything related to the user is handled here
	 * 
	 */

	public void init() {
		model().init();
	}

	/**
	 * 
	 * minimize the client by putting in our toolbar
	 * 
	 */

	public void minimize() {
		mainFrame().setState(Frame.ICONIFIED);
	}

	/**
	 * 
	 * make our toolbar visible by adding it to the client
	 * 
	 */

	@Override
	public void show() {
		mainFrame().setJMenuBar(view().component());
	}

	/**
	 * 
	 * @return the current view for this controller or create one if needed
	 * 
	 */

	@Override
	public MenuToolbarView view() {
		return view == null ? (view = new MenuToolbarView(this)) : view;
	}

	/**
	 * 
	 * @return the main frame component for some manipulation
	 * 
	 */

	private JFrame mainFrame() {
		return ControllerManager.<ClientController> get(ClientController.class).view().component();
	}

	/**
	 * 
	 * ask the client if he want to close the client and close it
	 * 
	 */

	public void endClient() {
		if (JOptionPane.showOptionDialog(mainFrame(), CLOSE_QUESTION, "Exit", 0, 3, null, CLOSE_OPTIONS, null) == 0)
			System.exit(0);
	}

	/**
	 * 
	 * maximize the client frame or restore the normal size if already maximized
	 * 
	 */

	public void maximize() {
		mainFrame().setExtendedState(maximized ? Frame.NORMAL : mainFrame().getExtendedState() | JFrame.MAXIMIZED_BOTH);
		maximized = !maximized;
	}

	/**
	 * 
	 * add the game applet to the main panel view so that the game become
	 * 
	 */

	public void updateMainPanelView(Applet applet) {
		ClientController controller = ControllerManager.<ClientController> get(ClientController.class);
		MainPanelView mainPanelView = ((ClientView) controller.view()).getMainPanel();
		mainPanelView.removeLoadingPanel();
		mainPanelView.add(applet);
		mainPanelView.revalidate();
	}

	/**
	 * 
	 * shows the explorer view with the scripts tab open
	 * 
	 */

	public void showScriptTab() {
		showExplorerTab(FocusedTab.SCRIPTS);
	}

	/**
	 * 
	 * shows the explorer view with the plugins tab open
	 * 
	 */

	public void showPluginsTab() {
		showExplorerTab(FocusedTab.PLUGINS);
	}

	/**
	 * 
	 * shows the explorer view with the settings tab open
	 * 
	 */

	public void showSettingsTab() {
		showExplorerTab(FocusedTab.SETTINGS);
	}

	/**
	 * 
	 * shows the explorer view with the tab passed in param open
	 * 
	 */

	public void showExplorerTab(FocusedTab tabPane) {
		ExplorerController explorerCon = ControllerManager.<ExplorerController> get(ExplorerController.class);
		ClientController clientCon = ControllerManager.<ClientController> get(ClientController.class);
		explorerCon.view().component().setLocationRelativeTo(clientCon.view().component());
		explorerCon.setFocusedTab(tabPane);
		explorerCon.show();
	}
}
