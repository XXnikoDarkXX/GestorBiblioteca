package graficos;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;



public class GraficoAdministrador extends JPanel {
	private JPasswordField passwordField;
	private GraficoVentana ventana;
	/**
	 * Create the panel.
	 */
	public GraficoAdministrador(GraficoVentana v) {
		setLayout(new GridLayout(3, 0, 0, 0));
		
		JTextPane txtContraseña = new JTextPane();
		txtContraseña.setText("Escribe la contraseña");
		add(txtContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordField.setToolTipText("");
		add(passwordField);
		
		JButton btnContraseña = new JButton("Aplicar");
		add(btnContraseña);
		
		this.ventana=v;

	}
	
	

}
