package graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;

public class GraficoGestor extends JPanel {

	/**
	 * Create the panel.
	 */
	public GraficoGestor() {
		setLayout(new MigLayout("", "[123px][123px][123px][123px]", "[100px][100px][100px]"));
		
		JLabel lblNewLabel_1 = new JLabel("Insertar Gestor");
		add(lblNewLabel_1, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("Borrar Lectura");
		add(lblNewLabel, "cell 1 0,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Insertar Lectura");
		add(lblNewLabel_3, "cell 2 0,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Altas/Bajas-Usuarios");
		add(lblNewLabel_2, "cell 3 0,grow");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Opcion 1");
		rdbtnNewRadioButton_1.setSelected(true);
		add(rdbtnNewRadioButton_1, "cell 0 1,grow");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Opcion 2");
		add(rdbtnNewRadioButton_2, "cell 1 1,grow");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Opcion 3");
		add(rdbtnNewRadioButton, "cell 2 1,grow");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Opcion 4");
		add(rdbtnNewRadioButton_3, "cell 3 1,grow");
		
		JButton btnNewButton_1 = new JButton("Aplicar");
		add(btnNewButton_1, "cell 0 2 4 1,grow");

	}

}
