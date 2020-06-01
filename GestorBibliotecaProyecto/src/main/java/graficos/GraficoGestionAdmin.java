package graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import objetosVivos.Administrador;
import objetosVivos.GestorExcepcion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GraficoGestionAdmin extends JPanel {
	private GraficoVentana v;
	private Administrador nicolas;
	private MisJOptionPane op;
	
	/**
	 * Create the panel.
	 */
	
	public GraficoGestionAdmin(GraficoVentana ventana) {
		Administrador nicolas=new Administrador("nicolas","fernandez",(byte)18,"54373141");
				
		this.v=ventana;
		setLayout(new GridLayout(3, 0, 0, 0));
		
		JLabel lblGestores = new JLabel("Mostrar Gestores");
		lblGestores.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGestores);
		
		JLabel lblBorrarGestores = new JLabel("Escribe el Nif para borrar el gestor");
		lblBorrarGestores.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblBorrarGestores);
		
		JTextPane txtMostrarGestores = new JTextPane();
		txtMostrarGestores.setText("Se muestra los gestores");
		add(txtMostrarGestores);
		
		JTextPane txtborrarGestores = new JTextPane();
		txtborrarGestores.setText("Escribe el nif");
		add(txtborrarGestores);
		
		JButton btnMostrarGestores = new JButton("Mostrar");
		btnMostrarGestores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String muestraGestores=nicolas.mostrarGestores();
					txtMostrarGestores.setText(muestraGestores);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add(btnMostrarGestores);
		
		JButton btnBorrarGestores = new JButton("Borrar");
		
		add(btnBorrarGestores);
		/**
		 * Evento o metodo que al darle al  boton de borrar gestor si hemos escrito bien el nif nos alertara de que el nif escrito
		 * es correcto en caso contrario nos mostrara una alerta de error y el programa se cerrará
		 */
		btnBorrarGestores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nif=txtborrarGestores.getText();
			
				try {
					nicolas.borrarGestor(nif);
					//lblBorrarGestores.setText("Has borrado el gestor con nif"+nif);
					 op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Has borrado el gestor con Nif"+nif);  

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (GestorExcepcion e1) {
					// TODO Auto-generated catch block
					txtborrarGestores.setText("Error Te has equivocado de nif y la ventana se cerrara");
					  op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Error Te has equivocado de nif y la ventana se cerrara","Error", JOptionPane.WARNING_MESSAGE);  

					   op.setVisible(true);
					ventana.setVisible(false);
					op.setVisible(false);
					e1.printStackTrace();
					
					
				}
			}
		});
		
	}

}
