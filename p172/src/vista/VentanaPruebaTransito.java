package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import hilos.HiloVehiculo;
import modelo.Via;

public class VentanaPruebaTransito extends JFrame {
	private PanelVia panelVia;
	private PanelOpciones panelOpciones;
	private Via modelo;

	public VentanaPruebaTransito() {
		// TODO Auto-generated constructor stub

		setModelo(new Via());
		panelVia = new PanelVia(this);
		panelOpciones = new PanelOpciones(this);
		setTitle("SECRETARIA DE MOVILIDAD");
		setSize(PanelVia.LARGO_VIA, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		add(panelVia, BorderLayout.CENTER);
		add(panelOpciones, BorderLayout.SOUTH);

	}

	public void moverVehiculo() {
		HiloVehiculo hilo = new HiloVehiculo(modelo.darVehiculo(), this);
		hilo.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VentanaPruebaTransito ven = new VentanaPruebaTransito();
		ven.setVisible(true);
	}

	public Via getModelo() {
		return modelo;
	}

	public void setModelo(Via modelo) {
		this.modelo = modelo;
	}

	public PanelVia getPanelVia() {
		return panelVia;
	}

	public void setPanelVia(PanelVia panelVia) {
		this.panelVia = panelVia;
	}

	public PanelOpciones getPanelOpciones() {
		return panelOpciones;
	}

	public void setPanelOpciones(PanelOpciones panelOpciones) {
		this.panelOpciones = panelOpciones;
	}

}
