package graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class GraficoInsertarLectura extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JSeparator separator;

	/**
	 * Create the panel.
	 */
	public GraficoInsertarLectura() {
		setLayout(new GridLayout(4, 6, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Inserta Libro");
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		add(btnNewButton);
		
		separator = new JSeparator();
		add(separator);
		
		textField_3 = new JTextField();
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_9 = new JTextField();
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_8 = new JTextField();
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_12 = new JTextField();
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_11 = new JTextField();
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_14 = new JTextField();
		add(textField_14);
		textField_14.setColumns(10);
		
		textField_10 = new JTextField();
		add(textField_10);
		textField_10.setColumns(10);
		
		textField_6 = new JTextField();
		add(textField_6);
		textField_6.setColumns(10);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_13 = new JTextField();
		add(textField_13);
		textField_13.setColumns(10);

	}

}
