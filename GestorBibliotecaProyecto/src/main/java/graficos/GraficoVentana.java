package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraficoVentana extends JFrame {

	private JPanel contentPane;
	private GraficoAdministrador admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoVentana frame = new GraficoVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraficoVentana() {
		
		
	
		
		setTitle("Gestor de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 70, 600, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);

		JMenuItem mntmIrInicio = new JMenuItem("Ir a Inicio");
		mnInicio.add(mntmIrInicio);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblOpcion = new JLabel("Elige Una Opcion");
		lblOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblOpcion);

		JButton btnAdministrador = new JButton("Admistrador");
		
		
		
		
		contentPane.add(btnAdministrador);

		JButton btnGestor = new JButton("Gestor");
		contentPane.add(btnGestor);

		JButton btnUsuario = new JButton("Usuario");
		contentPane.add(btnUsuario);
		
		
		
		
		
	}
	
	
	
	/**
	 * Con este método podemos cargar y cambiar a la ventana del administrador
	 */
	
	public void cargarGraficoAdministrador() {
	

		
	}
	
	
	
	

}


