package graficos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

import objetosVivos.Gestor;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class InsertarGestor extends JPanel {
	private JTextField txtNif;//texto donde escribimos el nif
	private JTextField txtNombre;//texto donde escribimos el Nombre
	private JTextField txtEdad;//texto donde escribimos la edad
	private JTextField txtApellido;//texto donde se escribe el apellido
	private GraficoVentana v;//Jframe de la ventana principal
	private Gestor creadorGestor;//Creamos un gestor interno para poder ir creando los gestores
	private MisJOptionPane op;//Dialogos de informacion

	/**
	 * Create the panel.
	 */
	public InsertarGestor(GraficoVentana ventana) {
		this.v=ventana;
		setLayout(new GridLayout(2, 6, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Rellene los textos para crear Gestor");
		add(lblNewLabel);
		
		txtNif = new JTextField();
		txtNif.setText("Nif");
		add(txtNif);
		txtNif.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setText("Edad");
		add(txtEdad);
		txtEdad.setColumns(10);
		
		JButton btnNewButton = new JButton("Aplicar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String edad=txtEdad.getText();
				try {
				
				byte edadNumerica=Byte.valueOf(edad);
				
					creadorGestor=new Gestor(txtNombre.getText(),txtApellido.getText(),(byte)edadNumerica,txtNif.getText());
					creadorGestor.insertarGestor(creadorGestor.getDni(),creadorGestor.getNombre(),  creadorGestor.getApellido(), creadorGestor.getEdad());
					
					lblNewLabel.setText("Rellene los textos para crear Gestor");
					 op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Has creado el gestor con Nif "+creadorGestor.getDni());  
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				catch(NumberFormatException ex) {
		    		ex.printStackTrace();
		    		
		    		 op=new MisJOptionPane ();//Creamos el jOptionPane
		    		 op=new MisJOptionPane ();//Creamos el jOptionPane
			            JOptionPane.showMessageDialog(op, "Te has equivocado en la edad","Error", JOptionPane.WARNING_MESSAGE);  

					   op.setVisible(true);
				//	ventana.setVisible(false); con esto cerramos la ventana
					op.setVisible(false);
					
					
				}
			}
		});
		
			
		add(btnNewButton);
		
	
	}

}
