package graficos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

import objetosVivos.Gestor;
import objetosVivos.Persona;
import objetosVivos.Usuario;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JRadioButton;

public class InsertarGestor extends JPanel {
	private JTextField txtNif;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtApellido;
	private GraficoVentana v;//Grafico de la ventana
	private MisJOptionPane op;//Dialogos de texto
	private JRadioButton rbUsuario;
	private JRadioButton rbGestor;
	private JLabel lblOpcion;
	private Persona gest;
	private Gestor gestor =new Gestor();
	/**
	 * Create the panel.
	 */
	public InsertarGestor(GraficoVentana ventana) {
		this.v=ventana;
		setLayout(new GridLayout(0, 3, 0, 0));
		
		rbUsuario = new JRadioButton("Usuario");
		rbUsuario.setSelected(true);
		add(rbUsuario);
		
		rbGestor = new JRadioButton("Gestor");
		add(rbGestor);
		
		lblOpcion = new JLabel("Elige la opcion a insertar");
		add(lblOpcion);
		
		JLabel lblNewLabel = new JLabel("Rellene los textos");
		add(lblNewLabel);
		
		txtNif = new JTextField();
		txtNif.setText("Nif");
		add(txtNif);
		txtNif.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Insertar");
		
		
			add(btnNewButton);
			
			txtEdad = new JTextField();
			txtEdad.setText("Edad");
			add(txtEdad);
			txtEdad.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		add(txtApellido);
		txtApellido.setColumns(10);

		ButtonGroup bg=new ButtonGroup();
		bg.add(rbGestor);;
		bg.add(rbUsuario);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rbGestor.isSelected()){
					try {
						byte edad=Byte.valueOf(txtEdad.getText());
						if(edad<16) {
							txtEdad.setText("edad");
							 edad=Byte.valueOf(txtEdad.getText());
						}
						//Creamos un gestor
						 gest=new Gestor(txtNombre.getText(),txtApellido.getText(),Byte.parseByte(txtEdad.getText()),txtNif.getText());
			//			 (Circulo)miObjeto)
			((Gestor)gestor).insertarGestor(gest.getDni(), gest.getNombre(), gest.getApellido(), gest.getEdad());
		
							 op=new MisJOptionPane ();//Creamos el jOptionPane
							 
					            JOptionPane.showMessageDialog(op, "Gestor creado con Nif "+gest.getDni());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NumberFormatException ex) {
							ex.printStackTrace();
							 op=new MisJOptionPane ();//Creamos el jOptionPane
		  JOptionPane.showMessageDialog(op, "Edad invalida debe de ser >=16","Error", JOptionPane.WARNING_MESSAGE);
				}
				  
  
				}else if(rbUsuario.isSelected()) {
					try {
						byte edad=Byte.valueOf(txtEdad.getText());
						if(edad<16) {
							txtEdad.setText("edad");
							 edad=Byte.valueOf(txtEdad.getText());
						}
						//Creamos un objeto Usuario
						 gest=new Usuario(txtNombre.getText(),txtApellido.getText(),Byte.parseByte(txtEdad.getText()),txtNif.getText());
						 gestor.insertarUsuario((Usuario)gest);//Lo insertamos
							 op=new MisJOptionPane ();//Creamos el jOptionPane
							 
					            JOptionPane.showMessageDialog(op, "Usuario creado con Nif "+gest.getDni());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NumberFormatException ex) {
							ex.printStackTrace();
							 op=new MisJOptionPane ();//Creamos el jOptionPane
		  JOptionPane.showMessageDialog(op, "Edad invalida debe de ser >=16","Error", JOptionPane.WARNING_MESSAGE);
				}
				}
			}
		});
		

		

	}

}
