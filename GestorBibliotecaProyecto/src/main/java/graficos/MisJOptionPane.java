package graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MisJOptionPane extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public MisJOptionPane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		
		
		   JOptionPane op=new JOptionPane("Bienvenido");//Creamos el jOptionPane
           JDialog dialog = op.createDialog(this, "Cabecera");//lo metemos dentro de un dialogo
         
            dialog.setVisible(false);//lo  hacemos visible
            
            //Muestra una alerta
            
            
            //icono que nos aparece
          /*  
            //MUESTRA UN MSJ Y EN CASO DE QUE PINCHE UN BOTON PASARA ALGO
            int confirmado=JOptionPane.showConfirmDialog(this, "Mensaje", "Cabecera", op.YES_NO_CANCEL_OPTION);  //creamos una ventana para
            //confirmacion del usuario
            //Hacemos varios if y en caso de que el usuario pinche en aceptar, no etc muestra el siguiente mensaje
            if(confirmado==JOptionPane.OK_OPTION) {
            	lblNewLabel.setText("Confirmado");
            }else if(confirmado==JOptionPane.NO_OPTION) {
            	lblNewLabel.setText("No...");
            }else if(confirmado==JOptionPane.CANCEL_OPTION) {
            	lblNewLabel.setText("Cancelado...");
            }*/
		
            
            
            //Mediante esta funcion podemos mostrar un input para escribir y en jFrame colocando una etiqueta mostramos el mensaje del input
	//String mensaje=	JOptionPane.showInputDialog(this,"Di tu nombre y entra:","Hola",JOptionPane.INFORMATION_MESSAGE);//nos muestra un input y podemos escribir
		
	//	lblNewLabel.setText("Bienvenido "+mensaje);
		
	}

}
