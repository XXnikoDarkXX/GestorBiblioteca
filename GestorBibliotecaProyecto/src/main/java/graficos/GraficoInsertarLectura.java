package graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import net.miginfocom.swing.MigLayout;

public class GraficoInsertarLectura extends JPanel {
	private JLabel lblNewLabel_1;
	private JButton btnOpcion;
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
=======

public class GraficoInsertarLectura extends JPanel {
=======

public class GraficoInsertarLectura extends JPanel {
>>>>>>> parent of 631a0c6... Grafico Agregar Lectura y InsertarLibros
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JSeparator separator;
<<<<<<< HEAD
>>>>>>> parent of 631a0c6... Grafico Agregar Lectura y InsertarLibros
=======
>>>>>>> parent of 631a0c6... Grafico Agregar Lectura y InsertarLibros

	/**
	 * Create the panel.
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	public GraficoInsertarLectura(GraficoVentana ventana) {
		this.v=ventana;
		lblNewLabel_1 = new JLabel("Elige la opcion Que vas a usar:");
		
		txtCodigo = new JTextField();
		txtCodigo.setText("Codigo");
		txtCodigo.setColumns(10);
		setLayout(new MigLayout("", "[225px][225px]", "[64px][64px][64px][64px][64px]"));
		add(lblNewLabel_1, "cell 0 0,grow");
		
		rbLibro = new JRadioButton("Libro");
		rbLibro.setSelected(true);
		add(rbLibro, "cell 1 0,grow");
		
		rbRevista = new JRadioButton("Revista");
		add(rbRevista, "cell 0 1,grow");
		
		rbPeriodico = new JRadioButton("Periodico");
		add(rbPeriodico, "cell 1 1,grow");
		
		lblLectura = new JLabel("Rellene los siguientes campos");
		add(lblLectura, "cell 0 2,grow");
		
		btnOpcion = new JButton("Aplicar Opcion");
		
		add(btnOpcion, "cell 1 2,grow");
		add(txtCodigo, "cell 0 3,grow");
		
		
		
		
		label = new JLabel("");
		add(label, "cell 1 3,grow");
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbLibro);
		bg.add(rbPeriodico);
		bg.add(rbRevista);
		
		btnLectura = new JButton("Borrar");
		
		add(btnLectura, "cell 0 4 2 1,grow");
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
				
					
				
				
				 op=new MisJOptionPane ();//Creamos el jOptionPane
				 
		            JOptionPane.showMessageDialog(op, "Has creado el periodico "+periodico.getCodigo());
		            
				}else if(rbRevista.isSelected()) {
					
			byte codigo=Byte.valueOf(txtCodigo.getText());//Mediante este metodo pasamos un String que tenga numeros a un byte
			
		
			
			
			 op=new MisJOptionPane ();//Creamos el jOptionPane
	            JOptionPane.showMessageDialog(op, "Has creado el periodico "); 
				
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
		});;
		
		/**
		 * Mediante este boton aplicacamos los radiobutoon y en los textos ponemos una guia de que debe incluirse
		 */
		btnOpcion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbLibro.isSelected()) {
				
				txtCodigo.setText("Codigo de libro");
				
					
				}else if(rbPeriodico.isSelected()) {
					
					txtCodigo.setText("Codigo de Periodico");
				
					
					
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
	
=======
	public GraficoInsertarLectura() {
		setLayout(new GridLayout(4, 6, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Inserta Libro");
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		add(btnNewButton);
		
		separator = new JSeparator();
		add(separator);
		
		textField_3 = new JTextField();
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_9 = new JTextField();
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_8 = new JTextField();
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_12 = new JTextField();
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_11 = new JTextField();
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_14 = new JTextField();
		add(textField_14);
		textField_14.setColumns(10);
		
		textField_10 = new JTextField();
		add(textField_10);
		textField_10.setColumns(10);
		
		textField_6 = new JTextField();
		add(textField_6);
		textField_6.setColumns(10);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_13 = new JTextField();
		add(textField_13);
		textField_13.setColumns(10);

>>>>>>> parent of 631a0c6... Grafico Agregar Lectura y InsertarLibros
=======
	public GraficoInsertarLectura() {
		setLayout(new GridLayout(4, 6, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Inserta Libro");
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		add(btnNewButton);
		
		separator = new JSeparator();
		add(separator);
		
		textField_3 = new JTextField();
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_9 = new JTextField();
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_8 = new JTextField();
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_12 = new JTextField();
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_11 = new JTextField();
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_14 = new JTextField();
		add(textField_14);
		textField_14.setColumns(10);
		
		textField_10 = new JTextField();
		add(textField_10);
		textField_10.setColumns(10);
		
		textField_6 = new JTextField();
		add(textField_6);
		textField_6.setColumns(10);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_13 = new JTextField();
		add(textField_13);
		textField_13.setColumns(10);

>>>>>>> parent of 631a0c6... Grafico Agregar Lectura y InsertarLibros
	}

}
