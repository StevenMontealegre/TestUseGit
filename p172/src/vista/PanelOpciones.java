package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener {

	private JButton btnStart;
	private JButton btnStop, btnDatos;
	public final static String START = "start";
	public final static String STOP = "stop";
	public final static String DATOS = "datos";
	private VentanaPruebaTransito principal;

	public PanelOpciones(VentanaPruebaTransito p) {
		// TODO Auto-generated constructor stub
		principal = p;
		btnStart = new JButton("START");
		btnStart.setActionCommand(START);
		btnStart.addActionListener(this);
		btnStop = new JButton("STOP");
		btnStop.setActionCommand(STOP);
		btnStop.addActionListener(this);
		btnDatos = new JButton("DATOS");
		btnDatos.setActionCommand(DATOS);
		btnDatos.addActionListener(this);
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 10;
		c.gridy = 30;
		btnStart.setBackground(Color.GREEN);
		add(btnStart, c);
		c.gridx = 60;
		c.gridy = 30;
		btnStop.setBackground(Color.RED);
		add(btnStop, c);
		c.gridx = 100;
		c.gridy = 30;
		add(btnDatos, c);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase(START)) {
			principal.getModelo().darVehiculo().setDetenido(false);
			principal.getModelo().darVehiculo().setPosX(0);
			principal.moverVehiculo();

		}
		if (comando.equalsIgnoreCase(STOP)) {
			principal.getModelo().darVehiculo().setDetenido(true);
			System.out.println(principal.getModelo().darVehiculo().getPosX());
			System.out.println(principal.getPanelVia().getDistancia());

		}
		if (comando.equalsIgnoreCase(DATOS)) {
			principal.getModelo().generarCertificado();
			
		}
	}

}
