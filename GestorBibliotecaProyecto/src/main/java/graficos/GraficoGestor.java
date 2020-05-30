package graficos;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraficoGestor extends JPanel {
	private GraficoVentana v;

	/**
	 * Create the panel.
	 */
	public GraficoGestor(GraficoVentana ventana) {
		this.v=ventana;
		setLayout(new MigLayout("", "[123px][123px][123px][123px]", "[100px][100px][100px]"));
		
		JLabel lblNewLabel_1 = new JLabel("Insertar Gestor/ Usuarios");
		add(lblNewLabel_1, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("Borrar Lectura");
		add(lblNewLabel, "cell 1 0,grow");
		
		JLabel lblNewLabel_3 = new JLabel("Insertar Lectura");
		add(lblNewLabel_3, "cell 2 0,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Altas/Bajas-Usuarios");
		add(lblNewLabel_2, "cell 3 0,grow");
		
		JRadioButton rbOpcion1 = new JRadioButton("Opcion 1");
		rbOpcion1.setSelected(true);
		add(rbOpcion1, "cell 0 1,grow");
		
		JRadioButton rbOpcion2 = new JRadioButton("Opcion 2");
		add(rbOpcion2, "cell 1 1,grow");
		
		JRadioButton rbOpcion3 = new JRadioButton("Opcion 3");
		add(rbOpcion3, "cell 2 1,grow");
		
		JRadioButton rbOpcion4 = new JRadioButton("Opcion 4");
		add(rbOpcion4, "cell 3 1,grow");
		
		JButton btnNewButton_1 = new JButton("Aplicar");
		
		add(btnNewButton_1, "cell 0 2 4 1,grow");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rbOpcion1);
		bg.add(rbOpcion2);
		bg.add(rbOpcion3);
		bg.add(rbOpcion4);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (rbOpcion1.isSelected()) {
					ventana.cargarGraficoInsertarGestor();
				}else if(rbOpcion2.isSelected()) {
					ventana.cargarGraficoBorrarLectura();
				}else if(rbOpcion3.isSelected()) {
					ventana.cargarGraficoInsertarLectura();
				}else if(rbOpcion4.isSelected()) {
					ventana.cargarGraficoEstadoUsuario();
				}
			}
		});
		
	}

}
