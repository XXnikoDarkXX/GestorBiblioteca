package graficos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import objetosVivos.Gestor;

import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GraficoEstadoUsuario extends JPanel {
	private JTextField txtNif;
	private GraficoVentana v;//Grafico del la ventana principal
	private Gestor gestor=new Gestor();//Gestor vacio
	private JTextField txtConsultaUsuario;
	private MisJOptionPane op;//Dialogos de texto

	/**
	 * Create the panel.
	 */
	public GraficoEstadoUsuario(GraficoVentana ventana) {
		this.v=ventana;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar Usuarios");
		lblNewLabel.setBounds(10, 11, 134, 31);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 500, 120);
		add(scrollPane);
		
		
		JTextPane txtConsultaUsuario = new JTextPane();
		scrollPane.setViewportView(txtConsultaUsuario);
		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setBounds(259, 15, 89, 23);
		add(btnConsultar);
		
		JLabel lblEstado = new JLabel("Dar Alta/Baja");
		lblEstado.setBounds(10, 189, 96, 14);
		add(lblEstado);
		
		JRadioButton rbAlta = new JRadioButton("Alta");
		rbAlta.setSelected(true);
		rbAlta.setBounds(133, 185, 109, 23);
		add(rbAlta);
		
		JRadioButton rbBaja = new JRadioButton("Baja");
		rbBaja.setBounds(281, 185, 109, 23);
		add(rbBaja);
		
		txtNif = new JTextField();
		txtNif.setText("NIF");
		txtNif.setBounds(143, 225, 201, 20);
		add(txtNif);
		txtNif.setColumns(10);
		
		JLabel lblNif = new JLabel("Introduzca un Nif");
		lblNif.setBounds(10, 228, 123, 14);
		add(lblNif);
		
		JButton btnAplicar = new JButton("Borrar");
		
		btnAplicar.setBounds(181, 268, 89, 23);
		add(btnAplicar);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbAlta);;
		bg.add(rbBaja);
		
		/**
		 * Evento que al clickar en el boton de consultar agregamos al campo los usuarios que hay en la bbdd
		 */
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
					txtConsultaUsuario.setText(gestor.consultarUsuarios());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		/**
		 * Evento que al clikear el boton y segun hayamos elegido los radio button damos de alta o baja al usuario
		 */
		btnAplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbAlta.isSelected()) {
					String nif=txtNif.getText();
					try {
						gestor.darAltaUsuario(nif);
						op=new MisJOptionPane ();//Creamos el jOptionPane
						 
			            JOptionPane.showMessageDialog(op, "Alta al usuario con Nif"+nif);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rbBaja.isSelected()) {
					String nif=txtNif.getText();
					try {
						gestor.darBajaUsuario(nif);
						op=new MisJOptionPane ();//Creamos el jOptionPane
						 
			            JOptionPane.showMessageDialog(op, "Baja al usuario con Nif"+nif);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		

	}
}
