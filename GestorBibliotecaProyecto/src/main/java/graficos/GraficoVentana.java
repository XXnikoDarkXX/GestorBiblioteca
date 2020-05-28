package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetosVivos.Gestor;

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

	private JPanel contentPane;//Contenedor Jpanel
	private GraficoAdministrador admin;//Panel para poder logearse
	private GraficoGestionAdmin gestionAdmin; //Panel para gestionar a los gestores
	private GraficoGestor gestor;//Panel para gestor
	private InsertarGestor inserGestor;//Panel para insertar un gestor
	private GraficoInsertarLectura insertLectura;//Panel para insertar Lectura
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GraficoVentana() {
		
		

		
		
		
		setTitle("Gestor de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 70, 800, 400);

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
		/**
		 * Desde el boton btnAdministrador hacemos la funcion de cargarPantalla1
		 */
		btnAdministrador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargaPantalla1();
				
			}
		});
		/**
		 * Desde el menu dandole al inicio cargaremos la funcion CargarInicio 
		 */
		mntmIrInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cargarInicio();
			}
		});
		
		
		contentPane.add(btnAdministrador);

		JButton btnGestor = new JButton("Gestor");
		
		
		contentPane.add(btnGestor);
		/**
		 * Desde el boton btnGestor llamamos a la funcion cargarGraficoGestor
		 */
		btnGestor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarGraficoGestor();
			}
		});
		JButton btnUsuario = new JButton("Usuario");
		contentPane.add(btnUsuario);
		
		
		
		
	}
	
	
	
	/**
	 * Con este método podemos cargar y cambiar a la ventana del administrador
	 */
	
	public void cargaPantalla1() {
		if (this.admin==null) {
			this.admin=new GraficoAdministrador(this);
		}
		this.admin.setVisible(false);
		
		this.setContentPane(this.admin);
		this.admin.setVisible(true);
	}
	
	
	/**
	 * Metodo para cargar la ventana de inicio desde el menu
	 */
	 public void cargarInicio() {
			
			this.setContentPane(this.contentPane);
			this.contentPane.setVisible(true);
		}
	 
	 /**
	  * Metodo para cargar el jpanel de gestionAdministrador
	  */
	 public void cargarGestionAdmin() {
		if (this.gestionAdmin==null) {
			this.gestionAdmin=new GraficoGestionAdmin(this);
		}
		
		this.admin.setVisible(false);
		this.setContentPane(this.gestionAdmin);
		this.gestionAdmin.setVisible(true);
	}
	 
	 /**
	  * Metodo para cargar el jpnale del GraficoGestor
	  */
	 public void cargarGraficoGestor() {
			if (this.gestor==null) {
				this.gestor=new GraficoGestor(this);
			}
			
			this.gestor.setVisible(false);
			this.setContentPane(this.gestor);
			this.gestor.setVisible(true);
		}
	 
	 public void cargarInsertarGestor() {
			if (this.inserGestor==null) {
				this.inserGestor=new InsertarGestor(this);
			}
			
			this.inserGestor.setVisible(false);
			this.setContentPane(this.inserGestor);
			this.inserGestor.setVisible(true);
		}
	 public void cargarGraficoInsertarLectura() {
			if (this.insertLectura==null) {
				this.insertLectura=new GraficoInsertarLectura(this);
			}
			
			this.insertLectura.setVisible(false);
			this.setContentPane(this.insertLectura);
			this.insertLectura.setVisible(true);
		}
	 
	 
}


