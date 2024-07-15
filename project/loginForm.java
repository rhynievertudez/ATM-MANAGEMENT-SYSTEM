package finals.group3.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;
import java.util.HashMap;

public class loginForm extends JFrame {

	private static JPanel paneline = new JPanel();

	private JLabel userlabel = new JLabel("Username");
	private JLabel passwordlabel = new JLabel("Password");

	private JButton btnlogin = new JButton("Login");

	private JTextField userText = new JTextField();

	private JCheckBox showpass = new JCheckBox("Show Password");

	private JPasswordField passwordText = new JPasswordField();

	private main mainframe;

	loginForm() {

		setTitle(" Welcome Admin ");
		ImageIcon lg = new ImageIcon("images/ezmoniesblue.png");
		JLabel label = new JLabel(lg);
		ImageIcon ul = new ImageIcon("images/usericon.png");
		JLabel label1 = new JLabel(ul);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setSize(new Dimension(712, 448));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

		int logoheight = 480; // ezmonies logo
		int logowidth = 400;
		label.setSize(logowidth, logoheight);
		label.setOpaque(false);
		label.setBounds(0, 0, logowidth, logoheight);
		add(label);

		int logoheight1 = 200; // userlogo
		int logowidth1 = 1100;
		label1.setSize(logowidth1, logoheight1);
		label1.setOpaque(false);
		label1.setBounds(0, 0, logowidth1, logoheight1);
		add(label1);

		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(0, 58, 107));
				Color color2 = (new Color(137, 207, 241));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);
			}
		};

		JPanel panelbox1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(0, 4, 58));
				Color color2 = (new Color(0, 78, 137));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);
			}
		};
		add(panel);
		panel.setLayout(null);

		panel.add(label);
		panel.add(label1);
		panel.add(paneline);
		panel.add(userlabel);
		panel.add(passwordlabel);
		panel.add(userText);
		panel.add(passwordText);
		panel.add(showpass);
		panel.add(btnlogin);
		panel.add(panelbox1);

		paneline.setBounds(-387, 0, 1090, 15);
		paneline.setBackground(new Color(192, 142, 49));

		panelbox1.setBounds(361, 15, 340, 450);
		panelbox1.setForeground(Color.WHITE);

		userlabel.setBounds(420, 170, 78, 26);
		userlabel.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		userlabel.setForeground(Color.WHITE);

		passwordlabel.setBounds(420, 250, 78, 14);
		passwordlabel.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		passwordlabel.setForeground(Color.WHITE);

		HashMap<String, String> LOGIN = new HashMap<String, String>();

		LOGIN.put("alpha", "windows1");
		LOGIN.put("bravo", "windows2");
		LOGIN.put("charlie", "windows3");

		userText.setBounds(420, 200, 260, 20);
		userText.setOpaque(false);
		userText.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		userText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192,
				142, 49)));
		userText.setBackground(Color.WHITE);
		userText.setForeground(Color.WHITE);
		userText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				String UserIN = userText.getText();
				String PassIN = passwordText.getText();

				String PassValidation = LOGIN.get(UserIN);

				if (e.getKeyCode() == 10) {
					if (userText.getText().equals("")
							|| passwordText.getText().equals("")) {
						JOptionPane
								.showMessageDialog(panel,
										"Please input username and password, Thank you");

					} else if (LOGIN.containsKey(UserIN)
							&& PassIN.equals(PassValidation)) {
						JOptionPane.showMessageDialog(panel,
								" You've succesfully Login Admin! ");

						mainframe = new main();
						dispose();
					} else {
						JOptionPane
								.showMessageDialog(
										panel,
										"Sorry, invalid username or password. Please try again",
										"Validation", JOptionPane.ERROR_MESSAGE);
					}
					userText.requestFocus(true);
					userText.setText("");
					passwordText.setText("");
				}
			}
		});

		passwordText.setBounds(420, 270, 260, 20);
		passwordText.setOpaque(false);
		passwordText.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		passwordText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(
				192, 142, 49)));
		passwordText.setBackground(Color.WHITE);
		passwordText.setForeground(Color.WHITE);
		passwordText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				String UserIN = userText.getText();
				String PassIN = passwordText.getText();

				String PassValidation = LOGIN.get(UserIN);

				if (e.getKeyCode() == 10) {
					if (userText.getText().equals("")
							|| passwordText.getText().equals("")) {
						JOptionPane
								.showMessageDialog(panel,
										"Please input username and password, Thank you");

					} else if (LOGIN.containsKey(UserIN)
							&& PassIN.equals(PassValidation)) {
						JOptionPane.showMessageDialog(panel,
								" You've succesfully Login Admin! ");

						mainframe = new main();
						dispose();
					} else {
						JOptionPane
								.showMessageDialog(
										panel,
										"Sorry, invalid username or password. Please try again",
										"Validation", JOptionPane.ERROR_MESSAGE);
					}
					userText.requestFocus(true);
					userText.setText("");
					passwordText.setText("");
				}
			}
		});

		showpass.setBounds(420, 300, 130, 23);
		showpass.setOpaque(false);
		showpass.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		showpass.setForeground(Color.WHITE);
		showpass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showpass.isSelected()) {
					passwordText.setEchoChar((char) 0);
				} else {
					passwordText.setEchoChar('•');
				}
			}
		});

		btnlogin.setBounds(460, 330, 164, 45);
		btnlogin.setFocusable(false);
		btnlogin.setOpaque(false);
		btnlogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192,
				142, 49)));
		btnlogin.setBackground(Color.WHITE);
		btnlogin.setForeground(new Color(192, 142, 49));
		btnlogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String UserIN = userText.getText();
				String PassIN = passwordText.getText();

				String PassValidation = LOGIN.get(UserIN);

				if (userText.getText().equals("")
						|| passwordText.getText().equals("")) {
					JOptionPane.showMessageDialog(panel,
							"Please input username and password, Thank you");

				} else if (LOGIN.containsKey(UserIN)
						&& PassIN.equals(PassValidation)) {
					JOptionPane.showMessageDialog(panel,
							" You've succesfully Login Admin! ");

					mainframe = new main();
					dispose();
				} else {
					JOptionPane
							.showMessageDialog(
									panel,
									"Sorry, invalid username or password. Please try again",
									"Validation", JOptionPane.ERROR_MESSAGE);
				}
				userText.requestFocus(true);
				userText.setText("");
				passwordText.setText("");
			}
		});
	}

	public static void main(String[] args) {
		new loginForm();
	}
}
