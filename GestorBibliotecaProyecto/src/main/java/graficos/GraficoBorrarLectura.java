package graficos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextPane;

import objetosVivos.Gestor;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GraficoBorrarLectura extends JPanel {
	private JTextField txtCodigo;
	private Gestor gestor=new Gestor();//Usamos un gestor vacio para hacer las consultas
	private GraficoVentana v;//Grafico de la Ventana principal
	private MisJOptionPane op;//Dialogos de texto
	/**
	 * Create the panel.
	 */
	public GraficoBorrarLectura(GraficoVentana ventana) {
		this.v=ventana;
		setLayout(null);
		
		JLabel lblOpcion = new JLabel("Elije la opcion para consultar ");
		lblOpcion.setBounds(0, 0, 450, 33);
		add(lblOpcion);
		
		JRadioButton rbConsultarLibros = new JRadioButton("ConsultarLibros");
		rbConsultarLibros.setBounds(10, 40, 147, 23);
		rbConsultarLibros.setSelected(true);
		add(rbConsultarLibros);
		
		JRadioButton rbConsultarRevistas = new JRadioButton("ConsultarRevistas");
		rbConsultarRevistas.setBounds(218, 40, 153, 23);
		add(rbConsultarRevistas);
		
		JRadioButton rbConsultarPeriodico = new JRadioButton("ConsultarPeriodico");
		rbConsultarPeriodico.setBounds(6, 76, 151, 23);
		add(rbConsultarPeriodico);
		
		JButton btnOpcion = new JButton("AplicarOpcion");
		btnOpcion.setBounds(181, 71, 243, 33);
		
		add(btnOpcion);
		
		JTextPane txtConsulta = new JTextPane();
		txtConsulta.setBounds(0, 115, 570, 84);
		add(txtConsulta);
		
		JLabel lblCodigo = new JLabel("Escribe el codigo Del libro que desea Borrar");
		lblCodigo.setBounds(0, 199, 450, 33);
		add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(0, 232, 450, 33);
		txtCodigo.setText("Codigo");
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(0, 265, 450, 33);
		
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbConsultarPeriodico);;
		bg.add(rbConsultarRevistas);
		bg.add(rbConsultarLibros);
		
		btnOpcion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbConsultarLibros.isSelected()) {
					try {
						String libros=gestor.consultarLibros();
						txtConsulta.setText(libros);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(rbConsultarRevistas.isSelected()) {
					try {
						String revistas=gestor.consultarRevistas();
						txtConsulta.setText(revistas);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(rbConsultarPeriodico.isSelected()) {
					try {
						String periodico=gestor.consultarPeriodicos();
						txtConsulta.setText(periodico);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		
		add(btnBorrar);
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbConsultarLibros.isSelected()) {
					byte codigo=Byte.parseByte(txtCodigo.getText());
					try {
						gestor.borrarLibro(codigo);
						
						op=new MisJOptionPane ();//Creamos el jOptionPane
						 
			            JOptionPane.showMessageDialog(op, "HasBorrado el libro con el codigo"+codigo);
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rbConsultarRevistas.isSelected()) {
					byte codigo=Byte.parseByte(txtCodigo.getText());
					try {
						gestor.borrarRevista(codigo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(rbConsultarPeriodico.isSelected()) {
					byte codigo=Byte.parseByte(txtCodigo.getText());
					try {
						gestor.borrarPeriodico(codigo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
