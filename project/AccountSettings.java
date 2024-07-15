package finals.group3.project;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
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

public class AccountSettings extends JFrame {

	private JTextArea receipt = new JTextArea();

	private JPanel panelbuttons = new JPanel();
	private JButton saveBtn = new JButton("Save");
	private JButton printBtn = new JButton("Print");
	private JButton cancelBtn = new JButton("Cancel");

	private JPanel panellabel = new JPanel();
	private JPanel paneline = new JPanel();

	private Timer timedate;
	private JLabel timelabel = new JLabel();
	private JLabel datelabel = new JLabel();

	private JPanel paneline2 = new JPanel();
	private JPanel paneltransaction = new JPanel();
	private JLabel accountLabel = new JLabel("Account Settings");
	private JLabel lastnameLabel = new JLabel("Last Name:");
	private JLabel givenameLabel = new JLabel("Given Name:");
	private JLabel midnameLabel = new JLabel("Middle Name:");
	private JLabel genderLabel = new JLabel("Gender:");
	private JLabel ageLabel = new JLabel("Age:");
	private JLabel phonenumLabel = new JLabel("Phone Number:");
	private JLabel addressLabel = new JLabel("Address:");
	private JLabel accountypeLabel = new JLabel("Account Type:");
	private JLabel idLabel = new JLabel("Account ID:");
	private JLabel dateLabel = new JLabel("Transaction Date");

	public JTextField lastnametext = new JTextField();
	public JTextField givenametext = new JTextField();
	public JTextField midnametext = new JTextField();
	public JTextField idtext = new JTextField();
	public JTextField agetext = new JTextField();
	public JTextField gendertext = new JTextField();
	public JTextField addresstext = new JTextField();
	public JTextField accountext = new JTextField();
	public JTextField datetext = new JTextField();

	private JPanel panelboxbalance = new JPanel();
	private JLabel balanceLabel = new JLabel("Available Balance");
	public JTextField balanceText = new JTextField();

	public JTextField amountText = new JTextField();
	public JTextField phonenumtext = new JTextField();

	private JPanel panelamount = new JPanel();
	private JLabel amountLabel = new JLabel("Amount");
	public JButton depositBtn = new JButton("DEPOSIT");
	public JButton withdrawBtn = new JButton("WITHDRAW");
	public JTextField amount = new JTextField();

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public static main mainframe;

