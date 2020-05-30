package graficos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class GraficoGestionUsuario extends JPanel {

	/**
	 * Create the panel.
	 */
	public GraficoGestionUsuario() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elige la opcion para Consultar");
		lblNewLabel.setBounds(23, 22, 141, 24);
		add(lblNewLabel);
		
		JRadioButton rbLibros = new JRadioButton("Libros");
		rbLibros.setBounds(188, 23, 91, 23);
		add(rbLibros);
		
		JRadioButton rbRevistas = new JRadioButton("Revistas");
		rbRevistas.setBounds(281, 23, 109, 23);
		add(rbRevistas);
		
		JRadioButton rbPeriodicos = new JRadioButton("Periodicos");
		rbPeriodicos.setBounds(396, 23, 81, 23);
		add(rbPeriodicos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 650, 80);
		add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

	}

}
