package finals.group3.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class main extends JFrame {

	// panel
	private JPanel paneline = new JPanel();

	// components of main
	private JButton btnhome = new JButton("Home");
	private JButton btnlist = new JButton("Customer Service");
	private JButton btncreate = new JButton("Create New Account");
	private JButton btnlogout = new JButton("Logout");

	// time and date

	private Timer timedate;
	private JLabel timelabel = new JLabel();
	private JLabel datelabel = new JLabel();

	// design upper part

	private JPanel upperpartcardLayout = new JPanel();

	private JPanel panelhomelabel = new JPanel();
	private JPanel panelcreatelabel = new JPanel();
	private JPanel panelserviceslabel = new JPanel();

	private JLabel homelabel = new JLabel("Welcome to Ez Monies");
	private JLabel createlabel = new JLabel("Create New Account");
	private JLabel serviceslabel = new JLabel("Customer Service");

	// Declarations for Create Account Panel
	private JPanel panelbox1 = new JPanel();
	private JPanel panelbox2 = new JPanel();

	private JLabel lastnamelabel = new JLabel("Last Name:");
	private JLabel givenamelabel = new JLabel("Given Name:");
	private JLabel midnamelabel = new JLabel("Middle Name:");
	private JLabel genderlabel = new JLabel("Gender:");
	private JLabel agelabel = new JLabel("Age:");
	private JLabel phonenumlabel = new JLabel("Phone Number:");
	private JLabel addresslabel = new JLabel("Address:");
	private JLabel accountypelabel = new JLabel("Account Type:");
	private JLabel idlabel = new JLabel("Account ID:");

	private JTextField lastnameText = new JTextField();
	private JTextField givenameText = new JTextField();
	private JTextField midnameText = new JTextField();
	private JTextField idText = new JTextField();
	private JTextField ageText = new JTextField();
	private JTextField addressText = new JTextField();
	private JTextField phonenumText = new JTextField();

	public static JRadioButton femaleB = new JRadioButton("Female");
	public static JRadioButton maleB = new JRadioButton("Male");
	public static ButtonGroup bg = new ButtonGroup();

	public static JRadioButton checkB = new JRadioButton("Checking Account");
	public static JRadioButton saveB = new JRadioButton("Savings Account");
	public static ButtonGroup Bg = new ButtonGroup();

	private JButton btncreateacc = new JButton("Create");
	private JButton btnclear = new JButton("Clear");

	// Declarations for Customer Services Panel

	private JButton btnupdate = new JButton("Update Account");
	private JButton btndelete = new JButton("Delete Account");
	private JButton btnsearch = new JButton("Search");

	private JTextField searchText = new JTextField();

	private JLabel searchlabel = new JLabel("Search Account ID");

	// Model for storing data
	public static JScrollPane scrollPane = new JScrollPane();
	public static DefaultTableModel accountInfomodel;
	public static JTable tableinfo = new JTable();

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	private static loginForm mainhome;
	private static AccountSettings accountsettings;

	main() {

		// icons
		ImageIcon lg = new ImageIcon("images/ezmoniesmain.png");
		JLabel label = new JLabel(lg);

		ImageIcon ul = new ImageIcon("images/homepic.png");
		JLabel label1 = new JLabel(ul);

		ImageIcon aj = new ImageIcon("images/createaccimage.png");
		JLabel label2 = new JLabel(aj);

		ImageIcon sj = new ImageIcon("images/calendaricon.png");
		JLabel label3 = new JLabel(sj);

		setTitle(" EZ MONIES ATM MANAGEMENT SYSTEM ");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setSize(new Dimension(1450, 700));
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Date time = new Date();
				DateFormat timeformat = new SimpleDateFormat("hh:mm:ss a");
				String time1 = timeformat.format(time);
				timelabel.setText(time1);

				Date date = new Date();
				DateFormat timeformat1 = new SimpleDateFormat("MMMM dd, yyyy");
				String time2 = timeformat1.format(date);
				datelabel.setText(time2);
			}
		};

		timedate = new Timer(1000, actionListener);
		timedate.setInitialDelay(0);
		timedate.start();

		int logoheight = 200; // ezmonies logo
		int logowidth = 230;
		label.setSize(logowidth, logoheight);
		label.setOpaque(false);
		label.setBounds(0, 0, logowidth, logoheight);
		add(label);

		int logoheight1 = 620; // home pic
		int logowidth1 = 1100;
		label1.setSize(logowidth1, logoheight1);
		label1.setOpaque(false);
		label1.setBounds(0, 0, logowidth1, logoheight1);
		add(label1);

		int logoheight2 = 450; // create acc pic
		int logowidth2 = 1450;
		label2.setSize(logowidth2, logoheight2);
		label2.setOpaque(false);
		label2.setBounds(0, 0, logowidth2, logoheight2);
		add(label2);

		int logoheight3 = 105; // calendar and time icon
		int logowidth3 = 1950;
		label3.setSize(logowidth3, logoheight3);
		label3.setOpaque(false);
		label3.setBounds(0, 0, logowidth3, logoheight3);
		add(label3);

		// -----panels-------

		// main panel
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(187, 222, 251));
				Color color2 = (new Color(0, 78, 137));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);

			}
		};

		// panel cardlayout
		JPanel panelCardLayout = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(187, 222, 251));
				Color color2 = (new Color(0, 78, 137));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);

			}
		};

		JPanel homePanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(187, 222, 251));
				Color color2 = (new Color(0, 78, 137));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);

			}
		};

		JPanel createPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(187, 222, 251));
				Color color2 = (new Color(0, 78, 137));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);

			}
		};

		JPanel servicesPanel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(187, 222, 251));
				Color color2 = (new Color(0, 78, 137));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);

			}
		};

		// sidepart design
		JPanel panel1 = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(0, 4, 58));
				Color color2 = (new Color(0, 41, 98));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);

			}
		};

		// upperpartdesign
		JPanel panel2 = new JPanel() {
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

		panel.add(btnhome);
		panel.add(btnlist);
		panel.add(btncreate);
		panel.add(btnlogout);
		panel.add(timelabel);
		panel.add(datelabel);
		panel.add(paneline);
		panel.add(panel1);
		panel.add(upperpartcardLayout);
		panel.add(panel2);
		panel.add(panelCardLayout);
		panel.add(homePanel);
		panel.add(createPanel);
		panel.add(servicesPanel);

		// dashboard design

		panel1.setBounds(0, 0, 230, 700);
		panel1.add(label); // ezmonies logo sa panel1

		paneline.setBounds(0, 215, 230, 5);
		paneline.setBackground(new Color(192, 142, 49));

		panel2.setBounds(0, 0, 1450, 110);

		// labels for time and date

		timelabel.setBounds(1010, 40, 377, 64);
		timelabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		timelabel.setForeground(Color.WHITE);

		datelabel.setBounds(1010, 20, 376, 44);
		datelabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 25));
		datelabel.setForeground(Color.WHITE);

		// panel cardlayout upper design para madetermine kung anong section ng
		// mainframe

		upperpartcardLayout.setBounds(230, 16, 538, 80);
		upperpartcardLayout.setLayout(new CardLayout(0, 0));

		// home panel label

		panelhomelabel.setBounds(230, 16, 538, 80);
		panelhomelabel.setBackground(Color.WHITE);
		upperpartcardLayout.add(panelhomelabel, "name_235961188975000");
		panelhomelabel.setLayout(null);

		homelabel.setBounds(25, 0, 538, 80);
		homelabel.setForeground(new Color(0, 41, 98));
		homelabel.setFont(new Font("Times New Roman", Font.BOLD, 50));

		panelhomelabel.add(homelabel);

		// create account panel label

		panelcreatelabel.setBounds(230, 16, 538, 80);
		panelcreatelabel.setBackground(Color.WHITE);
		upperpartcardLayout.add(panelcreatelabel, "name_235985543088400");
		panelcreatelabel.setLayout(null);

		createlabel.setBounds(50, 0, 538, 80);
		createlabel.setForeground(new Color(0, 41, 98));
		createlabel.setFont(new Font("Times New Roman", Font.BOLD, 50));

		panelcreatelabel.add(createlabel);

		// customer services panel label

		panelserviceslabel.setBounds(230, 16, 538, 80);
		panelserviceslabel.setBackground(Color.WHITE);
		upperpartcardLayout.add(panelserviceslabel, "name_235985543088400");
		panelserviceslabel.setLayout(null);

		serviceslabel.setBounds(80, 0, 538, 80);
		serviceslabel.setForeground(new Color(0, 41, 98));
		serviceslabel.setFont(new Font("Times New Roman", Font.BOLD, 50));

		panelserviceslabel.add(serviceslabel);

		// another panel, eto yung nagsisilbing cardlayout kung saan patong
		// patong yung panels
		// cardlayout means, isang visible component lang at a time
		panelCardLayout.setBounds(230, 110, 1450, 700);
		panelCardLayout.setLayout(new CardLayout(0, 0));

		homePanel.setBounds(0, 0, 1450, 700);
		panelCardLayout.add(homePanel, "name_72357597388000");

		homePanel.setLayout(null);
		homePanel.add(label1); // home picture sa homePanel

		createPanel.setBounds(0, 0, 1450, 700);
		panelCardLayout.add(createPanel, "name_72480943099300");
		createPanel.setLayout(null);

		createPanel.add(label2);

		servicesPanel.setBounds(0, 0, 1450, 700);
		panelCardLayout.add(servicesPanel, "name_72492409833500");
		servicesPanel.setLayout(null);

		// ===== customer services panel components =====

		// dito dapat yung maselect na row ay may lalabas na frame then andon
		// yung details ng customer at andon din yung print receipt
		// pati yung withdraw and deposit andon din sa frame na yon
		btnupdate.setBounds(870, 40, 150, 49);
		btnupdate.setFocusable(false);
		btnupdate.setFont(new Font("Leelawadee", Font.BOLD, 17));
		btnupdate.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0,
				0)));
		btnupdate.setBackground(new Color(0, 78, 137));
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int index = tableinfo.getSelectedRow();
				TableModel mod = tableinfo.getModel();

				String id = mod.getValueAt(index, 0).toString();
				String last = mod.getValueAt(index, 1).toString();
				String given = mod.getValueAt(index, 2).toString();
				String mid = mod.getValueAt(index, 3).toString();
				String age = mod.getValueAt(index, 4).toString();
				String gender = mod.getValueAt(index, 5).toString();
				String num = mod.getValueAt(index, 6).toString();
				String add = mod.getValueAt(index, 7).toString();
				String account = mod.getValueAt(index, 8).toString();
				String balance = mod.getValueAt(index, 9).toString();
				String date = mod.getValueAt(index, 10).toString();

				accountsettings = new AccountSettings();
				accountsettings.setVisible(true);
				accountsettings.setDefaultCloseOperation(EXIT_ON_CLOSE);

				accountsettings.idtext.setText(id);
				accountsettings.lastnametext.setText(last);
				accountsettings.givenametext.setText(given);
				accountsettings.midnametext.setText(mid);
				accountsettings.agetext.setText(age);
				accountsettings.gendertext.setText(gender);
				accountsettings.phonenumtext.setText(num);
				accountsettings.addresstext.setText(add);
				accountsettings.accountext.setText(account);
				accountsettings.balanceText.setText(balance);
				accountsettings.datetext.setText(date);

			}
		});

		// function neto para maremove yung specific account
		btndelete.setBounds(870, 100, 150, 49);
		btndelete.setFocusable(false);
		btndelete.setFont(new Font("Leelawadee", Font.BOLD, 17));
		btndelete.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0,
				0)));
		btndelete.setBackground(new Color(0, 78, 137));
		btndelete.setForeground(Color.WHITE);
		btndelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel mod = (DefaultTableModel) tableinfo
						.getModel();
				int row = tableinfo.getSelectedRow();
				String id = mod.getValueAt(row, 0).toString();
				if (row >= 0) {
					mod.removeRow(row);
					try {

						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/database", "root",
								"YamYam25");
						stmt = conn.createStatement();
						String query = "delete from `accounts` WHERE `Account Id` =('"
								+ id + "')";
						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(panel,
								"Account deleted successfully.");
					} catch (SQLException excep) {
						excep.printStackTrace();
					} catch (Exception excep) {
						excep.printStackTrace();
					} finally {
						try {
							if (stmt != null)
								conn.close();
						} catch (SQLException se) {
						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}
				}

				tableinfo
						.setModel(new DefaultTableModel(new Object[][] {},
								new String[] { "Account Id", "Last Name",
										"Given Name", "Middle Name", "Age",
										"Gender", "Phone Number", "Address",
										"Account Type", "Balance", "Date" }) {
							Class[] columnTypes = new Class[] { String.class,
									String.class, String.class, String.class,
									String.class, String.class, String.class,
									String.class, String.class, String.class,
									String.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}

							boolean[] columnEditables = new boolean[] { true,
									true, true, true, true, true, true, true,
									true, true, true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				scrollPane.setViewportView(tableinfo);

				try {
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/database", "root",
							"YamYam25");
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from accounts");
					ArrayList<String> list;
					Vector<String> vector;
					while (rs.next()) {
						list = new ArrayList<String>();
						for (int i = 0; i < 1; i++) {
							list.add(rs.getString("Account ID"));
							list.add(rs.getString("Last Name"));
							list.add(rs.getString("Given Name"));
							list.add(rs.getString("Middle Name"));
							list.add(rs.getString("Age"));
							list.add(rs.getString("Gender"));
							list.add(rs.getString("Phone Number"));
							list.add(rs.getString("Address"));
							list.add(rs.getString("Account Type"));
							list.add(rs.getString("Balance"));
							list.add(rs.getString("Date"));

							vector = new Vector<String>(list);
							DefaultTableModel model = (DefaultTableModel) tableinfo
									.getModel();
							model.addRow(vector);
						}
					}
				} catch (Exception exc) {
					exc.printStackTrace();
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e1) {

						}
					}
				}
			}
		});

		servicesPanel.add(scrollPane);
		servicesPanel.add(btnupdate);
		servicesPanel.add(btndelete);
		servicesPanel.add(btnsearch);
		servicesPanel.add(searchText);
		servicesPanel.add(searchlabel);

		// ===== create account components =====

		scrollPane.setBounds(20, 20, 820, 510);

		panelbox1.setBounds(50, 30, 384, 495);
		panelbox1.setBorder(new MatteBorder(0, 5, 5, 0, (Color) new Color(144,
				202, 249)));
		panelbox1.setOpaque(false);

		// panelbox2 for account id

		panelbox2.setBounds(80, 30, 330, 120);
		panelbox2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(144,
				202, 249)));
		panelbox2.setOpaque(false);

		idlabel.setBounds(110, 70, 379, 55);
		idlabel.setForeground(Color.black);
		idlabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		idText.setBounds(220, 80, 160, 26);
		idText.setForeground(new Color(0, 78, 137));
		idText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		idText.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		idText.setEditable(false);

		lastnamelabel.setBounds(90, 155, 379, 55);
		lastnamelabel.setForeground(Color.black);
		lastnamelabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		lastnameText.setBounds(220, 165, 160, 26);
		lastnameText.setForeground(Color.black);
		lastnameText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		lastnameText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		lastnameText.setOpaque(false);

		givenamelabel.setBounds(90, 195, 379, 55);
		givenamelabel.setForeground(Color.black);
		givenamelabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		givenameText.setBounds(220, 205, 160, 26);
		givenameText.setForeground(Color.black);
		givenameText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		givenameText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		givenameText.setOpaque(false);

		midnamelabel.setBounds(90, 235, 379, 55);
		midnamelabel.setForeground(Color.black);
		midnamelabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		midnameText.setBounds(220, 245, 160, 26);
		midnameText.setForeground(Color.black);
		midnameText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		midnameText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		midnameText.setOpaque(false);

		genderlabel.setBounds(90, 275, 379, 55);
		genderlabel.setForeground(Color.black);
		genderlabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		femaleB.setBounds(220, 290, 100, 26);
		femaleB.setForeground(Color.black);
		femaleB.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		femaleB.setOpaque(false);

		maleB.setBounds(320, 290, 160, 26);
		maleB.setForeground(Color.black);
		maleB.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		maleB.setOpaque(false);

		// Button group para pagsamahin
		bg.add(femaleB);
		bg.add(maleB);

		agelabel.setBounds(90, 315, 379, 55);
		agelabel.setForeground(Color.black);
		agelabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		ageText.setBounds(220, 325, 160, 26);
		ageText.setForeground(Color.black);
		ageText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		ageText.setBorder(new MatteBorder(0, 0, 1, 0,
				(Color) new Color(0, 0, 0)));
		ageText.setOpaque(false);

		phonenumlabel.setBounds(90, 355, 379, 55);
		phonenumlabel.setForeground(Color.black);
		phonenumlabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		phonenumText.setBounds(220, 365, 160, 26);
		phonenumText.setForeground(Color.black);
		phonenumText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		phonenumText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		phonenumText.setOpaque(false);

		addresslabel.setBounds(90, 395, 379, 55);
		addresslabel.setForeground(Color.black);
		addresslabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		addressText.setBounds(220, 405, 160, 26);
		addressText.setForeground(Color.black);
		addressText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		addressText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		addressText.setOpaque(false);

		accountypelabel.setBounds(90, 440, 379, 55);
		accountypelabel.setForeground(Color.black);
		accountypelabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		checkB.setBounds(220, 450, 160, 26);
		checkB.setForeground(Color.black);
		checkB.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		checkB.setOpaque(false);

		saveB.setBounds(220, 480, 160, 26);
		saveB.setForeground(Color.black);
		saveB.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		saveB.setOpaque(false);

		// Button group para pagsamahin
		Bg.add(checkB);
		Bg.add(saveB);

		btncreateacc.setBounds(500, 460, 224, 49);
		btncreateacc.setFocusable(false);
		btncreateacc.setFont(new Font("Leelawadee", Font.BOLD, 17));
		btncreateacc.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0,
				0, 0)));
		btncreateacc.setBackground(new Color(0, 78, 137));
		btncreateacc.setForeground(Color.WHITE);
		btncreateacc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btncreateacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gender = " ";
				String account = " ";
				String balance = "0";
				String id = idText.getText();
				String last = lastnameText.getText();
				String given = givenameText.getText();
				String mid = midnameText.getText();
				String age = ageText.getText();
				String num = phonenumText.getText();
				String add = addressText.getText();
				String date = datelabel.getText();

				if (femaleB.isSelected())
					gender = "Female";
				else if (maleB.isSelected())
					gender = "Male";
				if (checkB.isSelected())
					account = "Checking Account";
				else if (saveB.isSelected())
					account = "Savings Account";

				if (id.trim().equals("") || last.trim().equals("")
						|| given.trim().equals("") || mid.trim().equals("")
						|| age.trim().equals("") || num.trim().equals("")
						|| add.trim().equals("")) {
					JOptionPane
							.showMessageDialog(panel, "Please input fields.");
				} else {

					try { // database for create account insert into accounts
							// table in mysql workbench

						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/database", "root",
								"YamYam25");
						stmt = conn.createStatement();
						String query = "insert into `accounts`(`Account Id`,`Last Name`, `Given Name`, `Middle Name`, `Age`, `Gender`, `Phone Number`, `Address`, `Account Type`, `Balance`, `Date`) "
								+ "values ('"
								+ id
								+ "','"
								+ last
								+ "','"
								+ given
								+ "','"
								+ mid
								+ "','"
								+ age
								+ "','"
								+ gender
								+ "','"
								+ num
								+ "','"
								+ add
								+ "','"
								+ account
								+ "','"
								+ balance + "','" + date + "')";

						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(panel,
								"Account added successfully.");

						idText.setText(null);
						int accId = 7809 + (int) (Math.random() * 123456);
						String Id = "";
						Id += accId + 12345;
						idText.setText(Id);
						lastnameText.setText(null);
						givenameText.setText(null);
						midnameText.setText(null);
						ageText.setText(null);
						phonenumText.setText(null);
						addressText.setText(null);
						lastnameText.setText("");
						givenameText.setText("");
						midnameText.setText("");
						ageText.setText("");
						phonenumText.setText("");
						addressText.setText("");

					} catch (SQLException excep) {
						excep.printStackTrace();
					} catch (Exception excep) {
						excep.printStackTrace();
					} finally {
						try {
							if (stmt != null)
								conn.close();
						} catch (SQLException se) {
						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}
				}

				tableinfo
						.setModel(new DefaultTableModel(new Object[][] {},
								new String[] { "Account Id", "Last Name",
										"Given Name", "Middle Name", "Age",
										"Gender", "Phone Number", "Address",
										"Account Type", "Balance", "Date" }) {
							Class[] columnTypes = new Class[] { String.class,
									String.class, String.class, String.class,
									String.class, String.class, String.class,
									String.class, String.class, String.class,
									String.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}

							boolean[] columnEditables = new boolean[] { true,
									true, true, true, true, true, true, true,
									true, true, true };

							public boolean isCellEditable(int row, int column) {
								return columnEditables[column];
							}
						});
				scrollPane.setViewportView(tableinfo);

				try {
					conn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/database", "root",
							"YamYam25");
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from accounts");
					ArrayList<String> list;
					Vector<String> vector;
					while (rs.next()) {
						list = new ArrayList<String>();
						for (int i = 0; i < 1; i++) {
							list.add(rs.getString("Account ID"));
							list.add(rs.getString("Last Name"));
							list.add(rs.getString("Given Name"));
							list.add(rs.getString("Middle Name"));
							list.add(rs.getString("Age"));
							list.add(rs.getString("Gender"));
							list.add(rs.getString("Phone Number"));
							list.add(rs.getString("Address"));
							list.add(rs.getString("Account Type"));
							list.add(rs.getString("Balance"));
							list.add(rs.getString("Date"));

							vector = new Vector<String>(list);
							DefaultTableModel model = (DefaultTableModel) tableinfo
									.getModel();
							model.addRow(vector);
						}
					}
				} catch (Exception exc) {
					exc.printStackTrace();
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e1) {

						}
					}
				}
			}
		});

		btnclear.setBounds(770, 460, 224, 49);
		btnclear.setFocusable(false);
		btnclear.setFont(new Font("Leelawadee", Font.BOLD, 17));
		btnclear.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0,
				0)));
		btnclear.setBackground(new Color(0, 78, 137));
		btnclear.setForeground(Color.WHITE);
		btnclear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// eto para sa account id pagnapressed yung btnclear automatic
				// may ipapalit na account id
				int accId = 7809 + (int) (Math.random() * 123456);
				String Id = "";
				Id += accId + 12345;

				idText.setText("");
				idText.setEnabled(false);
				idText.setText(Id);

				lastnameText.setText("");
				givenameText.setText("");
				midnameText.setText("");
				ageText.setText("");
				phonenumText.setText("");
				addressText.setText("");

			}
		});

		createPanel.add(panelbox1);
		createPanel.add(panelbox2);
		createPanel.add(lastnamelabel);
		createPanel.add(givenamelabel);
		createPanel.add(midnamelabel);
		createPanel.add(genderlabel);
		createPanel.add(agelabel);
		createPanel.add(phonenumlabel);
		createPanel.add(addresslabel);
		createPanel.add(accountypelabel);
		createPanel.add(idlabel);
		createPanel.add(lastnameText);
		createPanel.add(givenameText);
		createPanel.add(midnameText);
		createPanel.add(femaleB);
		createPanel.add(maleB);
		createPanel.add(ageText);
		createPanel.add(phonenumText);
		createPanel.add(addressText);
		createPanel.add(idText);
		createPanel.add(checkB);
		createPanel.add(saveB);
		createPanel.add(btncreateacc);
		createPanel.add(btnclear);

		// buttons

		btnhome.setBounds(0, 230, 230, 98);
		btnhome.setFocusable(false);
		btnhome.setOpaque(false);
		btnhome.setBackground(Color.WHITE);
		btnhome.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(202,
				233, 255)));
		btnhome.setForeground(Color.WHITE);
		btnhome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnhome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btncreate.setBounds(0, 329, 230, 98);
		btncreate.setFocusable(false);
		btncreate.setOpaque(false);
		btncreate.setBackground(Color.WHITE);
		btncreate.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(202,
				233, 255)));
		btncreate.setForeground(Color.WHITE);
		btncreate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btncreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnlist.setBounds(0, 428, 230, 98);
		btnlist.setFocusable(false);
		btnlist.setOpaque(false);
		btnlist.setBackground(Color.WHITE);
		btnlist.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(202,
				233, 255)));
		btnlist.setForeground(Color.WHITE);
		btnlist.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnlogout.setBounds(0, 526, 230, 98);
		btnlogout.setFocusable(false);
		btnlogout.setOpaque(false);
		btnlogout.setBackground(Color.WHITE);
		btnlogout.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(202,
				233, 255)));
		btnlogout.setForeground(Color.WHITE);
		btnlogout.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnlogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Home function

		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// removing panel
				panelCardLayout.removeAll();
				panelCardLayout.repaint();
				panelCardLayout.revalidate();

				// adding panel
				panelCardLayout.add(homePanel);
				panelCardLayout.repaint();
				panelCardLayout.revalidate();

				// removing panel
				upperpartcardLayout.removeAll();
				upperpartcardLayout.repaint();
				upperpartcardLayout.revalidate();

				// adding panel
				upperpartcardLayout.add(panelhomelabel);
				upperpartcardLayout.repaint();
				upperpartcardLayout.revalidate();

			}
		});

		// Create function
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// removing panel
				panelCardLayout.removeAll();
				panelCardLayout.repaint();
				panelCardLayout.revalidate();

				// adding panel
				panelCardLayout.add(createPanel);
				panelCardLayout.repaint();
				panelCardLayout.revalidate();

				// removing panel
				upperpartcardLayout.removeAll();
				upperpartcardLayout.repaint();
				upperpartcardLayout.revalidate();

				// adding panel
				upperpartcardLayout.add(panelcreatelabel);
				upperpartcardLayout.repaint();
				upperpartcardLayout.revalidate();

				// instant account number

				int accId = 7809 + (int) (Math.random() * 123456);
				String Id = "";
				Id += accId + 12345;

				idText.setText(null);
				idText.setEnabled(false);
				idText.setText(Id);

			}
		});

		// Services function

		btnlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// removing panel
				panelCardLayout.removeAll();
				panelCardLayout.repaint();
				panelCardLayout.revalidate();

				// adding panel
				panelCardLayout.add(servicesPanel);
				panelCardLayout.repaint();
				panelCardLayout.revalidate();

				// removing panel
				upperpartcardLayout.removeAll();
				upperpartcardLayout.repaint();
				upperpartcardLayout.revalidate();

				// adding panel
				upperpartcardLayout.add(panelserviceslabel);
				upperpartcardLayout.repaint();
				upperpartcardLayout.revalidate();

			}
		});

		// Logout function
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int out = JOptionPane.showConfirmDialog(panel,
						"Are you sure to logout?", "Exiting the system",
						JOptionPane.YES_NO_OPTION);

				if (out == JOptionPane.YES_OPTION) {
					mainhome = new loginForm();
					dispose();

				} else if (out == JOptionPane.NO_OPTION) {

					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});

	}
}
