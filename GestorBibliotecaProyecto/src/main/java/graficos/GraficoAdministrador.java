package graficos;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;



public class GraficoAdministrador extends JPanel {
	private GraficoVentana ventana;
	private JTextField txtContrasena;
	private GraficoGestionAdmin admin;
	/**
	 * Create the panel.
	 */
	public GraficoAdministrador(GraficoVentana v) {
		setLayout(new GridLayout(4, 0, 0, 0));
		this.ventana=v;
		JLabel lblNewLabel = new JLabel("Escribe la Contraseña");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		txtContrasena = new JTextField();
		add(txtContrasena);
		txtContrasena.setColumns(10);
		
		JButton btnContraseña = new JButton("Aplicar");
		
		add(btnContraseña);
		
		
		
		JButton btnGestiAdmin = new JButton("Pasar a la gestion de Administrador");
		btnGestiAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtContrasena.setText("");
				btnGestiAdmin.setVisible(false);
				lblNewLabel.setText("Escribe la contraseña");
				
				ventana.cargarGestionAdmin();
				
			}
		});
		add(btnGestiAdmin);
		
		btnGestiAdmin.setVisible(false);
		/**
		 * Con este metodo al poner la contraseña correcta el boton de pasar a la gestion de administrador se pone visible
		 */
		btnContraseña.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtContrasena.getText().equalsIgnoreCase("admin")) {
					btnGestiAdmin.setVisible(true);
					lblNewLabel.setText("Ya puedes pasar a la ventana de gestion");
				}else {
					lblNewLabel.setText("Te has equivocado de contraseña");
				
					
				}
				
			}
		});

	}
	
	
	
	

}
