import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import java.awt.Scrollbar;
import javax.swing.table.DefaultTableModel;

public class App {

	private JFrame frame;
	private JTextField txtrtkek;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private JPanel linearequation;
	private JPanel hatizsak;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JScrollPane scrollPane2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JPanel[] panels = new JPanel[2];
	
	private JButton btnLinerisEgyenletrendszer;
	private JButton btnNewButton_2;
	private JTable table;
	private JButton btnNewButton_3;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1481, 699);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		linearequation = new JPanel();
		linearequation.setBounds(350, 11, 1067, 638);
		frame.getContentPane().add(linearequation);
		
		JButton btnNewButton = new JButton("H\u00E1tizs\u00E1k feladat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hidePanels();
				
				hatizsak.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 42, 256, 46);
		frame.getContentPane().add(btnNewButton);
		
		hatizsak = new JPanel();
		hatizsak.setBounds(350, 11, 1067, 638);
		frame.getContentPane().add(hatizsak);
		hatizsak.setLayout(null);
		
		txtrtkek = new JTextField();
		txtrtkek.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtrtkek.setText("41, 29, 10, 20, 5, 11");
		txtrtkek.setToolTipText("\u00C9rt\u00E9kek");
		txtrtkek.setBounds(152, 11, 402, 36);
		hatizsak.add(txtrtkek);
		txtrtkek.setColumns(10);
		
		JLabel ertekek = new JLabel("\u00C9rt\u00E9kek");
		ertekek.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ertekek.setBounds(10, 22, 71, 14);
		hatizsak.add(ertekek);
		
		JLabel lblSlyok = new JLabel("S\u00FAlyok");
		lblSlyok.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSlyok.setBounds(10, 69, 71, 14);
		hatizsak.add(lblSlyok);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setText("31, 36, 32, 13, 2, 10");
		textField.setToolTipText("\u00C9rt\u00E9kek");
		textField.setColumns(10);
		textField.setBounds(152, 58, 402, 36);
		hatizsak.add(textField);
		
		JButton btnNewButton_1 = new JButton("GO");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				final double[] ertekek = separateBy(txtrtkek.getText(), ",");
				final double[] sulyok = separateBy(textField.getText(), ",");
				final double meret = Double.parseDouble(textField_1.getText());
				
				final double[][] output = Hatizsak2.go(ertekek, sulyok, meret);
				StringBuilder sb = new StringBuilder();
				
				for (int i = 0; i < output.length; i++) {
					for (int j = 0; j < output[i].length; j++) {
						sb.append(output[i][j] + "\t");
					}
					sb.append("\n");
				}
				
				sb.append("Optimum: " + Hatizsak2.searchmax(output));
				
				textPane.setText(sb.toString());
			}
		});
		btnNewButton_1.setBounds(10, 155, 544, 36);
		hatizsak.add(btnNewButton_1);
		
		JLabel lblHtizskMrete = new JLabel("H\u00E1tizs\u00E1k m\u00E9rete");
		lblHtizskMrete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHtizskMrete.setBounds(10, 116, 132, 14);
		hatizsak.add(lblHtizskMrete);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setText("50");
		textField_1.setToolTipText("\u00C9rt\u00E9kek");
		textField_1.setColumns(10);
		textField_1.setBounds(152, 105, 402, 36);
		hatizsak.add(textField_1);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane.setBounds(10, 202, 1047, 425);
		//hatizsak.add(textPane);
		
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(10, 202, 1047, 425);

		hatizsak.add(scrollPane);
		
		btnLinerisEgyenletrendszer = new JButton("Line\u00E1ris egyenletrendszer");
		btnLinerisEgyenletrendszer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hidePanels();
				linearequation.setVisible(true);
			}
		});
		btnLinerisEgyenletrendszer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLinerisEgyenletrendszer.setBounds(10, 99, 256, 46);
		frame.getContentPane().add(btnLinerisEgyenletrendszer);
		
		linearequation.setVisible(false);
		
		panels[0] = hatizsak;
		panels[1] = linearequation;
		linearequation.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ismeretlenek sz\u00E1ma");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 155, 14);
		linearequation.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Egyenletek sz\u00E1ma");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 36, 137, 14);
		linearequation.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("Gener\u00E1l\u00E1s");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final int ismeretlenek = (int) spinner.getValue();
				final int egyenletek = (int) spinner_1.getValue();
				String[] header = new String[ismeretlenek + 1];
				Object[][] data = new Object[egyenletek][ismeretlenek + 1];
				
				for (int i = 0; i < ismeretlenek; i++) {
					header[i] = "X" + (i + 1);
				}
				
				header[header.length-1] = "b";
				
				for(int i = 0; i < egyenletek; i++) {
					for(int j = 0; j < ismeretlenek + 1; j++) {
						data[i][j] = null;
					}
				}
				
				table.setModel(new DefaultTableModel(
						data,
						header
					));
			}
		});
		btnNewButton_2.setBounds(287, 10, 120, 40);
		linearequation.add(btnNewButton_2);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(177, 10, 86, 20);
		linearequation.add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_1.setBounds(177, 35, 86, 20);
		linearequation.add(spinner_1);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBounds(10, 95, 603, 100);
		scrollPane2 = new JScrollPane(table);
		scrollPane2.setBounds(10, 95, 1047, 167);
		linearequation.add(scrollPane2);
		
		btnNewButton_3 = new JButton("GO");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBounds(10, 278, 89, 23);
		linearequation.add(btnNewButton_3);
		
		
	}
	
	public double[] separateBy(String data, String separator) {
		final String ertekek = data.replaceAll("\\s", "");
		final String[] ertekekTomb = ertekek.split(",");
		double[] szamErtekek = new double[ertekekTomb.length];
		int count = 0;
		
		for(String ert : ertekekTomb) {
			szamErtekek[count++] = Double.parseDouble(ert);
		}
		
		return szamErtekek;
	}
	
	public void hidePanels() {
		for (int i = 0; i < panels.length; i++) {
			panels[i].setVisible(false);
		}
	}
}
