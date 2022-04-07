package org.runefriend.client.uinterface.view;

import javax.swing.JFrame;
import com.camick.resizer.ComponentResizer;
import org.runefriend.client.uinterface.images.Images;
import org.runefriend.client.uinterface.utility.FrameMover;
import org.runefriend.client.uinterface.controller.ControllerManager;
import org.runefriend.client.uinterface.controller.impl.ClientController;
import org.runefriend.client.uinterface.controller.impl.MenuToolbarController;

/**
 * 
 * @author MalikDz
 *
 */

public class ClientView extends BaseView<ClientController, JFrame> {

	/**
	 * 
	 * our fields
	 * 
	 */

	private JFrame clientFrame;
	private MainPanelView mainPanel;

	public ClientView(ClientController controller) {
		super(controller);
		clientFrame = new JFrame();
		clientFrame.setUndecorated(true);
		clientFrame.setIconImage(Images.TEAM_LOGO.getImage());
		ComponentResizer resizer = new ComponentResizer();
		resizer.registerComponent(clientFrame);

		MenuToolbarController menuController = ControllerManager.get(MenuToolbarController.class);
		FrameMover mover = new FrameMover(clientFrame);
		menuController.view().component().addMouseListener(mover);
		menuController.view().component().addMouseMotionListener(mover);

		mainPanel = new MainPanelView();
		clientFrame.add(mainPanel);

		clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.pack();
	}

	/**
	 * 
	 * @return the panel that will contain our game applet
	 *
	 */

	public MainPanelView getMainPanel() {
		return mainPanel;
	}

	/**
	 * 
	 * @return the client frame for further control on the UI
	 * 
	 */

	@Override
	public JFrame component() {
		return clientFrame;
	}
}
