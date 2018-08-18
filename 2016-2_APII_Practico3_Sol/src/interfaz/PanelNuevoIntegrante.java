package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelNuevoIntegrante extends JPanel implements ActionListener{
	private JLabel labNombre;
	private JLabel labEdad;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JButton butAgregar;
	
	public final static String AGREGAR = "AGREGAR";
	
	private InterfazFamilia principal;
	
	public PanelNuevoIntegrante(InterfazFamilia ventana) {
		principal = ventana;
		setBorder(new TitledBorder("Nuevo Integrante"));
		setLayout(new FlowLayout());
		labNombre = new JLabel("Nombre:");
		labEdad = new JLabel("Edad:");
		txtNombre = new JTextField(6);
		txtEdad = new JTextField(3);
		
		butAgregar = new JButton("Agregar");
		butAgregar.setActionCommand(AGREGAR);
		butAgregar.addActionListener(this);
		
		add(labNombre);
		add(txtNombre);
		add(labEdad);
		add(txtEdad);
		add(butAgregar);
	}
	
	public String darNombre(){
		return txtNombre.getText();
	}

	public String darEdad(){
		return txtEdad.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(AGREGAR)){
			principal.agregarIntegrante();
		}
	}
}
