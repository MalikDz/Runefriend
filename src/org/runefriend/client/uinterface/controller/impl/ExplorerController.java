package org.runefriend.client.uinterface.controller.impl;

import org.runefriend.client.core.Session;
import org.runefriend.client.uinterface.view.ExplorerView;
import org.runefriend.client.uinterface.controller.BaseController;

/**
 * 
 * @author MalikDz
 *
 */

public class ExplorerController extends BaseController<ExplorerView, Session> {

	/**
	 * 
	 * this field indicate which tab will be opened when the explorer show
	 * 
	 */

	private FocusedTab focusedTab;

	/**
	 * 
	 * creates an controller that will be used to control our explorer
	 * 
	 */

	public ExplorerController(Session session) {
		super(session);
		focusedTab = FocusedTab.SCRIPTS;
	}

	/**
	 * 
	 * this enum is used to know which tab must opened when the explorer shows
	 *
	 */

	public enum FocusedTab {
		SCRIPTS, PLUGINS, SETTINGS;
	}

	/**
	 * 
	 * this function is used to tell which tab will get the focus
	 * 
	 */

	public void setFocusedTab(FocusedTab focusedTab) {
		this.focusedTab = focusedTab;
	}

	/**
	 * 
	 * @return the view of our explorer
	 * 
	 */

	@Override
	public ExplorerView view() {
		return view == null ? (view = new ExplorerView(this)) : view;
	}

	/**
	 * 
	 * this function is used to show the explorer frame
	 * 
	 */

	@Override
	public void show() {
		view().getTabbedPanes().setSelectedIndex(getSelectedTabIndex());
		view().component().setVisible(true);
	}

	/**
	 * 
	 * @return the index corresponding to the tabbed pane that must be opened
	 * 
	 */

	private int getSelectedTabIndex() {
		switch (focusedTab) {
		case SCRIPTS:
			return 0;
		case PLUGINS:
			return 1;
		case SETTINGS:
			return 2;
		default:
			return 0;
		}
	}
}
