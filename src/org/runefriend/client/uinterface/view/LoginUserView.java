package org.runefriend.client.uinterface.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.stream.IntStream;
import org.runefriend.client.uinterface.components.ImagesJPanel;
import org.runefriend.client.uinterface.components.FlatButton;
import org.runefriend.client.uinterface.components.ImageButton;

import org.runefriend.client.uinterface.images.Images;
import org.runefriend.client.uinterface.utility.UICreator;
import org.runefriend.client.uinterface.utility.FrameMover;
import org.runefriend.client.uinterface.utility.UIConstants;
import org.runefriend.client.uinterface.controller.impl.UserLoginController;

/**
 * 
 * @author Malik
 *
 */

@SuppressWarnings({ "unused", "serial" })
public class LoginUserView extends BaseView<UserLoginController, JFrame> {

	/**
	 * 
	 * our fields
	 * 
	 */

	private JFrame loginFrame;
	private JPanel frameContainer;
	private ButtonHandler handler;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * 
	 * create a view that will allow a user to login
	 * 
	 */

	public LoginUserView(UserLoginController presenter) {
		super(presenter);
		loginFrame = new JFrame();
		handler = new ButtonHandler();
		frameContainer = new ImagesJPanel(Images.BACKGROUND.getImage());

		loginFrame.setUndecorated(true);
		loginFrame.setIconImage(Images.TEAM_LOGO.getImage());
		frameContainer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		loginFrame.setContentPane(frameContainer);
		LogoPanel logoPanel = new LogoPanel();
		logoPanel.setPreferredSize(new Dimension(260,60));
		JPanel dataPanel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		usernameField = new JTextField("Username", 16) {
			public void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);
				graphics.drawImage(Images.USER.getImage(), 160, 3, null);
			}
		};
		usernameField.setForeground(Color.WHITE);
		usernameField.setMinimumSize(new Dimension(150, 35));
		usernameField.setHorizontalAlignment(JTextField.CENTER);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.insets = new Insets(0, 10, 5, 10);
		dataPanel.add(usernameField, cs);

		passwordField = new JPasswordField("Password", 16) {
			public void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);
				graphics.drawImage(Images.PASS.getImage(), 160, 3, null);
			}
		};
		passwordField.setHorizontalAlignment(JPasswordField.CENTER);
		passwordField.setMinimumSize(new Dimension(150, 25));
		cs.gridx = 1;
		cs.gridy = 1;
		cs.insets = new Insets(0, 10, 5, 10);
		dataPanel.add(passwordField, cs);

		JPanel buttonsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints cs1 = new GridBagConstraints();

		JCheckBox keepLoggedInCb = new JCheckBox() {
			public void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);
				graphics.setColor(Color.BLACK);
				graphics.setFont(new Font("Sans Serif", Font.PLAIN, 13));
				graphics.drawString("Remember me", 31, 15);
			}
		};
		keepLoggedInCb.setOpaque(false);
		keepLoggedInCb.setFocusPainted(false);
		keepLoggedInCb.setForeground(Color.BLACK);
		keepLoggedInCb.setMinimumSize(new Dimension(130, 20));
		keepLoggedInCb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
		keepLoggedInCb.setText(new String(new char["Remember me".toCharArray().length + 18]).replace('\0', ' '));
		cs1.gridx = 1;
		cs1.gridy = 0;
		cs1.insets = new Insets(-20, 0, 0, 0);
		buttonsPanel.add(keepLoggedInCb, cs1);

		ImageButton loginButton = new ImageButton(Images.HLOGIN_BUTTON.getImage(), Images.LOGIN_BUTTON.getImage());
		loginButton.setName("loginButton");
		loginButton.addMouseListener(handler);
		loginButton.setForeground(Color.WHITE);
		cs1.gridx = 1;
		cs1.gridy = 1;
		cs1.insets = new Insets(10, 0, 0, 0);
		buttonsPanel.add(loginButton, cs1);

		logoPanel.setOpaque(false);
		dataPanel.setOpaque(false);
		buttonsPanel.setOpaque(false);
		loginFrame.getContentPane().add(logoPanel, BorderLayout.NORTH);
		loginFrame.getContentPane().add(dataPanel, BorderLayout.CENTER);
		loginFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		JMenuBar bar = UICreator.createFrameBar(handler, new Dimension(110, 30),
				String.format("%s login", UIConstants.CLIENT_NAME));
		FrameMover mover = new FrameMover(loginFrame);
		bar.addMouseMotionListener(mover);
		bar.addMouseListener(mover);

		loginFrame.setResizable(false);
		loginFrame.setJMenuBar(bar);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setPreferredSize(new Dimension(260, 280));
		loginFrame.pack();

	}

	/**
	 * 
	 * @return the jframe of our login interface view
	 * 
	 */

	@Override
	public JFrame component() {
		return loginFrame;
	}

	/**
	 * 
	 * @author MalikDz
	 *
	 */

	public class LogoPanel extends JPanel {

		/**
		 * 
		 * our fields and constants
		 * 
		 */

		private static final long serialVersionUID = 1L;

		/**
		 * 
		 * the function where the status is being paint
		 * 
		 */

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawTitleText(g);
		}

		/**
		 * 
		 * this function is used to draw our team logo
		 * 
		 */

		private void drawTeamLogo(Graphics g) {
			Image logo = Images.TEAM_LOGO.getImage();
			int x = (getWidth() - logo.getWidth(null)) / 2;
			g.drawImage(logo, x, 15, null);
		}

		/***
		 * 
		 * this function is used to draw our indication message in the center
		 * 
		 */

		private void drawTitleText(Graphics g) {
			Image textImage = Images.LOGIN_TEXT.getImage();
			int x = (getWidth() - textImage.getWidth(null)) / 2;
			g.drawImage(textImage, x, 0, null);
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
			case "closeButton":
				controller().end();
				break;
			case "loginButton":
				controller().login();
				break;
			case "minimizeButton":
				controller().minimize();
				break;
			}
		}
	}
}