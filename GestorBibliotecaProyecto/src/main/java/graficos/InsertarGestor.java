package graficos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InsertarGestor extends JPanel {
	private JTextField txtNif;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtApellido;

	/**
	 * Create the panel.
	 */
	public InsertarGestor() {
		setLayout(new GridLayout(2, 6, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Rellene los textos");
		add(lblNewLabel);
		
		txtNif = new JTextField();
		txtNif.setText("Nif");
		add(txtNif);
		txtNif.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setText("Edad");
		add(txtEdad);
		txtEdad.setColumns(10);
		
		JButton btnNewButton = new JButton("Aplicar");
		add(btnNewButton);

	}

}
