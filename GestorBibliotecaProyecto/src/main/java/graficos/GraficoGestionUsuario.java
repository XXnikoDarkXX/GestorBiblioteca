package graficos;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import objetosLectura.LecturaExcepcion;
import objetosVivos.Usuario;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GraficoGestionUsuario extends JPanel {
	private JButton btnConsultar;
	private JTextField txtCodigo;
	private GraficoVentana v;//Grafico de la ventana principal
	private Usuario user=new Usuario();//Usuario
	private MisJOptionPane op;//Dialogos de texto
	 /**
	 * Create the panel.
	 */
	public GraficoGestionUsuario(GraficoVentana ventana) {
		this.v=ventana;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elige la opcion para Consultar");
		lblNewLabel.setBounds(23, 22, 141, 24);
		add(lblNewLabel);
		
		JRadioButton rbLibros = new JRadioButton("Libros");
		rbLibros.setSelected(true);
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
		
		JTextPane txtConsulta = new JTextPane();
		scrollPane.setViewportView(txtConsulta);


		ButtonGroup bg=new ButtonGroup();
		bg. add(rbPeriodicos);;
		bg.add(rbRevistas);;
		bg.add(rbLibros);
		
		btnConsultar = new JButton("Consultar");
	
		btnConsultar.setBounds(165, 183, 211, 32);
		add(btnConsultar);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("Codigo");
		txtCodigo.setBounds(33, 244, 131, 24);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnElegir = new JButton("Elegir");
		
		btnElegir.setBounds(165, 281, 89, 23);
		add(btnElegir);
		
		
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbLibros.isSelected()) {
					try {
						String libros=user.consultarLibros();
						txtConsulta.setText(libros);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(rbRevistas.isSelected()) {
					try {
						String revistas=user.consultarRevistas();
						txtConsulta.setText(revistas);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(rbPeriodicos.isSelected()) {
					try {
						String periodicos=user.consultarPeriodicos();	
						txtConsulta.setText(periodicos);
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		/**
		 * Metodo para elegir una lectura para los usuarios
		 */
		btnElegir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbLibros.isSelected()) {
				byte codigo=Byte.valueOf(txtCodigo.getText());
				try {
					user.elegirLibro(codigo);
					op=new MisJOptionPane ();//Creamos el jOptionPane
					 
		            JOptionPane.showMessageDialog(op, "Elegido libro con el codigo"+codigo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LecturaExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					  op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Error Te has equivocado de Codigo","Error", JOptionPane.WARNING_MESSAGE);  

					   op.setVisible(true);
					ventana.setVisible(false);
					op.setVisible(false);
				}
			}else if(rbRevistas.isSelected()) {
				try {
					byte codigo=Byte.valueOf(txtCodigo.getText());
					user.elegirRevista(codigo);
					op=new MisJOptionPane ();//Creamos el jOptionPane
					 
		            JOptionPane.showMessageDialog(op, "Elegido revista con el codigo"+codigo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LecturaExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					  op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Error Te has equivocado de Codigo","Error", JOptionPane.WARNING_MESSAGE);  

					   op.setVisible(true);
					ventana.setVisible(false);
					op.setVisible(false);
				}
			}else if(rbPeriodicos.isSelected()) {
				try {
					byte codigo=Byte.valueOf(txtCodigo.getText());
					user.elegirPeriodico(codigo);
					op=new MisJOptionPane ();//Creamos el jOptionPane
					 
		            JOptionPane.showMessageDialog(op, "Elegido Periodico con el codigo"+codigo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LecturaExcepcion e1) {
					// TODO Auto-generated catch block
				
					  op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Error te has equivocadod e codigo","Error", JOptionPane.WARNING_MESSAGE);  

					   op.setVisible(true);
					ventana.setVisible(false);
					op.setVisible(false);
					e1.printStackTrace();
				}
			}
			}
		});
		
	}
}
