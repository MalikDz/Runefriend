package org.runefriend.client.uinterface.view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.camick.resizer.ComponentResizer;
import org.runefriend.client.uinterface.images.Images;
import org.runefriend.client.uinterface.utility.UICreator;
import org.runefriend.client.uinterface.utility.FrameMover;
import org.runefriend.client.uinterface.controller.impl.ExplorerController;

/**
 * 
 * @author MalikDz
 *
 */

public class ExplorerView extends BaseView<ExplorerController, JFrame> {

	/**
	 * 
	 * our fields
	 * 
	 */

	private JFrame explorerFrame;
	private ScriptTabView scriptTabView;
	private PluginTabView pluginTabView;
	private JTabbedPane explorerTabbedPanes;

	/**
	 * 
	 * creates a view that will contain a script and plugin tab
	 * 
	 */

	public ExplorerView(ExplorerController presenter) {
		super(presenter);
		explorerFrame = new JFrame();
		explorerFrame.setUndecorated(true);
		explorerFrame.setPreferredSize(new Dimension(700, 400));
		explorerFrame.setIconImage(Images.TEAM_LOGO.getImage());
		ComponentResizer resizer = new ComponentResizer();
		ButtonHandler handler = new ButtonHandler();
		resizer.registerComponent(explorerFrame);

		scriptTabView = new ScriptTabView();
		pluginTabView = new PluginTabView();
		explorerTabbedPanes = new JTabbedPane();

		explorerTabbedPanes.addTab("Scripts", null, scriptTabView, "Click here to see your scripts");
		explorerTabbedPanes.setMnemonicAt(0, KeyEvent.VK_1);

		explorerTabbedPanes.addTab("Plugins", null, pluginTabView, "Click here to see your plugins");
		explorerTabbedPanes.setMnemonicAt(1, KeyEvent.VK_2);

		explorerTabbedPanes.addTab("Settings", null, new JPanel(), "Click here to change the client settings");
		explorerTabbedPanes.setMnemonicAt(2, KeyEvent.VK_3);

		explorerFrame.add(explorerTabbedPanes);

		JMenuBar menuBar = UICreator.createFrameBar(handler, new Dimension(90, 30), "Explorer");
		FrameMover mover = new FrameMover(explorerFrame);
		menuBar.addMouseMotionListener(mover);
		menuBar.addMouseListener(mover);

		explorerFrame.setJMenuBar(menuBar);
		explorerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		explorerFrame.pack();
	}

	/**
	 * 
	 * @return the main component which is the explorer JFrame
	 * 
	 */

	@Override
	public JFrame component() {
		return explorerFrame;
	}

	/**
	 * 
	 * @return the tabs container so that we can use it to focus on a pane
	 * 
	 */

	public JTabbedPane getTabbedPanes() {
		return explorerTabbedPanes;
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	public class TabChangeListener implements ChangeListener {

		/**
		 * 
		 * this functions is called when the user change tab 
		 * 
		 */
		
		@Override
		public void stateChanged(ChangeEvent e) {
		}
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	public class ButtonHandler extends MouseAdapter {

		/**
		 * 
		 * this listener is responsible for handling any button click
		 * 
		 */

		@Override
		public void mouseClicked(MouseEvent event) {
			switch (event.getComponent().getName()) {
			case "MaximizeButton":
				break;
			case "minimizeButton":
				break;
			case "closeButton":
				explorerFrame.setVisible(false);
				break;
			}
		}
	}
}