	AccountSettings() {

		setTitle(" Account Settings ");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setSize(new Dimension(1000, 650));
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
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

		JPanel panelinebottom = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
						RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();
				Color color1 = (new Color(144, 202, 249));
				Color color2 = (new Color(0, 78, 137));
				GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);

			}
		};

		add(panel);
		panel.setLayout(null);

		panel.add(accountLabel);
		panel.add(paneline);
		panel.add(paneline2);
		panel.add(panellabel);
		panel.add(datelabel);
		panel.add(timelabel);
		panel.add(panelinebottom);
		panel.add(saveBtn);
		panel.add(printBtn);
		panel.add(cancelBtn);
		panel.add(panelbuttons);
		panel.add(idLabel);
		panel.add(idtext);
		panel.add(lastnameLabel);
		panel.add(lastnametext);
		panel.add(givenameLabel);
		panel.add(givenametext);
		panel.add(midnameLabel);
		panel.add(midnametext);
		panel.add(ageLabel);
		panel.add(agetext);
		panel.add(genderLabel);
		panel.add(gendertext);
		panel.add(phonenumLabel);
		panel.add(phonenumtext);
		panel.add(addressLabel);
		panel.add(addresstext);
		panel.add(accountypeLabel);
		panel.add(balanceLabel);
		panel.add(balanceText);
		panel.add(panelboxbalance);
		panel.add(receipt);
		panel.add(amountLabel);
		panel.add(amountText);
		panel.add(panelamount);
		panel.add(depositBtn);
		panel.add(withdrawBtn);
		panel.add(accountext);
		panel.add(dateLabel);
		panel.add(datetext);
		panel.add(paneltransaction);

		// components of account settings
		paneline.setBounds(0, 60, 300, 5);
		paneline.setBackground(new Color(192, 142, 49));

		panelbuttons.setBounds(0, 15, 200, 600);
		panelbuttons.setBackground(Color.WHITE);

		panellabel.setBounds(0, 15, 300, 50);
		panellabel.setBackground(new Color(0, 41, 98));

		panelinebottom.setBounds(0, 560, 1000, 70);
		panelinebottom.setBackground(new Color(192, 142, 49));

		datelabel.setBounds(800, 555, 376, 44);
		datelabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		datelabel.setForeground(Color.WHITE);

		timelabel.setBounds(800, 573, 377, 44);
		timelabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		timelabel.setForeground(Color.WHITE);

		accountLabel.setBounds(40, 15, 300, 50);
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setFont(new Font("Leelawadee", Font.BOLD, 25));

		idLabel.setBounds(250, 70, 379, 55);
		idLabel.setForeground(Color.black);
		idLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		idtext.setBounds(380, 80, 160, 26);
		idtext.setForeground(new Color(0, 78, 137));
		idtext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		idtext.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		idtext.setEditable(false);

		lastnameLabel.setBounds(250, 110, 379, 55);
		lastnameLabel.setForeground(Color.black);
		lastnameLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		lastnametext.setBounds(380, 120, 160, 26);
		lastnametext.setForeground(Color.black);
		lastnametext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		lastnametext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		lastnametext.setOpaque(false);

		givenameLabel.setBounds(250, 150, 379, 55);
		givenameLabel.setForeground(Color.black);
		givenameLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		givenametext.setBounds(380, 160, 160, 26);
		givenametext.setForeground(Color.black);
		givenametext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		givenametext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		givenametext.setOpaque(false);

		midnameLabel.setBounds(250, 190, 379, 55);
		midnameLabel.setForeground(Color.black);
		midnameLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		midnametext.setBounds(380, 200, 160, 26);
		midnametext.setForeground(Color.black);
		midnametext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		midnametext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		midnametext.setOpaque(false);

		ageLabel.setBounds(250, 270, 379, 55);
		ageLabel.setForeground(Color.black);
		ageLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		agetext.setBounds(380, 280, 160, 26);
		agetext.setForeground(Color.black);
		agetext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		agetext.setBorder(new MatteBorder(0, 0, 1, 0,
				(Color) new Color(0, 0, 0)));
		agetext.setOpaque(false);

		genderLabel.setBounds(250, 230, 379, 55);
		genderLabel.setForeground(Color.black);
		genderLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		gendertext.setBounds(380, 243, 100, 30);
		gendertext.setForeground(Color.black);
		gendertext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 18));
		gendertext.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0,
				0, 0)));
		gendertext.setOpaque(false);
		gendertext.setEditable(false);

		phonenumLabel.setBounds(250, 310, 379, 55);
		phonenumLabel.setForeground(Color.black);
		phonenumLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		phonenumtext.setBounds(380, 320, 160, 26);
		phonenumtext.setForeground(Color.black);
		phonenumtext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		phonenumtext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		phonenumtext.setOpaque(false);

		addressLabel.setBounds(250, 350, 379, 55);
		addressLabel.setForeground(Color.black);
		addressLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		addresstext.setBounds(380, 360, 160, 26);
		addresstext.setForeground(Color.black);
		addresstext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		addresstext.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		addresstext.setOpaque(false);

		accountypeLabel.setBounds(250, 400, 379, 55);
		accountypeLabel.setForeground(Color.black);
		accountypeLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		accountext.setBounds(380, 413, 160, 30);
		accountext.setForeground(Color.black);
		accountext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 18));
		accountext.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0,
				0, 0)));
		accountext.setOpaque(false);
		accountext.setEditable(false);

		balanceLabel.setBounds(640, 265, 379, 55);
		balanceLabel.setForeground(Color.black);
		balanceLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		balanceText.setBounds(679, 300, 193, 30);
		balanceText.setBackground(Color.WHITE);
		balanceText.setForeground(Color.WHITE);
		balanceText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		balanceText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0,
				0, 0)));
		balanceText.setOpaque(false);

		panelboxbalance.setBounds(620, 260, 320, 85);
		panelboxbalance.setBorder(new MatteBorder(5, 5, 5, 5,
				(Color) new Color(144, 202, 249)));
		panelboxbalance.setOpaque(false);

		dateLabel.setBounds(280, 462, 379, 55);
		dateLabel.setForeground(Color.black);
		dateLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));

		datetext.setBounds(350, 500, 193, 30);
		datetext.setBackground(Color.WHITE);
		datetext.setForeground(Color.WHITE);
		datetext.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 18));
		datetext.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0,
				0)));
		datetext.setOpaque(false);
		datetext.setEditable(false);

		paneltransaction.setBounds(250, 460, 310, 85);
		paneltransaction.setBorder(new MatteBorder(5, 5, 5, 5,
				(Color) new Color(144, 202, 249)));
		paneltransaction.setOpaque(false);

		receipt.setBounds(620, 20, 320, 215);
		receipt.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 13));
		receipt.setForeground(new Color(0, 4, 58));
		receipt.setEditable(false);

		amountLabel.setBounds(650, 375, 379, 55);
		amountLabel.setForeground(Color.black);
		amountLabel.setFont(new Font("Sitka Display", Font.PLAIN, 25));

		amountText.setBounds(679, 428, 193, 30);
		amountText.setBackground(Color.WHITE);
		amountText.setFont(new Font("Sylfaen", Font.BOLD | Font.PLAIN, 16));
		amountText.setForeground(Color.black);

		// === dito pagkadeposit mababago yung balance amount and yung date kung
		// kailan siya nakipagtransac ===
		// kasama dito yung receipt
		depositBtn.setBounds(645, 480, 125, 49);
		depositBtn.setFocusable(false);
		depositBtn.setFont(new Font("Leelawadee", Font.BOLD, 14));
		depositBtn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0,
				0, 0)));
		depositBtn.setForeground(Color.WHITE);
		depositBtn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0,
				0, 0)));
		depositBtn.setBackground(new Color(0, 78, 137));
		depositBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		depositBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date = datelabel.getText();
				String amountT = amountText.getText();
				String balanceT = balanceText.getText();
				int amount = Integer.valueOf(amountT);
				int balance = Integer.valueOf(balanceT);

				int deposit = amount + balance;
				String valueD = String.valueOf(deposit);

				balanceText.setText(valueD);
				JOptionPane.showMessageDialog(panel,
						"You've successfully deposited the stated amount.",
						"MESSAGE", JOptionPane.INFORMATION_MESSAGE);
				datetext.setText(date);
				receipt.append("   EZ MONIES ATM MANAGEMENT SYSTEM   \n");
				receipt.append("=========================================================");
				receipt.append("=========================================================");
				receipt.append("\n");
				receipt.append("\nAccount Id:\t\t xxxxxxxx"
						+ "\nDeposit Amount:\t " + amount
						+ "\nAvailable Amount:\t " + balanceText.getText()
						+ "\nAccount Type:\t\t " + accountext.getText()
						+ "\nDate:\t\t" + datelabel.getText() + "\nTime:\t\t"
						+ timelabel.getText());
				receipt.append("\n=================================================\n");
				receipt.append("=========================================================");
				receipt.append("\n====THANK YOU FOR BANKING WITH US!======\n");
				amountText.setText("");
				depositBtn.setEnabled(true);
				printBtn.setEnabled(true);

			}
		});

		// === dito pagkawithdraw mababago yung balance amount and yung date
		// kung kailan siya nakipagtransac ===
		// kasama dito yung receipt
		withdrawBtn.setBounds(785, 480, 125, 49);
		withdrawBtn.setFocusable(false);
		withdrawBtn.setFont(new Font("Leelawadee", Font.BOLD, 14));
		withdrawBtn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0,
				0, 0)));
		withdrawBtn.setForeground(Color.WHITE);
		withdrawBtn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0,
				0, 0)));
		withdrawBtn.setBackground(new Color(0, 78, 137));
		withdrawBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		withdrawBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date = datelabel.getText();
				String amountT = amountText.getText();
				String balanceT = balanceText.getText();
				int amount = Integer.parseInt(amountT);
				int balance = Integer.parseInt(balanceT);

				if (amount >= balance) {

					JOptionPane.showMessageDialog(panel,
							"You can't withdraw the stated amount.", "WARNING",
							JOptionPane.ERROR_MESSAGE);
					amountText.setText("");
				}

				else {

					int withdraw = balance - amount;
					String valueW = String.valueOf(withdraw);
					balanceText.setText(valueW);
					amountText.setText("");
					JOptionPane.showMessageDialog(panel,
							"You've successfully withdrawn the stated amount.",
							"MESSAGE", JOptionPane.INFORMATION_MESSAGE);
					datetext.setText(date);
					receipt.append("   EZ MONIES ATM MANAGEMENT SYSTEM   \n");
					receipt.append("=========================================================");
					receipt.append("=========================================================");
					receipt.append("\n");
					receipt.append("\nAccount Id:\t\t xxxxxxxx"
							+ "\nWithdraw Amount:\t " + amount
							+ "\nAvailable Amount:\t " + balanceText.getText()
							+ "\nAccount Type:\t\t " + accountext.getText()
							+ "\nDate:\t\t" + datelabel.getText()
							+ "\nTime:\t\t" + timelabel.getText());
					receipt.append("\n=================================================\n");
					receipt.append("=========================================================");
					receipt.append("\n====THANK YOU FOR BANKING WITH US!======\n");
					withdrawBtn.setEnabled(true);
					printBtn.setEnabled(true);
				}

			}
		});

		panelamount.setBounds(620, 360, 320, 185);
		panelamount.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(
				144, 202, 249)));
		panelamount.setOpaque(false);

		// === database ng savebutton para masave yung updated data sa jtable
		// and database ===
		saveBtn.setBounds(30, 340, 150, 49);
		saveBtn.setFocusable(false);
		saveBtn.setFont(new Font("Leelawadee", Font.BOLD, 17));
		saveBtn.setBorder(new MatteBorder(0, 0, 0, 0,
				(Color) new Color(0, 0, 0)));
		saveBtn.setBackground(new Color(0, 78, 137));
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = idtext.getText();
				String last = lastnametext.getText();
				String given = givenametext.getText();
				String mid = midnametext.getText();
				String age = agetext.getText();
				String gender = gendertext.getText();
				String num = phonenumtext.getText();
				String add = addresstext.getText();
				String account = accountext.getText();
				String balance = balanceText.getText();
				String date = datetext.getText();

				if (id.trim().equals("") || last.trim().equals("")
						|| given.trim().equals("") || mid.trim().equals("")
						|| age.trim().equals("") || num.trim().equals("")
						|| add.trim().equals("")) {
					JOptionPane
							.showMessageDialog(panel, "Please input fields.");
				} else {

					try {

						conn = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/database", "root",
								"YamYam25");
						stmt = conn.createStatement();
						String query = "UPDATE `accounts` SET `Account Id` =('"
								+ id + "'), `Last Name` = ('" + last + "'), "
								+ "`Given Name` = ('" + given
								+ "'), `Middle Name` = ('" + mid
								+ "'), `Age` = ('" + age + "'), `Gender` = ('"
								+ gender + "'), `Phone Number` = ('" + num
								+ "'), `Address` = ('" + add
								+ "'), `Account Type` = ('" + account
								+ "'), `Balance` = ('" + balance
								+ "'), `Date` = ('" + date
								+ "') WHERE (`Account Id` = '" + id + "');";

						stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(panel,
								"Account updated successfully.");

						dispose();

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

				main.tableinfo.setModel(new DefaultTableModel(
						new Object[][] {}, new String[] { "Account Id",
								"Last Name", "Given Name", "Middle Name",
								"Age", "Gender", "Phone Number", "Address",
								"Account Type", "Balance", "Date" }) {
					Class[] columnTypes = new Class[] { String.class,
							String.class, String.class, String.class,
							String.class, String.class, String.class,
							String.class, String.class, String.class,
							String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { true, true,
							true, true, true, true, true, true, true, true,
							true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				main.scrollPane.setViewportView(main.tableinfo);

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
							DefaultTableModel model = (DefaultTableModel) main.tableinfo
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

		// para maprint yung receipt
		printBtn.setBounds(30, 410, 150, 49);
		printBtn.setFocusable(false);
		printBtn.setFont(new Font("Leelawadee", Font.BOLD, 17));
		printBtn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0,
				0)));
		printBtn.setBackground(new Color(0, 78, 137));
		printBtn.setForeground(Color.WHITE);
		printBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		printBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					receipt.print();
				} catch (PrinterException e) {
					System.err.format("No Printer Found", e.getMessage());
				}
			}
		});

		cancelBtn.setBounds(30, 480, 150, 49);
		cancelBtn.setFocusable(false);
		cancelBtn.setFont(new Font("Leelawadee", Font.BOLD, 17));
		cancelBtn.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0,
				0)));
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setBackground(new Color(0, 78, 137));
		cancelBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cancel = JOptionPane.showConfirmDialog(panel,
						"Are you sure to cancel?", "Exiting the system",
						JOptionPane.YES_NO_OPTION);
				if (cancel == JOptionPane.YES_OPTION) {
					dispose();

				} else if (cancel == JOptionPane.NO_OPTION) {

					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}
}
