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

	/**
	 * Create the panel.
	 */
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
	
	}

}
