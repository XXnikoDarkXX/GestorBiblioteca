package graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import objetosLectura.Lectura;
import objetosLectura.Libro;
import objetosLectura.Periodico;
import objetosLectura.Revista;
import objetosVivos.Gestor;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class GraficoInsertarLectura extends JPanel {
	private JLabel lblNewLabel_1;
	private JButton btnOpcion;
	private JTextField txtEditorial;
	private JTextField txtNombre;
	private JTextField txtCategoria;
	private JTextField txtCodigo;
	private JLabel label;
	private JRadioButton rbPeriodico;
	private JRadioButton rbRevista;
	private JRadioButton rbLibro;
	private JLabel lblLectura;
	private JButton btnLectura;
	
	private Gestor creadorLectura =new Gestor();//Tenemos un Gestor vacio para ir insertando la Lectura
	private GraficoVentana v;//Jframe de la ventana principal
	private MisJOptionPane op;//Dialogos de texto

	/**
	 * Create the panel.
	 */
	public GraficoInsertarLectura(GraficoVentana ventana) {
		this.v=ventana;
		lblNewLabel_1 = new JLabel("Elige la opcion Que vas a usar:");
		
		txtCodigo = new JTextField();
		txtCodigo.setText("Codigo");
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("nombre");
		txtNombre.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setText("categoria");
		txtCategoria.setColumns(10);
		setLayout(new GridLayout(0, 2, 0, 0));
		add(lblNewLabel_1);
		
		rbLibro = new JRadioButton("Libro");
		rbLibro.setSelected(true);
		add(rbLibro);
		
		rbRevista = new JRadioButton("Revista");
		add(rbRevista);
		
		rbPeriodico = new JRadioButton("Periodico");
		add(rbPeriodico);
		
		lblLectura = new JLabel("Rellene los siguientes campos");
		add(lblLectura);
		
		btnOpcion = new JButton("Aplicar Opcion");
		
		add(btnOpcion);
		add(txtCodigo);
		add(txtNombre);
		add(txtCategoria);
		
		
		txtEditorial = new JTextField();
		txtEditorial.setText("Editorial");
		txtEditorial.setColumns(10);
		add(txtEditorial);
		
		btnLectura = new JButton("Insertar");
		
		add(btnLectura);
		
		
		
		
		label = new JLabel("");
		add(label);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbLibro);
		bg.add(rbPeriodico);
		bg.add(rbRevista);;
		
		/**
		 * Mediante este boton aplicacamos los radiobutoon y en los textos ponemos una guia de que debe incluirse
		 */
		btnOpcion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbLibro.isSelected()) {
				txtNombre.setText("Nombre");
				txtCodigo.setText("Codigo numerico");
				txtCategoria.setText("Categoria");
		
				txtEditorial.setText("Editorial");
					
				}else if(rbPeriodico.isSelected()) {
					txtNombre.setText("Nombre");
					txtCodigo.setText("Codigo numerico");
					txtEditorial.setText("Editorial");
					
					txtCategoria.setText("Tipo De Noticias");
				}else if(rbRevista.isSelected()) {
					txtNombre.setText("Nombre");
					txtCodigo.setText("Codigo numerico");
					txtEditorial.setText("Autor");
					txtCategoria.setText("Tipo De Revista");
				}
			}
		});
		
		
		/**
		 * Mediante esta funcion revisamos 
		 */
		btnLectura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				if(rbLibro.isSelected()) {
					//Creamos el objeto Lectura
					
					byte codigo=Byte.valueOf(txtCodigo.getText());//Mediante este metodo pasamos un String que tenga numeros a un byte
					Lectura libro=new Libro(txtNombre.getText(),codigo,txtCategoria.getText(),txtEditorial.getText());
				
					creadorLectura.agregarLectura(libro);
					 op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Has creado el libro "+libro.getCodigo());  
				
				}else if(rbPeriodico.isSelected()) {
					byte codigo=Byte.valueOf(txtCodigo.getText());//Mediante este metodo pasamos un String que tenga numeros a un byte
				
					Lectura periodico=new Periodico(codigo,txtNombre.getText(),txtEditorial.getText(),txtCategoria.getText());
				
				creadorLectura.agregarLectura(periodico);
				 op=new MisJOptionPane ();//Creamos el jOptionPane
				 
		            JOptionPane.showMessageDialog(op, "Has creado el periodico "+periodico.getCodigo());
		            
				}else if(rbRevista.isSelected()) {
					
			byte codigo=Byte.valueOf(txtCodigo.getText());//Mediante este metodo pasamos un String que tenga numeros a un byte
			
			Lectura revista=new Revista(codigo,txtNombre.getText(),txtCategoria.getText(),txtEditorial.getText());
			
			creadorLectura.agregarLectura(revista);
			 op=new MisJOptionPane ();//Creamos el jOptionPane
	            JOptionPane.showMessageDialog(op, "Has creado el periodico "+revista.getCodigo()); 
				
				}
			
				
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				catch(NumberFormatException ex) {
		    		ex.printStackTrace();
		    		
		    		 op=new MisJOptionPane ();//Creamos el jOptionPane
		    		 op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Revisa codigo ","Error", JOptionPane.WARNING_MESSAGE);  

					   op.setVisible(true);
				//	ventana.setVisible(false); con esto cerramos la ventana
					op.setVisible(false);
					
					
				}
		}
		});
	
	}

}
