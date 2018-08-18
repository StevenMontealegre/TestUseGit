package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import mundo.Fifa;
import mundo.Jugador;
import mundo.Seleccion;

public class InterfazPrincipal extends JFrame {

	private PanelSelecciones panelSelecciones;
	private PanelJugadores panelJugadores;
	private PanelInfoJugador panelInfo;
	private PanelAgregarSeleccion panelAgregarSel;
	private PanelAgregarJugador panelAgregarJug;
	private PanelVisualizar panelVisualizar;
	private PanelOpcionesVisual panelOpcionesVisualizar;
	private Fifa modelo;

	public InterfazPrincipal() {
		// TODO Auto-generated constructor stub
		setModelo(new Fifa());
		setTitle("Copa Mundial de la FIFA RUSIA 2018");
		setLayout(new GridLayout(1, 3));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1400, 450);
		setResizable(false);

		panelSelecciones = new PanelSelecciones(this);
		panelJugadores = new PanelJugadores(this);
		panelInfo = new PanelInfoJugador(this);
		panelAgregarSel = new PanelAgregarSeleccion(this);
		panelAgregarJug = new PanelAgregarJugador(this);
		setPanelVisualizar(new PanelVisualizar(this));
		setPanelOpcionesVisualizar(new PanelOpcionesVisual(this));
		add(panelSelecciones);
		add(panelJugadores);
		add(panelInfo);
	}

	public PanelAgregarJugador getPanelAgregarJug() {
		return panelAgregarJug;
	}

	public void setPanelAgregarJug(PanelAgregarJugador panelAgregarJug) {
		this.panelAgregarJug = panelAgregarJug;
	}

	public PanelSelecciones getPanelSelecciones() {
		return panelSelecciones;
	}

	public void setPanelSelecciones(PanelSelecciones panelSelecciones) {
		this.panelSelecciones = panelSelecciones;
	}

	public PanelJugadores getPanelJugadores() {
		return panelJugadores;
	}

	public void setPanelJugadores(PanelJugadores panelJugadores) {
		this.panelJugadores = panelJugadores;
	}

	public PanelInfoJugador getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(PanelInfoJugador panelInfo) {
		this.panelInfo = panelInfo;
	}

	public PanelAgregarSeleccion getPanelAgregarSel() {
		return panelAgregarSel;
	}

	public void setPanelAgregarSel(PanelAgregarSeleccion panelAgregarSel) {
		this.panelAgregarSel = panelAgregarSel;
	}

	public void mostrarPanelVisualizar() {
		panelVisualizar.setVisible(true);

	}

	public void agregarJugadorASeleccion() {
		Jugador jug = panelAgregarJug.getDatosJugador();
		String nombre_seleccion = panelSelecciones.getTxtVariableSeleccion().getText();
		Seleccion sel = modelo.buscarEnArbolPorNombre(nombre_seleccion);
		sel.agregarJugador(jug);

	}

	@Override
	public Image getIconImage() {
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/lobo.png"));
		return retValue;
	}

	public void mostrarPanelAgregarSeleccion() {
		panelAgregarSel.setVisible(true);
	}

	public void mostrarPanelAgregarJugador() {
		panelAgregarJug.setVisible(true);
	}

	public Fifa getModelo() {
		return modelo;
	}

	public void setModelo(Fifa modelo) {
		this.modelo = modelo;
	}

	public static void main(String[] args) {
		InterfazPrincipal p = new InterfazPrincipal();
		p.setVisible(true);
	}

	public PanelVisualizar getPanelVisualizar() {
		return panelVisualizar;
	}

	public void setPanelVisualizar(PanelVisualizar panelVisualizar) {
		this.panelVisualizar = panelVisualizar;
	}

	public PanelOpcionesVisual getPanelOpcionesVisualizar() {
		return panelOpcionesVisualizar;
	}

	public void setPanelOpcionesVisualizar(PanelOpcionesVisual panelOpcionesVisualizar) {
		this.panelOpcionesVisualizar = panelOpcionesVisualizar;
	}

}
