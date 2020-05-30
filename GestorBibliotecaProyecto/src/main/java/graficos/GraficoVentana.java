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

	private JPanel contentPane;
	private GraficoAdministrador admin;//Grafico para logarse como administrador
	private GraficoGestionAdmin gestionAdmin;//Grafico con las funciones del administrador
	private GraficoGestor gestor;//Grafico del gestor principal
	private InsertarGestor inserGestor;//Grafico para insertar Gestor
	private GraficoInsertarLectura inserLectura;//Grafico para insertar lectura desde GESTOR
	private GraficoBorrarLectura borrarLectura;//Grafico para mostrar y borrar lectura desde GESTOR
	private GraficoEstadoUsuario estadoUsuario;//Grafico para consultar y dar de alta/baja a los usuarios
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GraficoVentana() {
		
		

		
		
		
		setTitle("Gestor de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 70, 900, 500);

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
		btnAdministrador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargaPantalla1();
				
			}
		});
		
		mntmIrInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cargarInicio();
			}
		});
		
		
		contentPane.add(btnAdministrador);

		JButton btnGestor = new JButton("Gestor");
		
		contentPane.add(btnGestor);

		JButton btnUsuario = new JButton("Usuario");
		contentPane.add(btnUsuario);
		/**
		 * Mediante el boton de gestor cargamos el menu de los gestores
		 */
		btnGestor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarGraficoGestor();
			}
		});
		
		
		
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
	
	 public void cargarInicio() {
			
			this.setContentPane(this.contentPane);
			this.contentPane.setVisible(true);
		}
	 
	 /**
	  * Metodo para cargar las funciones del Administrador para borrar y mostrar gestores
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
	  * Metodo para cargar el menu del Gestor
	  */
	 public void cargarGraficoGestor() {
		if (this.gestor==null) {
			this.gestor=new GraficoGestor(this);
		}
		
		this.gestor.setVisible(false);
		this.setContentPane(this.gestor);
		this.gestor.setVisible(true);
	}
	 
	 /**
	  * Metodo para cargar la funcion de insertar Gestor
	  */
	 public void cargarGraficoInsertarGestor() {
		if (this.inserGestor==null) {
			this.inserGestor=new InsertarGestor(this);
		}
		
		this.inserGestor.setVisible(false);
		this.setContentPane(this.inserGestor);
		this.inserGestor.setVisible(true);
	}
	 
	 
	 /**
	  * Metodo para cargar la grafica de insertarLectura
	  */
	 public void cargarGraficoInsertarLectura() {
		if (this.inserLectura==null) {
			this.inserLectura=new GraficoInsertarLectura(this);
		}
		
		this.inserLectura.setVisible(false);
		this.setContentPane(this.inserLectura);
		this.inserLectura.setVisible(true);
	}
	 
	 /**
	  * Metodo para cargar la grafica de borrarLectura
	  */
	 public void cargarGraficoBorrarLectura() {
		if (this.borrarLectura==null) {
			this.borrarLectura=new GraficoBorrarLectura(this);
		}
		
		this.borrarLectura.setVisible(false);
		
		this.setContentPane(this.borrarLectura);
		this.borrarLectura.setVisible(true);
	}
	 
	 
	 /**
	  * Metodo para cargar la grafica de borrarLectura
	  */
	 public void cargarGraficoEstadoUsuario() {
		if (this.estadoUsuario==null) {
			this.estadoUsuario=new GraficoEstadoUsuario(this);
		}
		
		this.estadoUsuario.setVisible(false);
		
		this.setContentPane(this.estadoUsuario);
		this.estadoUsuario.setVisible(true);
	}

}


